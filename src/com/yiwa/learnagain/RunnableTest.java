package com.yiwa.learnagain;

public class RunnableTest {
    public static void main(String[] args) {
        class MyRunnable implements Runnable{
            private int ticket=10;
            @Override
            public void run() {
                for (int i=0;i<20;i++){
                    if (this.ticket>0){
                        System.out.println(Thread.currentThread().getName()+"卖票：ticket"+this.ticket--);
                    }
                }
            }
        }
        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！这说明它们是共享了MyRunnable接口的。
        MyRunnable myRunnable=new MyRunnable();
        Thread t1=new Thread(myRunnable);
        Thread t2=new Thread(myRunnable);
        Thread t3=new Thread(myRunnable);
        Thread t4=new Thread(myRunnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
