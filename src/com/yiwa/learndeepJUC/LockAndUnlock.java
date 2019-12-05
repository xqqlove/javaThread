package com.yiwa.learndeepJUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndUnlock {
    static Lock lock = new ReentrantLock();//新建锁
    private static void numPrint(){
        lock.lock();
        try {
            for (int i=0;i<10;i++){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        new Thread("A"){
            public void run(){
                Thread.yield();//当前线程让步，加快切换线程
                numPrint();
            }
        }.start();
        new Thread("B"){
            public void run(){
                Thread.yield();
                numPrint();
            }
        }.start();
    }
}
