package com.yiwa.learn;

public class AccountOperator implements Runnable {

    private Account account;

    public AccountOperator(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
//        synchronized (account) {
            account.deposit(500);
            account.withdraw(500);
            System.out.println(Thread.currentThread().getName() + ": " + account.getAmount());
//        }
    }
}
