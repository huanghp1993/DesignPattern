package com.hhp.design.dependency;

/**
 * Created by huanghaopeng on 16/8/10.
 */
public class EmailServiceImpl implements MessageService {
    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send email
        System.out.println("Email sent to "+rec+ " with Message="+msg);
    }
}
