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
public class PrintThread2 extends Thread {

    String name;

    public PrintThread2(String name) {
        this.name = name;
    }
    
    public void run() {
        print(name);
    }

    public static synchronized void print(String name) {
        for (int i = 1; i < 5; i++) {
            try {
                sleep((long) (Math.random() * 100));
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
            System.out.println(name);
        }
        
    }

    public static void main(String args[]) {
        PrintThread2 a = new PrintThread2("*");
        PrintThread2 b = new PrintThread2("-");
        PrintThread2 c = new PrintThread2("=");
        a.start();
        b.start();
        c.start();
    }
}
