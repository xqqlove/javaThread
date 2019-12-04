package com.yiwa.learn;

public class Counter implements Runnable {
    private int count;
    public Counter(){
        count=0;
    }
    public void countAdd(){
        synchronized (this){
            for(int i=0;i<10;i++){
                try {
                    System.out.println(Thread.currentThread().getName()+": "+(count++));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void printCount(){
        for(int i=0;i<5;i++){
            try {
                System.out.println(Thread.currentThread().getName()+":count: "+count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        String threadName=Thread.currentThread().getName();
        if (threadName.equals("B")){
            printCount();
        }else {
            countAdd();
        }
    }
}
