package com.yiwa.learndeepJUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        class MyRunnable implements Runnable{
            private int a=5;
            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 10; i++) {
                        if (this.a > 0) {
                            System.out.println(Thread.currentThread().getName() + " a的值：" + this.a--);
                        }
                    }
                }
            }
        }
        ExecutorService exec= Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            exec.execute(new MyRunnable());
        }
        exec.shutdown();
    }
}
