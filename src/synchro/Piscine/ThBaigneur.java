package synchro.Piscine;

public class ThBaigneur extends Thread {
    private final Piscine parent;
    private final Baigneur baigneur;
    private Etats etat;
    private boolean isPaused = false;

    public ThBaigneur(Baigneur baigneur, String name, Piscine parent) {
        super(name);
        this.parent = parent;
        this.etat = Etats.ARRIVE;
        this.baigneur = baigneur;
        start();
    }

    @Override
    public void run() {
        try {
            // -----------------ARRIVE-----------------
            baigneur.addEtape(etat);
            baigneur.updateEtape(etat);
            Pause(1000);
            // -----------------PANIER-----------------
            etat = Etats.PANIER;
            baigneur.addEtape(etat);
            isPaused = true;
            baigneur.updateEtape(etat);
            parent.getSemaPanier().acquire();
            isPaused = false;
            baigneur.updateEtape(etat);
            Attente(3000);
            // -----------------DESHABILLE-----------------
            etat = Etats.DESHABILLE;
            baigneur.addEtape(etat);
            isPaused = true;
            baigneur.updateEtape(etat);
            parent.getSemaCabine().acquire();
            isPaused = false;
            baigneur.updateEtape(etat);
            Attente(3000);
            // -----------------BAIGNE-----------------
            etat = Etats.BAIGNE;
            baigneur.addEtape(etat);
            baigneur.updateEtape(etat);
            Attente(5000);
            // -----------------RHABILLE-----------------
            etat = Etats.RHABILLE;
            baigneur.addEtape(etat);
            baigneur.updateEtape(etat);
            parent.getSemaCabine().release();
            Attente(3000);
            parent.getSemaPanier().release();
            Attente(3000);
            // -----------------QUITTE-----------------
            etat = Etats.QUITTE;
            baigneur.addEtape(etat);
            baigneur.updateEtape(etat);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void Pause(int temps) throws InterruptedException {
        Thread.sleep(temps);
    }

    public void Attente(int max) throws InterruptedException {
        int random = (int) (Math.random() * max);
        Pause(random);
    }

    public boolean isPaused() {
        return isPaused;
    }
}