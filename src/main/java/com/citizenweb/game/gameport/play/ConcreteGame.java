package com.citizenweb.game.gameport.play;

import lombok.Getter;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class ConcreteGame implements Game {

    private final UUID gameId = UUID.randomUUID();
    private final List<Player> players = new ArrayList<>();
    private final AtomicInteger maxPlayers = new AtomicInteger(2);

    @Override
    public Mono<String> gameId() {
        return Mono.just(this.gameId.toString());
    }

    @Override
    public Mono<Integer> gamePlayersNumber() {
        return Mono.just(this.players.size());
    }

    @Override
    public boolean canAddNewPlayer() {
        return this.players.size() < this.maxPlayers.get();
    }

    @Override
    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
