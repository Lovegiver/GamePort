package com.citizenweb.game.gameport.play;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Log
@Service
public class GameServiceImpl implements GameService {

    private final Set<Game> activeGames = ConcurrentHashMap.newKeySet();
    private final AtomicReference<ConcreteGame> buildingGame = new AtomicReference<>(new ConcreteGame());

    @Override
    public synchronized Mono<String> addPlayer(Player player) {
        if (this.buildingGame.get() == null) {
            this.buildingGame.set(new ConcreteGame());
        }
        if (!this.buildingGame.get().canAddNewPlayer()) {
            this.activeGames.add(this.buildingGame.get());
            this.buildingGame.set(new ConcreteGame());
        }
        this.buildingGame.get().addPlayer(player);
        Mono<String> gameId = this.buildingGame.get().gameId();
        Mono<String> wording = Mono.just("Player [ %s ] added to Game [ %s ]");
        return wording.zipWith(gameId, (m1,m2) -> String.format(m1, player.getName(), m2));
    }

}
