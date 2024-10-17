package synchro.zpPartagee;

public class Main {
    public static void main(String[] args) {
        ZonePartagee zone = new ZonePartagee();
        Producteur p = new Producteur(zone);
        Consommateur c = new Consommateur(zone);

    }
}
