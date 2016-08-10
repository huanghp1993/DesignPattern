package com.hhp.design.dependency;

/**
 * Created by huanghaopeng on 16/8/10.
 */
public class EmailService {

    public void sendEmail(String message, String receiver){
        //logic to send email
        System.out.println("Email sent to "+receiver+ " with Message="+message);
    }
}
