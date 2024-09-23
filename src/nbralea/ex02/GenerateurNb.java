package nbralea.ex02;

import java.util.ArrayList;

public class GenerateurNb extends Thread{
    private static final int MAX_THREADS = 2;
    public static int nb;
    public static final int nMilli=10000;
    public int nbNb;
    public int nm;

    public GenerateurNb(int nb, int nbNb, int nm) {
        GenerateurNb.nb = nb;
        this.nbNb = nbNb;
        this.nm = nm;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < nbNb; i++) {
            nm = (int) (Math.random() * nMilli);
            System.out.println(getName());
            System.out.println("Nombre d'occurences: " + (i + 1));
            System.out.println("Temps de sommeil: " + nm);
            try {
                //sleep the current thread
                sleep(nm);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<GenerateurNb> threads = new ArrayList<>();
        //Boucle de lancement
        for (int i = 0; i < MAX_THREADS; i++) {
            int sleepTime = (int) (Math.random() * nMilli);
            GenerateurNb thread = new GenerateurNb(i, 5, sleepTime);
            thread.setName("Thread " + i);
            thread.start();
            threads.add(thread);
        }

        for (GenerateurNb t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("c'est fini");
        System.exit(0);
    }
}
