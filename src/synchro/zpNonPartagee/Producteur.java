package synchro.zpNonPartagee;

public class Producteur extends Thread{
    private ZonePartagee zone;
    private static final int MAX_ITERATIONS = 10;

    public Producteur(ZonePartagee zone) {
        this.zone = zone;
        start();
    }

    public void run() {
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            int random = (int)(Math.random() * 100);
            zone.setValeur(random);
            try {
                sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
