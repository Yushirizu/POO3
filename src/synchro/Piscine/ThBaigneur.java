package synchro.Piscine;

import java.util.concurrent.Semaphore;

public class ThBaigneur extends Thread {
    private static final Semaphore semaPanier = new Semaphore(2, true);
    private static final Semaphore semaCabine = new Semaphore(1, true);
    private final Baigneur baigneur;
    private Etats etat;
    private boolean isPaused = false;

    public ThBaigneur(Baigneur baigneur, String name) {
        super(name);
        this.etat = Etats.ARRIVE;
        this.baigneur = baigneur;
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                baigneur.addEtape(etat);
                baigneur.updateEtape(etat);
                switch (etat) {
                    case ARRIVE:
                        System.out.println(getName() + " ARRIVE");
                        Attente(1000);
                        etat = Etats.PANIER;
                        break;
                    case PANIER:
                        semaPanier.acquire();
                        System.out.println(getName() + " PANIER");
                        Attente(3000);
                        etat = Etats.DESHABILLE;
                        break;
                    case DESHABILLE:
                        semaCabine.acquire();
                        System.out.println(getName() + " DESHABILLE");
                        Attente(3000);
                        etat = Etats.RHABILLE;
                        break;
                    case BAIGNE:
                        System.out.println(getName() + " BAIGNE");
                        Attente(5000);
                        etat = Etats.DESHABILLE;
                        break;
                    case RHABILLE:
                        System.out.println(getName() + " RHABILLE");
                        semaCabine.release();
                        Attente(3000);
                        semaPanier.release();
                        Attente(3000);
                        etat = Etats.QUITTE;
                        break;
                    case QUITTE:
                        System.out.println(getName() + " QUITTE");
                        baigneur.addEtape(etat);
                        baigneur.updateEtape(etat);
                        return;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void Pause(int temps) throws InterruptedException {
        isPaused = true;
        Thread.sleep(temps);
        isPaused = false;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void Attente(int max) throws InterruptedException {
        isPaused = true;
        int random = (int) (Math.random() * max);
        Pause(random);
        isPaused = false;
    }
}