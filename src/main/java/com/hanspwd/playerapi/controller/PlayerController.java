package com.hanspwd.playerapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hanspwd.playerapi.model.Player;
import com.hanspwd.playerapi.service.PlayerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/players")
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;

    @GetMapping()
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("banned")
    public List<Player> getAllBannedPlayers() {
        return playerService.getAllBannedPlayers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }
    
    @PostMapping()
    public Player postPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @PostMapping("bulk")
    public List<Player> postPlayers(@RequestBody List<Player> newPlayers) {
        return playerService.addPlayers(newPlayers);
    }

    @PutMapping("{id}")
    public Player putPlayer(@PathVariable int id, @RequestBody Player player) {
        return playerService.updatePlayerById(id, player);
    }

    @PutMapping("{id}/level/{newLevel}")
    public Player putMethodName(@PathVariable int id, @PathVariable Long newLevel) {
        return playerService.updatePlayerLevel(id, newLevel);
    }
    
}
