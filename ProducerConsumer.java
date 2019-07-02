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
public class ProducerConsumer {

    public static void main(String[] args) {

        CookyJar jar = new CookyJar();

        Suresh suresh = new Suresh(jar);
        Ramesh ramesh = new Ramesh(jar);

        new Thread(suresh).start();
        new Thread(ramesh).start();
    }

}

class Suresh implements Runnable {

    CookyJar jar;

    public Suresh(CookyJar jar) {
        this.jar = jar;
    }

    public void eat() {
        jar.getCooky("Suresh");
        try {
            Thread.sleep((int) Math.random() * 1000);
        } catch (InterruptedException ie) {
        }
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            eat();
        }
    }
}

class Ramesh implements Runnable {

    CookyJar jar;

    public Ramesh(CookyJar jar) {
        this.jar = jar;
    }

    public void bake(int cookyNumber) {
        jar.putCooky("Ramesh", cookyNumber);
        try {
            Thread.sleep((int) Math.random() * 500);
        } catch (InterruptedException ie) {
        }
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            bake(i);
        }
    }
}

class CookyJar {

    private int contents;
    private boolean available = false;

    public synchronized void getCooky(String who) {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        notifyAll();
        System.out.println(who + " ate cooky " + contents);
    }

    public synchronized void putCooky(String who, int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        contents = value;
        available = true;
        System.out.println(who + " put cooky " + contents
                + " in the jar");
        notifyAll();
    }
}
