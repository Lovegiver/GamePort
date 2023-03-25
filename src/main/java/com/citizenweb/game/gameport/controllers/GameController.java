package com.citizenweb.game.gameport.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GameController {

    @GetMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello guys").log();
    }

}
