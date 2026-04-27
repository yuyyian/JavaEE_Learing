package com.yuyian.Thread.ThreadFirstStage.ThreadCase.ThreadPool_IMPORTANT;

// 自行实现一个简单的线程池,只实现一个"固定线程数目"的线程池

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyFixedThreadPool{
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public MyFixedThreadPool(int n){
        for(int i=0;i<n;i++){
            Thread t = new Thread(() ->{
              //每个线程完成的任务就是从队列中取出任务,并执行
                while(true){
                    try {
                        Runnable task = queue.take();//如果队列里面没有任务的话就会阻塞 直到其他线程执行submit()
                        task.run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.start();
        }

    }
    public void submit(Runnable task) throws InterruptedException {
        queue.put(task);
    }
}

public class Demo02 {
    public static void main(String[] args) throws InterruptedException {
        MyFixedThreadPool myFixedThreadPool = new MyFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int id = i;
            myFixedThreadPool.submit(()->{
                System.out.println("执行任务" + id);
            });
        }
    }
}
