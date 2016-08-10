package com.hhp.design.dependency;

/**
 * Created by huanghaopeng on 16/8/10.
 */
public class MyApplication {
    private EmailService email = null;

    public MyApplication(EmailService env){
        this.email = env;
    }

    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.email.sendEmail(msg, rec);
    }
}
