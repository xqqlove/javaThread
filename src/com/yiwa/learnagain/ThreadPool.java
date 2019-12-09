package com.yiwa.learnagain;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%2==0){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%2!=0){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(10);
        service.execute(new NumberThread());
        service.execute(new NumberThread1());
        service.shutdown();
    }
}
