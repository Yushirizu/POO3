package processus.ex01;

import java.util.ArrayList;

public class PremierThread extends Thread {
    private static final int MAX_THREADS = 4;
    private final long delay;

    public PremierThread(long delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        super.run();

        try {
            System.out.println(getName() + "fait dodo");
            sleep(delay);
            System.out.println(getName()+ "kys");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        System.out.println("Lancement des Threads");
        ArrayList<PremierThread> threads = new ArrayList<>();
        //Boucle de lancement
        PremierThread thread = null;
        for (int i = 0; i < MAX_THREADS; i++) {
            long delay = (long) (Math.random() * 5000);
            thread = new PremierThread(delay);
            thread.start();
            threads.add(thread);
        }

        System.out.println("Tous threads lancés");

        for (PremierThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Tous les threads sont morts");
        System.exit(0);
    }
}
