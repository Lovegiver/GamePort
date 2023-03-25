package com.citizenweb.game.gameport.controllers;

import com.citizenweb.game.gameport.play.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GameController {

    private final Game game;

    public GameController(Game game) {
        this.game = game;
    }

    @GetMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello guys").log();
    }

    @GetMapping("/new-game/{playerId}")
    public ResponseEntity<Mono<Game>> obtainGameId(@PathVariable("playerId") long playerId) {
        return ResponseEntity.ok(Mono.just(this.game));
    }

}
