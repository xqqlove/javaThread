package com.yiwa.learnagain;

public class ThreadTest {
    public static void main(String[] args) {
        class MyThread extends Thread{
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
        //启动3个线程t1,t2,t3；每个线程各卖10张票！
        // 和上面的结果对比，并揣摩 “Runnable还可以用于“资源共享”。即，多个线程都是基于某个Runnable对象建立的，它们会共享Runnable对象上的资源”这句话
        MyThread myThread=new MyThread();
        MyThread myThread1=new MyThread();
        MyThread myThread2=new MyThread();

        myThread.start();
        myThread1.start();
        myThread2.start();
    }

}
