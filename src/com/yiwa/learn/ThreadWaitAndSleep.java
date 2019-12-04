package com.yiwa.learn;

import static java.lang.Thread.sleep;

//https://blog.csdn.net/luoweifu/article/details/46613015
//https://blog.csdn.net/luoweifu/article/details/46595285
//https://blog.csdn.net/u012403290/article/details/64910926
class ThreadWAS implements Runnable {
    private String name;
    private Object prev;
    private Object self;

    public ThreadWAS(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }

                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadWaitAndSleep {
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadWAS pa = new ThreadWAS("A", c, a);
        ThreadWAS pb = new ThreadWAS("B", a, b);
        ThreadWAS pc = new ThreadWAS("C", b, c);

        new Thread(pa).start();
        sleep(1000);
        new Thread(pb).start();
        sleep(1000);
        new Thread(pc).start();
        sleep(1000);

    }
}
