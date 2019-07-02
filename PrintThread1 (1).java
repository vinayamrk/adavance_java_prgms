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
public class PrintThread1 extends Thread {

    String name;

    public PrintThread1(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                sleep((long) (Math.random()* 100));
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
            System.out.println(name);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Start thread example");
        
        PrintThread1 a = new PrintThread1("*");
        PrintThread1 b = new PrintThread1("-");
        PrintThread1 c = new PrintThread1("=");
        
        System.out.println("Priority of thread A is :"+ a.getPriority());
      //  a.setPriority(MAX_PRIORITY);
        System.out.println("Priority of thread A is :"+ a.getPriority());
        
        a.setDaemon(true);
        
        
              
       
        a.start();
        b.start();
        c.start();
        
            
       // a.join();
        //b.join();
        //c.join();
        
          
        System.out.println("Finished");
        
    }
}
