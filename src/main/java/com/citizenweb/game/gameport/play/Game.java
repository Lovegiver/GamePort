package com.citizenweb.game.gameport.play;

import reactor.core.publisher.Mono;

public interface Game {

    Mono<String> gameId();

    Mono<Integer> gamePlayersNumber();



}
