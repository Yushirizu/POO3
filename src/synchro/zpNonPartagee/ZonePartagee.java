package synchro.zpNonPartagee;

public class ZonePartagee {
    private int valeur;

    public ZonePartagee() {
        valeur = 0;
    }



    public int getValeur() {
        System.out.println("Consommation = " + valeur);
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
        System.out.println("Production valeur : " + valeur);
    }
}
