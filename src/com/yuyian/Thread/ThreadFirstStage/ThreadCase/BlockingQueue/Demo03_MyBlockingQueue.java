package com.yuyian.Thread.ThreadFirstStage.ThreadCase.BlockingQueue;
//自己实现一个阻塞队列
//为了简单不去实现泛型参数版本
//假定里面的类型元素就是String
// 基于数组实现
class MyBlockingQueue{
    private String[] array = null;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private Object locker = new Object();//取操作和存操作需要放到同一个锁里面
    public MyBlockingQueue(int size){
        array = new String[size];
    }

    public void put(String elem) throws InterruptedException {
        synchronized (locker){
            while (size == array.length){//用while,是为了被唤醒后再做一次条件检验
                //达到上限
                locker.wait();
            }
            array[tail] = elem;
            tail = (tail + 1) % array.length;
            size++;
            locker.notify();//唤醒take阻塞
        }

    }

    public String take() throws InterruptedException {
        synchronized (locker){
            while(size == 0){
                locker.wait();
            }
            //取出队首元素
            String result = array[head];
            head = (head + 1) % array.length;
            size--;
            locker.notify();//唤醒put里面的堵塞
            return result;
        }

    }
}


//基于MyBlockingQueue来实现一个生产者消费者模型

public class Demo03_MyBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(5);
        Thread producer = new Thread(() -> {
            int count = 0;
            try{
                while(true){
                    myBlockingQueue.put("" + count);
                    System.out.println("生产一个元素:" + count);
                    count++;
                    Thread.sleep(100);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try{
                while(true){
                    String elem = myBlockingQueue.take();
                    System.out.println("消费了一个元素:" + elem);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
