package com.citizenweb.game.gameport.action;

import com.citizenweb.game.gameport.play.Player;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.UUID;

@EqualsAndHashCode
public abstract class AbstractAction implements Action<ActionType> {

    private final UUID id = UUID.fromString(UUID.randomUUID().toString());
    private final ActionType actionType;
    private final Player player;
    private final String description;
    private final ZonedDateTime timestamp;

    protected AbstractAction(ActionType actionType, Player player, String description, ZonedDateTime timestamp) {
        this.actionType = actionType;
        this.player = player;
        this.description = description;
        this.timestamp = timestamp;
    }

}
