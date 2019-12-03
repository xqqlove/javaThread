package com.yiwa.learn;

class MyThread1 implements Runnable {
    private String name;
    public MyThread1(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(name+"运行："+i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class TestRunnable {
    public static void main(String[] args) {
        new Thread(new MyThread1("c")).start();
        new Thread(new MyThread1("A")).start();
    }
}
