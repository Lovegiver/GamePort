package com.citizenweb.game.gameport.controllers;

import com.citizenweb.game.gameport.play.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") long id) {
        return ResponseEntity.ok(new Player("Fred"));
    }
}
