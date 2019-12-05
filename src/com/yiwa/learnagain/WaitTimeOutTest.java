package com.yiwa.learnagain;

public class WaitTimeOutTest {
    public static void main(String[] args) {
        class ThreadB extends Thread {
            public ThreadB(String name) {
                super(name);
            }

            public void run() {
                System.out.println(Thread.currentThread().getName() + " run");
                while (true)
                    ;
            }
        }
        ThreadB t2 = new ThreadB("T2");

        synchronized (t2) {
            try {
                System.out.println(Thread.currentThread().getName() + " start T2");
                t2.start();
                t2.wait(3000);
                System.out.println(Thread.currentThread().getName() + " contiune");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
