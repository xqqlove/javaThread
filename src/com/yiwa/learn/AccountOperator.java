package com.yiwa.learn;

import static java.lang.Thread.sleep;

public class AccountOperator implements Runnable {

    private Account account;

    public AccountOperator(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            sleep(10000);
          synchronized (account) {
            account.deposit(500);
            account.withdraw(500);
            System.out.println(Thread.currentThread().getName() + ": " + account.getAmount());
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
