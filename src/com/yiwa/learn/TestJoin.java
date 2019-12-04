package com.yiwa.learn;


public class TestJoin {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" 主线程运行开始！");
        ThreadTestJoin join1=new ThreadTestJoin("A");
        ThreadTestJoin join2=new ThreadTestJoin("B");
        join1.start();
        join2.start();
        try {
            join1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            join2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 主程序运行结束！");
    }
}
