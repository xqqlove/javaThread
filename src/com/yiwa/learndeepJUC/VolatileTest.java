package com.yiwa.learndeepJUC;
//内存可见性问题  ，当多个线程操作共享数据时，彼此不可见
//volatile ：当多个线程进行进行操作共享数据时 保证内存中的数据可见
//        相较于 synchronized是一种较为轻量级的同步策略
//   但是 volatile 不具备互斥性
//  不能保证变量的原子性

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

class ThreadDemo implements Runnable{
    private volatile boolean flag=false;
    @Override
    public void run() {
        flag=true;
        System.out.println("flag:="+isFlag());
    }
    public  boolean isFlag(){
        return flag;
    }
    public void setFlag(boolean flag){
        this.flag=flag;
    }
}
public class VolatileTest {
    public static void main(String[] args) {
        ThreadDemo td=new ThreadDemo();
        new Thread(td).start();
//        synchronized (td) {
            while (true) {
                if (td.isFlag()) {
                    System.out.println("+++++++++++++++++++++++");
                    break;
                }
            }
//        }
    }
}
