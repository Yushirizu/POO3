package synchro.Piscine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Baigneur extends JPanel {
    private final ThBaigneur thBaigneur;
    private final ArrayList<Etape> etapes = new ArrayList<>();

    public Baigneur(String name, Piscine parent) {
        setLayout(new GridLayout(6, 1, 10, 10));
        thBaigneur = new ThBaigneur(this, name, parent);
    }

    /**
     * @param etat the etat to add
     */
    public void addEtape(Etats etat) {
        Etape etape = new Etape(thBaigneur, etat);
        // add etape to the arraylist
        etapes.add(etape);
        // add etape to the panel
        add(etape);
        refresh();
    }

    /**
     * @param currentEtat the current etat to update
     */
    public void updateEtape(Etats currentEtat) {
        for (Etape etape : etapes) {
            if (etape.getEtat() == currentEtat) {
                etape.setCurrent(true);
                etape.setCompleted(false);
            } else if (etape.isCurrent()) {
                etape.setCurrent(false);
                etape.setCompleted(true);
            }
            etape.setBackground(etape.getColor());
        }
        refresh();
    }

    public void refresh(){
        revalidate();
        repaint();
    }
}