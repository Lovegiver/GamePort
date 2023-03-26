package com.citizenweb.game.gameport.controllers;

import com.citizenweb.game.gameport.play.GameService;
import com.citizenweb.game.gameport.play.Player;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello guys").log();
    }

    @PostMapping(value = "/addPlayer", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Mono<String>> addPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(this.gameService.addPlayer(player));
    }

}
