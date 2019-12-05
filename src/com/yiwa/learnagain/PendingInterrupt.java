package com.yiwa.learnagain;

import static java.lang.Thread.sleep;

public class PendingInterrupt {
    public static void main(String[] args) {
        if(args.length==0){
//            Thread.currentThread().interrupt();
        }
        long startTime =System.currentTimeMillis();
        try {
            sleep(3000);
            System.out.println("was not interrupted");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("was interrupt");
        }
        System.out.println("total Time ="+(System.currentTimeMillis()-startTime));
    }
}
