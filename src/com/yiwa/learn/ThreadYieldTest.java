package com.yiwa.learn;

class ThreadYeild extends Thread{
    public ThreadYeild(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=1;i<=50;i++){
            System.out.println(" "+this.getName()+"---------"+i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i==30){
                this.yield();
            }
        }
    }
}

public class ThreadYieldTest {
    public static void main(String[] args) {
        ThreadYeild ty1=new ThreadYeild("张三");
        ty1.setPriority(Thread.MAX_PRIORITY);
        ThreadYeild ty2=new ThreadYeild("李四");
        ty2.setPriority(Thread.MIN_PRIORITY);
        ty1.start();
        ty2.start();
    }
}
