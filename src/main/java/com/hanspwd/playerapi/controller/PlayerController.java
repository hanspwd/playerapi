package com.hanspwd.playerapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanspwd.playerapi.model.Player;
import com.hanspwd.playerapi.service.PlayerService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<?> getPlayers() {
        List<Player> players = playerService.readAll();
        if(players.isEmpty()) {
            return ResponseEntity.status(404).body("Recursos no encontrados");
        }
        return ResponseEntity.ok(players);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getPlayersById(@Valid @PathVariable Long id) {
        Player player = playerService.readById(id);
        if(player == null) {
            return ResponseEntity.status(404).body("Jugador con id " + id + " no encontrado");
        }
        return ResponseEntity.ok(player);
    }

    @GetMapping("username/{username}")
    public ResponseEntity<?> getPlayersById(@Valid @PathVariable String username) {
        Player player = playerService.readByUsername(username);
        if(player == null) {
            return ResponseEntity.status(404).body("Jugador con username " + username + " no encontrado");
        }
        return ResponseEntity.ok(player);
    }

    @PostMapping
    public ResponseEntity<?> postPlayer(@Valid @RequestBody Player player) throws Exception{
        return ResponseEntity.status(201).body(playerService.createPlayer(player));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePlayer(@Valid @PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Jugador con id " + id + " eliminado con exito.");
    }
    
}
