package com.citizenweb.game.gameport.play;

import com.citizenweb.game.gameport.action.Action;

/**
 * {@link Player}s capabilities interface
 */
public interface Play {

    void performAction(Action<?> action);

    String getName();

}
