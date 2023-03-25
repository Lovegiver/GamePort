package com.citizenweb.game.gameport.action;

public interface Action<T extends ActionType> {

    void performAction(T action);

}
