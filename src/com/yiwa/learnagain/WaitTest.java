package com.yiwa.learnagain;

import static java.lang.Thread.sleep;

public class WaitTest {
    public static void main(String[] args) {

        class ThreadA extends Thread {
            public ThreadA(String name) {
                super(name);
            }

            public void run() {
                synchronized (this) {
//                    notify();
                    System.out.println(Thread.currentThread().getName() + "线程正在执行！");
                    System.out.println(Thread.currentThread().getName() + "现在准备执行notify()");
                    notify();
                    System.out.println(Thread.currentThread().getName() + "休眠后");

                }
            }
        }
        Thread t1 = new ThreadA("T1");
        synchronized (t1) {
            System.out.println(Thread.currentThread().getName() + " start T1");
            t1.start();
            try {
                sleep(3000);
                System.out.println(Thread.currentThread().getName() + "执行wait()");
                t1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " continue");
        }
    }
}
