package com.citizenweb.game.gameport.play;

import com.citizenweb.game.gameport.action.Action;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Player implements Play {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void performAction(Action<?> action) {
        //TODO to be implemented
    }

    @Override
    public String getName() {
        return this.name;
    }
}
