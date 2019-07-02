/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajay
 */

class ThreadExample extends Thread {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread: " + i);
        }
    }
}



public class MultiThreading  {

    public static void main(String argv[]) {
        System.out.println("Start thread example");
        ThreadExample t = new ThreadExample();
        t.start();
        System.out.println("Thread isAlive?"+ t.isAlive());
     
        try {
            t.join();
        } catch (InterruptedException ex) {
            System.out.println("interrupted !!");
        }
        System.out.println("Thread isAlive?"+ t.isAlive());
        System.out.println("Finished");
    }

}








