package com.hhp.design.dependency;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by huanghaopeng on 16/8/10.
 */
public class JunitTest {

    private MessageServiceInjector injector;
    @Before
    public void setUp(){
        //mock the injector with anonymous class
        injector = new MessageServiceInjector() {

            @Override
            public Consumer getConsumer() {
                //mock the message service
                return new MyDIApplication(new MessageService() {

                    @Override
                    public void sendMessage(String msg, String rec) {
                        System.out.println("Mock Message Service implementation");

                    }
                });
            }
        };
    }

    @Test
    public void test() {
        Consumer consumer = injector.getConsumer();
        consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
    }

    @After
    public void tear(){
        injector = null;
    }
}
