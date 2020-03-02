/**
 *
 * Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
 *
 * @author SlViKo(Кобозев Вячеслав)
 * @version date 28/02/2020
 */
public class TestThreading {

    public static void main(String[] args) {
        PrintCharThread pct = new PrintCharThread();

        Thread a = new Thread(() -> {
           pct.printA();
        });

        Thread b = new Thread(() -> {
            pct.printB();
        });

        Thread c = new Thread(() -> {
           pct.printC();
        });

        a.start();
        b.start();
        c.start();
    }
}
