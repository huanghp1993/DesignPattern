package com.hhp.concurrent.forkjoin;

import java.util.concurrent.*;

/**
 * 计数器分割
 * Created by huanghaopeng on 17/2/7.
 */
public class CountTask extends RecursiveTask<Integer>{

    private static final int THRESHOLD = 2;

    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute){
            for (int  i = start ; i <= end ;i++){
                sum += i;
                System.out.println(Thread.currentThread().getId());
            }
        }else{
            int middle = (start + end) / 2;

            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle + 1 , end);

            leftTask.fork();
            rightTask.fork();
            sum += leftTask.join();
            sum += rightTask.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask task = new CountTask(1,100);

        Future<Integer> result  = forkJoinPool.submit(task);
        try{
            System.out.println(result.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}
