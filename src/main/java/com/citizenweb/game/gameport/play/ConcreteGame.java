package com.citizenweb.game.gameport.play;

import lombok.Getter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Component
public class ConcreteGame implements Game {

    private final UUID gameId = UUID.randomUUID();
    private final List<Player> players = new ArrayList<>();

    @Override
    public Mono<String> gameId() {
        return Mono.just(this.gameId.toString());
    }

    @Override
    public Mono<Integer> gamePlayersNumber() {
        return Mono.just(this.players.size());
    }
}
