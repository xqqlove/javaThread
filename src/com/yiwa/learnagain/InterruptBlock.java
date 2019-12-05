package com.yiwa.learnagain;

import static java.lang.Thread.sleep;

public class InterruptBlock {
    public static void main(String[] args) {
        class MyThread extends Thread{
            public MyThread(String name){
                super(name);
            }
            public void run(){
                int i=0;
                try {
                    while (!isInterrupted()){
                        sleep(100);
                        i++;
                        System.out.println(Thread.currentThread().getName()+": "+i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()+"("+this.getState()+"");
                }

            }
        }
        try {
            MyThread t1=new MyThread("t1");
            System.out.println(t1.getName()+"("+t1.getState()+") is new");
            System.out.println("1:"+t1.isInterrupted());
            t1.start();
            System.out.println(t1.getName()+"("+t1.getState()+") is start");
            System.out.println("2:"+t1.isInterrupted());
            sleep(3000);
            t1.interrupt();
            System.out.println("3:"+t1.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
