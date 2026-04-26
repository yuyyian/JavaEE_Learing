package com.yuyian.ThreadFirstStage.ThreadCase.Timer_IMPORTANT;

import java.util.Timer;
import java.util.TimerTask;

//定时器 => 非常重要的组件,类似与闹钟
//编程中有些任务是不需要立即执行的,而是等到一定时间再去执行
//java标准库中提供了timer实现类
public class Demo01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器执行任务3000");
            }
        },3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器执行任务2000");
            }
        },2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器执行任务1000");
            }
        },1000);

        System.out.println("程序启动");
    }
}
