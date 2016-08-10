package com.hhp.design.dependency;

/**
 * Created by huanghaopeng on 16/8/10.
 */
public class SMSServiceImpl implements MessageService {
    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send SMS
        System.out.println("SMS sent to "+rec+ " with Message="+msg);
    }
}
