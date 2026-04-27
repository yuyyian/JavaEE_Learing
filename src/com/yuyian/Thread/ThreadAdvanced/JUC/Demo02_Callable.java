package com.yuyian.Thread.ThreadAdvanced.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo02_Callable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Callable带有泛型参数,参数类型就是返回值类型
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for  (int i = 0; i < 100; i++) {
                    result += i;
                }
                return result;
            }
        };
        //由于Thread并没有实现带有Callable参数类型的初始化方法,所以下面的写法是错误的
        //Thread t1 =  new Thread(callable);

        //我们要借助FutureTask,来传入Thread
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        //get会带有阻塞,直到任务执行完毕
        System.out.println(futureTask.get());
    }
}
