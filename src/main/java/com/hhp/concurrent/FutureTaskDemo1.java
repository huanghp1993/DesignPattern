package com.hhp.concurrent;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * FutureTask 的使用
 * Created by huanghaopeng on 16/9/20.
 */
public class FutureTaskDemo1 {
    public static void main(String[] args) {
        List<Future<Boolean>> futureTaskList = Lists.newArrayList();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        futureTaskList.add(executorService.submit(new MyCallable(1)));
        futureTaskList.add(executorService.submit(new MyCallable(4)));
        futureTaskList.add(executorService.submit(new MyCallable(-1)));
        for(Future future : futureTaskList){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyCallable implements Callable<Boolean>{
    private int number;

    public MyCallable(int number){
        this.number = number;
    }
    @Override
    public Boolean call() throws Exception {
        return this.number > 0;
    }
}
