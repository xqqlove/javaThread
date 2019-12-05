package com.yiwa.learndeepJUC;
//原子性问题
//例如 i++ 操作分为三部 读 改 写
//   int temp=i;
//   i=i+1;
//   i=temp;
//原子变量:java1.5后 java.util.concurrent.atomic包下提供了常用的原子变量：
//    1.volatile保证内存可见性
//    2.CAS(compute-And-Swap)算法保证数据的原子性,
//    CAS算法，是硬件对于并发操作共享数据的支持
//      包括三个操作数：内存值V 预估值A 更新值B
//         当且仅当V==A 时 ，V=B，否则，将不做任何操作

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

class AtomicDemo implements Runnable{
//    private int num=0;
    private AtomicInteger num=new AtomicInteger();
    @Override
    public void run() {
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getNum());
    }
    public int getNum(){
        return num.getAndIncrement();
    }
}
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo at=new AtomicDemo();
        for(int i=0;i<100000;i++){
            new Thread(at).start();
        }
    }
}
