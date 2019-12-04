package com.yiwa.learn;

public class TestAccounter {
    public static void main(String[] args) {
        Account account=new Account("qiangqiangxia",10000.0f);
        AccountOperator accountOperator=new AccountOperator(account);
        final int THREAD_NUM=5;
        Thread thread[]=new Thread[THREAD_NUM];
        for (int i=0;i<THREAD_NUM;i++){
            thread[i]=new Thread(accountOperator,"THREAD"+i);
            thread[i].start();
        }
    }
}
