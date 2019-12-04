package com.yiwa.learn;

import static java.lang.Thread.sleep;

public class Account {
    String name;
    float amount;
    public Account(String name,float amount){
        this.name=name;
        this.amount=amount;
    }
    //存钱
    public void deposit(float amt){
        amount+=amt;
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //取钱
    public void withdraw(float amt){
        amount-=amt;
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public float getAmount(){
        return amount;
    }
}
