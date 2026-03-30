package com.hanspwd.playerapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.hanspwd.playerapi.model.Player;

@Repository
public class PlayerRepository {
    
    private List<Player> players = new ArrayList<>();

    public List<Player> getAllPlayers() {
        return players;
    }

    public List<Player> getAllBannedPlayers() {
        return players.stream().filter(p -> p.isBanned() == true).toList();
    }

    public Optional<Player> getPlayerById(int id ) {
        return players.stream().filter(p -> p.getId() == id).findFirst();
    }

    public Player addPlayer(Player player) {
        players.add(player);
        return player;
    }

    public List<Player> addPlayers(List<Player> newPlayers) {
        players.addAll(newPlayers);
        return newPlayers;
    }

    public boolean removePlayer(int id) {
        return players.removeIf(p -> p.getId() == id); 
    }

    // exp
    public boolean removePlayers(int[] ids) {
        if(ids.length == 0) {
            return false;
        }

        for (int id : ids) {
            removePlayer(id);
        }
        return true;
    }

    public Player updatePlayerById(int id, Player newPlayer) {
        Player oldPlayer = getPlayerById(id).get();
        oldPlayer.setUsername(newPlayer.getUsername());
        oldPlayer.setLevel(newPlayer.getLevel());
        oldPlayer.setBanned(newPlayer.isBanned());
        return oldPlayer;
    }
}
