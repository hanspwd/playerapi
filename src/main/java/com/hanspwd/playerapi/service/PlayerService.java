package com.hanspwd.playerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanspwd.playerapi.exceptions.PlayerNotFoundException;
import com.hanspwd.playerapi.model.Player;
import com.hanspwd.playerapi.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    
    public List<Player> getAllPlayers() {
        return playerRepository.getAllPlayers();
    } 

    public List<Player> getAllBannedPlayers() {
        return playerRepository.getAllBannedPlayers();
    }

    public Player getPlayerById(int id) {
        return playerRepository.getPlayerById(id).orElseThrow(
            () -> new PlayerNotFoundException("Player with id " + id + " not found"));
    }

    public Player addPlayer(Player player) {
        return playerRepository.addPlayer(player);
    } 

    public List<Player> addPlayers(List<Player> newPlayers) {
        return playerRepository.addPlayers(newPlayers);
    }

    public boolean removePlayer(int id) {
        return playerRepository.removePlayer(id);
    }

    // exp
    public boolean removePlayers(int[] ids) {
        return playerRepository.removePlayers(ids);
    }

    public Player updatePlayerById(int id, Player newPlayer) {
        return playerRepository.updatePlayerById(id, newPlayer);
    }

    public Player updatePlayerLevel(int id, long newLevel) {
        return playerRepository.updatePlayerLevel(id, newLevel);
    }
}
