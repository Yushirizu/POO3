package synchro.zpNonPartagee;

public class Consommateur extends Thread{
    private ZonePartagee zone;
    private static final int MAX_ITERATIONS = 10;

    public Consommateur(ZonePartagee zone) {
        this.zone = zone;
        start();
    }

    public void run() {
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            int random = (int)(Math.random() * 100);
            zone.getValeur();
            try {
                sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
