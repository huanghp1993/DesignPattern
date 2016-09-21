package com.hhp.concurrent;

import java.util.concurrent.*;

/**
 *
 * Created by huanghaopeng on 16/9/20.
 */
public class FutureTaskDemo2{
    public static void main(String[] args) {
        Callable<Boolean> call = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Thread.sleep(4000);
                return true;
            }
        };
        FutureTask<Boolean> futureTask = new FutureTask<Boolean>(call);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(futureTask);
        try {
            Boolean result = futureTask.get();
            System.out.println("result"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
