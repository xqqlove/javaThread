package com.yiwa.learn;

class MyThread extends Thread {
    private String name;
    public MyThread(String name){
        this.name=name;
    }
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println(name+"运行："+i);
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Main{
    public static void main(String[] args) {
        MyThread thread1=new MyThread("qiang");
        MyThread thread=new MyThread("xia");

        thread1.start();
        thread.start();
    }
}
