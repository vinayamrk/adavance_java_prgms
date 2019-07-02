/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;


/**
 *
 * @author ajay
 */
class BankAccount {

    private float balance;
    private String name;

    BankAccount(String name, int i) {
        this.name = name;
        this.balance = i;
        
        }

    public synchronized void deposit(float amount) {
        balance += amount;
    }

    public synchronized void withdraw(float amount) {
        balance -= amount;
    }

    public synchronized void transfer(float amount,
            BankAccount target) throws InterruptedException {
        withdraw(amount);   
        Thread.sleep(1000);
        target.deposit(amount);
    }
    
    public void printBalance() {
        System.out.println("Balance in account: "+name +" is :"+ balance);
    }
}

class MoneyTransfer implements Runnable {

    private BankAccount sourceAccount, targetAccount;
    private float amount;

    public MoneyTransfer(
            BankAccount from, BankAccount to, float amount) {
        this.sourceAccount = from;
        this.targetAccount = to;
        this.amount = amount;
    }

    public void run() {
        
        try {
            sourceAccount.transfer(amount, targetAccount);
        } catch (InterruptedException ex) {
           }
        
    }
}

public class BankTest {

    public static void main(String[] argv) throws InterruptedException {
        BankAccount sureshAccount = new BankAccount("Suresh", 2000);
        BankAccount rameshAccount = new BankAccount("Ramesh", 2000);
        Runnable transaction1
                = new MoneyTransfer(sureshAccount, rameshAccount, 1200);
        Thread t1 = new Thread(transaction1);
        t1.start();
        
        Runnable transaction2
                = new MoneyTransfer(rameshAccount, sureshAccount, 700);
        Thread t2 = new Thread(transaction2);
        t2.start();
     
        
        System.out.println("waiting for the threads to join...");
        t1.join();
        t2.join();
  
        sureshAccount.printBalance();
        rameshAccount.printBalance();
        
        

    }
}
