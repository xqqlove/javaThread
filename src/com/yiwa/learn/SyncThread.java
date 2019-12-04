package com.yiwa.learn;

public class SyncThread implements Runnable {
    private static int  count;
    public SyncThread(){
        count=0;
    }
    @Override
    public synchronized void run() {
            for (int i=0;i<5;i++){
                try {
                    System.out.println(Thread.currentThread().getName()+": "+(count++));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    public int getCount(){
        return count;
    }
}
