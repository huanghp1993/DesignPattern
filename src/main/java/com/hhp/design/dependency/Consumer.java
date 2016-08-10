package com.hhp.design.dependency;

/**
 * Created by huanghaopeng on 16/8/10.
 */
public interface Consumer {
    void processMessages(String msg, String rec);
}
