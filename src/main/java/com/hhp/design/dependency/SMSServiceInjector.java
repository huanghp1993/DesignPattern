package com.hhp.design.dependency;

/**
 * Created by huanghaopeng on 16/8/10.
 */
public class SMSServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }

}
