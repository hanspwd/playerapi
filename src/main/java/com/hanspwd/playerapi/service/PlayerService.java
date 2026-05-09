package com.hanspwd.playerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanspwd.playerapi.exception.AlreadyExistInDbException;
import com.hanspwd.playerapi.exception.NoExistInDbException;
import com.hanspwd.playerapi.model.Player;
import com.hanspwd.playerapi.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    // REGLA DE NEGOCIO: usernames unicos.
    public Player createPlayer(Player player) {
        Player exists = playerRepository.findByUsername(player.getUsername()).orElse(null);
        if(exists != null) {
            throw new AlreadyExistInDbException("The player with "  + exists.getUsername() + " already exists in db.");   
        }
        return playerRepository.save(player);
    }

    public List<Player> readAll() {
        return playerRepository.findAll();
    }

    public Player readById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player readByUsername(String username) {
        return playerRepository.findByUsername(username).orElse(null);
    }

    public Player updatePlayer(Long id, Player player) {
        Player newPlayerData = playerRepository.findById(id).orElse(null);
        if(newPlayerData == null) {
            throw new NoExistInDbException("The player data with id " + id + " cannot be modified because it does not exist in the db.");
        }
        newPlayerData.setUsername(player.getUsername());
        newPlayerData.setLevel(player.getLevel());
        newPlayerData.setRol(player.getRol());
        return playerRepository.save(newPlayerData);
    }

    public void deletePlayer(Long id) {
        Player toDeletePlayer = playerRepository.findById(id).orElse(null);
        if(toDeletePlayer == null) {
            throw new NoExistInDbException("The user with id " + id + " cannot be deleted because it does not exist in the db.");
        }
        playerRepository.deleteById(id);
    }
}
