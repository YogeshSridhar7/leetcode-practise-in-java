package Threads;

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentDemo paymentDemo = new PaymentDemo();
        Accounts userAccount = new Accounts("A",10001,1000.0);
        DepositThread depositThread = new DepositThread(userAccount,50.0);
        WithdrawAmount withdrawAmount = new WithdrawAmount(userAccount,10.0);
        depositThread = new DepositThread(userAccount,50.0);
        withdrawAmount = new WithdrawAmount(userAccount,10.0);

        for(int i =1;i<10;i++){
            depositThread = new DepositThread(userAccount,50.0);
            withdrawAmount = new WithdrawAmount(userAccount,10.0);
           depositThread.start();
           withdrawAmount.start();
        }
    }
}
//class AccountManagement implements Runnable {
//    @Override
//    public void run() {
//    }
//    private Accounts accounts;
//
//    public AccountManagement(Accounts accounts){
//        this.accounts=accounts;
//    }
//
//}
class Accounts{
    private String name;
    private int accountID;
    private double accountBalance;

    public Accounts(String name,int accountID, double accountBalance){
        this.name=name;
        this.accountID = accountID;
        this.accountBalance=accountBalance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAccountID() {
        return accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}

class DepositThread extends Thread {
    private Accounts account;
    private double amount;
    public DepositThread(Accounts account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        deposit(amount);
    }
    private void deposit(double amount){
        if(amount>0){
            double balance = account.getAccountBalance()+amount;
            account.setAccountBalance(balance);
            System.out.println("Amount " + amount +" has been deposited in the account : " + account.getAccountBalance());
        }
    }

    public Accounts getAccount() { return account; }
    public void setAccount(Accounts account) { this.account = account; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}

class WithdrawAmount extends Thread {
    private Accounts account;
    private double amount;

    public WithdrawAmount(Accounts account, double amount) {
        this.account = account;
        this.amount = amount;
    }
    private  void withdraw(double amount){
        if(amount>0 && amount<= account.getAccountBalance()){
            double balance= account.getAccountBalance()-amount;
            account.setAccountBalance(balance);
            System.out.println("Amount " + amount +" has been withdraw from the account : " + account.getAccountBalance());
        } else {
            System.out.println("Insufficient balance");
        }
    }
    @Override
    public void run() {
        withdraw(amount);
    }
}