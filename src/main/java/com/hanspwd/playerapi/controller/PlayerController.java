package com.hanspwd.playerapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hanspwd.playerapi.model.Player;
import com.hanspwd.playerapi.service.PlayerService;

import jakarta.validation.Valid;

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
    public ResponseEntity<Player> getPlayerById(@Valid @PathVariable int id) {
        Player player = playerService.getPlayerById(id).get();
        return ResponseEntity.ok(player);
    }
    
    @PostMapping()
    public ResponseEntity<String> postPlayer(@Valid @RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return ResponseEntity.ok("Jugador con nombre " + newPlayer.getUsername() + " creado con éxito.");
    }

    @PostMapping("bulk")
    public List<Player> postPlayers(@RequestBody List<Player> newPlayers) {
        return playerService.addPlayers(newPlayers);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> putPlayer(@Valid @PathVariable int id, @RequestBody Player player) {
        Player newPlayer = playerService.updatePlayerById(id, player);
        return ResponseEntity.ok("Jugador " + newPlayer.getUsername() + "modificado con éxito.");
    }

    @PutMapping("{id}/changelevel/{newLevel}")
    public ResponseEntity<String> putMethodName(@Valid @PathVariable int id, @PathVariable Long newLevel) {
        Player player = playerService.updatePlayerLevel(id, newLevel);
        return ResponseEntity.ok("A la jugador " + player.getUsername() + " se le ha cambiado el nivel a " + newLevel + ".");
    }
    
}
