package synchro.Piscine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Baigneur extends JPanel {
    private final ThBaigneur thBaigneur;
    private final ArrayList<Etape> etapes;

    public Baigneur(String name) {
        setLayout(new GridLayout(6, 1, 10, 10));
        setSize(100, 100);
        setVisible(true);
        etapes = new ArrayList<>();
        thBaigneur = new ThBaigneur(this, name);
    }

    public void addEtape(Etats etat) {
        Etape etape = new Etape(thBaigneur, etat);
        etapes.add(etape);
        add(etape);
        revalidate();
        repaint();
    }

    public void updateEtape(Etats currentEtat) {
        for (Etape etape : etapes) {
            if (etape.getEtat() == currentEtat) {
                etape.setCurrent(true);
            } else if (etape.isCurrent()) {
                etape.setCurrent(false);
                etape.setCompleted(true);
            }
        }
        repaint();
    }
}