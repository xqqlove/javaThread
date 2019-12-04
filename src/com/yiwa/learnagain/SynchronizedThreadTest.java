package com.yiwa.learnagain;

public class SynchronizedThreadTest {
    public static void main(String[] args) {
        class MyThread extends Thread {
            public MyThread(String name) {
                super(name);
            }

            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(100);
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        Thread t1=new MyThread("A");
        Thread t2=new MyThread("B");

        t1.start();
        t2.start();
    }
}
