package multithreading;

/**
 *
 * @author ajay
 */
class PrintStar extends Thread {

    PrintCharacters p;

    PrintStar(PrintCharacters p) {
        this.p = p;
    }

    public void run() {
        for (int i = 1; i < 5; i++) {
            p.printStar();

        }

    }

}

class PrintDash extends Thread {

    PrintCharacters p;

    PrintDash(PrintCharacters p) {
        this.p = p;
    }

    public void run() {
        for (int i = 1; i < 5; i++) {
            p.printDash();

        }

    }

}

class PrintEquals extends Thread {

    PrintCharacters p;

    PrintEquals(PrintCharacters p) {
        this.p = p;
    }

    public void run() {
        for (int i = 1; i < 5; i++) {
            p.printEquals();

        }

    }

}

class PrintCharacters {

    boolean isStar = true;
    boolean isDash = false;
    boolean isEquals = false;

    synchronized void printStar() {

        while (isStar == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("*");
        isStar = false;
        isDash = true;
        notifyAll();
    }

    synchronized void printDash() {

        while (isDash == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-");
        isDash = false;
        isEquals = true;
        notifyAll();
    }

    synchronized void printEquals() {

        while (isEquals == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=");
        isEquals = false;
        isStar = true;
        notifyAll();
    }

}

public class PrintThread3 {

    public static void main(String args[]) {
        PrintCharacters p = new PrintCharacters();
        PrintStar a = new PrintStar(p);
        PrintDash b = new PrintDash(p);
        PrintEquals c = new PrintEquals(p);

        a.start();
        b.start();
        c.start();
    }
}
