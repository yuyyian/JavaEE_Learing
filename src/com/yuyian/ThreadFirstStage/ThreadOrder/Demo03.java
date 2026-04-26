package com.yuyian.ThreadFirstStage.ThreadOrder;
//sleep wait的区别:
//1.wait的设计实践就是为了提前唤醒的(notify),设置超时时间是后手;
//  sleep的设计就是为了到时间唤醒,虽然可以通过interrupt()提前唤醒,但这样的唤醒是会产生异常的

//2.wait需要搭配锁来使用,且执行时会先释放锁
//  sleep不需要搭配锁来使用,sleep在synchronized内部执行时,是不会释放锁的
//实际开发中,wait使用频率大于sleep
public class Demo03 {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        System.out.println("之前");
        synchronized (locker) {
            locker.wait(1000);
        }
        System.out.println("之后");
    }
}
