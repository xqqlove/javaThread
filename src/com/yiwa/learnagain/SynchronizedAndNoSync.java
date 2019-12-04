package com.yiwa.learnagain;

/**
 * 线程t1和t2交替执行。t1会调用count对象的synMethod()方法，该方法中含有同步块；
 * 而t2则会调用count对象的nonSynMethod()方法，该方法不是同步方法。t1运行时，
 * 虽然调用synchronized(this)获取count对象的同步锁；但是并没有造成t2的阻塞，
 * 因为t2没有用到count对象的同步锁。
 *
 */
public class SynchronizedAndNoSync {
    public static void main(String[] args) {
        class Count{
            public void synMethod(){
                synchronized (this) {
                    for (int i=0;i<5;i++){
                        try {
                            Thread.sleep(100);
                            System.out.println(Thread.currentThread().getName() + "同步"+i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
            public void noSyncMethod(){
                for (int i=0;i<5;i++){
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName()+"普通"+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        final Count count=new Count();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                count.synMethod();
            }
        },"t1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                count.noSyncMethod();
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
