package com.yuyian.ThreadFirstStage.ThreadOrder;
//线程本身是随机调度的(顺序不确定)
//join可以控制线程的结束顺序
//引出wait/notify 来解决线程之间的执行顺序
//旨在不涉及线程结束,使两个线程中的某些环节遵循一定的顺序
//另外,wait和notify也能解决线程饿死(一个线程反复调度)的问题 =>是Object这个类的方法,所以随便一个类都有这两个方法
public class Demo01 {
    // 使用 wait
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        System.out.println("wait之前");
        synchronized (object) {
            object.wait();//保证加锁对象和wait调用对象是同一个
            //阻塞会持续到其他线程调用notify
        }
        //IllegalMonitorStateException :此处的Monitor是指synchronized =>非法的锁状态
        //wait的第一件事就是释放锁,所以必须放到synchronized内部
        System.out.println("wait之后");

    }
}

