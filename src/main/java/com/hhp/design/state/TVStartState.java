package com.hhp.design.state;

/**
 * Created by huanghaopeng on 16/9/14.
 */
public class TVStartState implements State {
    @Override
    public void doAction() {
        System.out.println("TV is turned ON");
    }
}
