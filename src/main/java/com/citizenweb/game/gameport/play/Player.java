package com.citizenweb.game.gameport.play;

import com.citizenweb.game.gameport.action.Action;

public class Player implements Play {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void performAction(Action<?> action) {

    }
}
