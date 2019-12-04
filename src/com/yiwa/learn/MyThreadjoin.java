package com.yiwa.learn;

import static java.lang.Thread.sleep;

class ThreadTestJoin extends Thread{
    private String name;
    public ThreadTestJoin(String name){
        super();
        this.name=name;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+" 线程运行开始");
        for(int i=0;i<5;i++){
            System.out.println("子线程"+name+"运行： "+i);
            try {
                sleep((long) (Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" 线程运行结束！");
    }
}

public class MyThreadjoin {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" 主线程运行开始");
        ThreadTestJoin ttj=new ThreadTestJoin("A");
        ThreadTestJoin ttj2=new ThreadTestJoin("B");
        ttj.start();
        ttj2.start();
        System.out.println(Thread.currentThread().getName()+" 主线程运行结束");
    }
}
