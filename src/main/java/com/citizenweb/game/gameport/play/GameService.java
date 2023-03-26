package com.citizenweb.game.gameport.play;

import reactor.core.publisher.Mono;

public interface GameService {

    Mono<String> addPlayer(Player player);

}
