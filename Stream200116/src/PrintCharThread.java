/**
 *
 * Класс с мотодами вывода букв АВС в потоке
 *
 * @author SlViKo(Кобозев Вячеслав)
 * @version date 18/02/2020
 */

public class PrintCharThread {
    private final Object mon = new Object();
    private final Object mon2 = new Object();
    private volatile char currentLetter = 'A';

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        mon.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {

        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';

                    synchronized (mon2) {
                        mon2.notify(); // самая сложная строчка, пока дошло, что нужно разбудить поток с для второго монитора перед усыплением этого
                        while (currentLetter != 'A') {
                            mon2.wait();
                        }
                    }
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void printC() {
        synchronized (mon2) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        mon2.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    mon2.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


