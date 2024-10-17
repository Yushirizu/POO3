package synchro.zpPartagee;

public class ZonePartagee {
    private int valeur;
    private boolean estDisponible = false;

    public ZonePartagee() {
        valeur = 0;
    }

    public synchronized int getValeur() {
        while (!estDisponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        estDisponible = false;
        notifyAll();
        System.out.println("Consommation = " + valeur);
        return valeur;
    }

    public synchronized void setValeur(int valeur) {
        while (estDisponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.valeur = valeur;
        estDisponible = true;
        notifyAll();
        System.out.println("Production valeur : " + valeur);
    }
}