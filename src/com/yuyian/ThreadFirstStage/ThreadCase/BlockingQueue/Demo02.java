package com.yuyian.ThreadFirstStage.ThreadCase.BlockingQueue;
//生产消费模式

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Demo02 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new LinkedBlockingDeque<>(5);
        Thread producer = new Thread(() -> {
            try{
                int count = 0;
                while(true){
                    bq.put("" + count);
                    System.out.println("加入了一个元素:" + count);
                    count++;
                    Thread.sleep(1000);
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try{
                while(true){
                    String elem = bq.take();
                    System.out.println("取出一个元素" + elem);
                    Thread.sleep(5000);
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

    }
}
