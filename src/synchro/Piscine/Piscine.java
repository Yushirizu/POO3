package synchro.Piscine;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Semaphore;

public class Piscine extends JFrame {
    private final int NBR_BAIGNEURS = 7;
    private final int NBR_CABINES = 3;
    private final int NBR_PANIERS = 4;
    private final Semaphore semaPanier = new Semaphore(NBR_PANIERS);
    private final Semaphore semaCabine = new Semaphore(NBR_CABINES);

    public Piscine() {
        setTitle("Piscine");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 8, 10, 10));
        Header header = new Header();
        add(header.getPanel());
        for (int i = 0; i < NBR_BAIGNEURS; i++) {
            add(new Baigneur(("Baigneur " + i), this));
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new Piscine();
    }

    public Semaphore getSemaPanier() {
        return semaPanier;
    }

    public Semaphore getSemaCabine() {
        return semaCabine;
    }
}