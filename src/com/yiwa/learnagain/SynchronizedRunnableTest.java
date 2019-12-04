package com.yiwa.learnagain;

import static java.lang.Thread.sleep;

public class SynchronizedRunnableTest {
    public static void main(String[] args) throws InterruptedException {
        class MyRunnable implements Runnable {
            private int count = 10;

            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 10; i++) {
                        try {
                            sleep(100);
                            System.out.println(Thread.currentThread().getName() + "线程计算结果：" + i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable, "A");
        Thread thread2 = new Thread(myRunnable, "B");
        Thread thread3 = new Thread(myRunnable, "C");

        thread2.start();
        thread1.start();
        thread3.start();
    }

}
