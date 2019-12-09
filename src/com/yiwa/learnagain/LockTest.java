package com.yiwa.learnagain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

class ThreadTicket implements Runnable{
    private int ticket=100;
    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
           try {
               lock.lock();
               if (ticket > 0) {

                   try {
                       sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName() + "售票：票号为" + ticket--);
               } else {
                   break;
               }
           }finally {
               lock.unlock();
           }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        ThreadTicket threadTicket=new ThreadTicket();
        Thread t1=new Thread(threadTicket,"A");
        Thread t2=new Thread(threadTicket,"B");
        Thread t3=new Thread(threadTicket,"C");
        t1.start();
        t2.start();
        t3.start();

    }


}
