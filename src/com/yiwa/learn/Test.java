package com.yiwa.learn;

public class Test {
    public static void main(String[] args) {
//        SyncThread syncThread=new SyncThread();
//        Thread thread=new Thread(syncThread,"Sys1");
//        Thread thread1=new Thread(syncThread,"Sys2");
//        thread.start();
//        thread1.start();
        SyncThread syncThread1=new SyncThread();
        SyncThread syncThread2=new SyncThread();
        Thread thread2=new Thread(syncThread1,"Sys3");
        Thread thread3=new Thread(syncThread2,"Sys4");
        thread2.start();
        thread3.start();

//        Counter counter=new Counter();
//        Thread thread=new Thread(counter,"A");
//        Thread thread1=new Thread(counter,"B");
//        Thread thread2=new Thread(counter,"C");
//        thread.start();
//        thread1.start();
//        thread2.start();
    }
}
