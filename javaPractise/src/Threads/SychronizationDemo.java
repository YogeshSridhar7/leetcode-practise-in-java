package Threads;

public class SychronizationDemo{

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        SychronizationDemo s = new SychronizationDemo();
        AccountManager w = new AccountManager(account);
        AccountManager w1 = new AccountManager(account);
        Thread one = new Thread(w);
        Thread two = new Thread(w);
        one.setName("Appa");

        two.setName("Bala");
        one.start();
        one.join();
        w.makeDeposit(50);
        w.makeWithdrawal(10);

        two.start();
    }
}

class AccountManager implements Runnable {
    private Account account;
    AccountManager(Account account){
        this.account=account;
    }
    @Override
    public void run() {
        for (int i=0; i<5; i++){
            makeWithdrawal(10);

        }
        AccountManager.print();
        if (account.getBalance() <= 0) {
           // makeDeposit(50);
        }
    }
    public  void makeWithdrawal(int amt){
        if(account.getBalance() >= amt) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");
            account.withdraw(amt);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
        } else {
            System.out.println("Not enough in account for "
                    + Thread.currentThread().getName()
                    + " to withdraw "
                    + account.getBalance());
          //  makeDeposit(50);
        }
    }

    public void makeDeposit(int amt){
        System.out.println(Thread.currentThread().getName() + " is going to deposit");
        account.deposit(amt);
        System.out.println(Thread.currentThread().getName() + " completes the deposit");
    }
    public static synchronized void print() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException ex){}
        System.out.println(Thread.currentThread().getName() + "ggggggggggggg");
    }
}

class Account{
    private int balance = 50;

    public int getBalance() {
        return balance;
    }
    public void withdraw(int amount) {
        if(balance - amount >= 0) {
            balance= balance - amount;
        } else {
            System.out.println("Threads.Account is overdrawn");
        }

    }
    public void deposit(int amount) {
        balance= balance + amount;
    }
}
