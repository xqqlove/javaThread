package com.yiwa.learnagain;

class Thread1 implements Runnable{
    private int i=1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                notify();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    i++;
                } else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


public class ThreadCommunicationTest {
    public static void main(String[] args) {
        Thread1 thread1=new Thread1();
        new Thread(thread1,"A").start();
        new Thread(thread1,"B").start();
    }


}
