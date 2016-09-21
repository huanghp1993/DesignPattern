package com.hhp.tool;

import java.text.MessageFormat;

/**
 * Created by huanghaopeng on 16/9/20.
 */
public class MessageConvert {
    public static void main(String[] args) {
        String url = MessageFormat.format("register?username={0}&password={1}&valid={2}&bigAppId={3}&&appId={4}&device_key={5}&entype=2&channel={6}&version=1.0.0&plat=4","ceshi" ,"ceshi" ,"ceshi","ceshi","ceshi","ceshi");
        System.out.print(url);
    }
}
