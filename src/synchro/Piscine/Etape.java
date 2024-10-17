package synchro.Piscine;

import javax.swing.*;
import java.awt.*;

public class Etape extends JPanel {
    private final ThBaigneur baigneur;
    private final Etats etat;
    private boolean isCurrent;
    private boolean isCompleted;

    public Etape(ThBaigneur baigneur, Etats etat) {
        this.baigneur = baigneur;
        this.etat = etat;
        this.isCurrent = false;
        this.isCompleted = false;
        setLayout(new BorderLayout());
        setSize(100, 100);
        setVisible(true);
        setBackground(Color.WHITE);
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Etats getEtat() {
        return etat;
    }
}