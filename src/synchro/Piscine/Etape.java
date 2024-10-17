package synchro.Piscine;

import javax.swing.*;
import java.awt.*;

public class Etape extends JPanel {
    private final ThBaigneur thBaigneur;
    private final Etats etat;
    private boolean isCurrent;
    private boolean isCompleted;

    public Etape(ThBaigneur baigneur, Etats etat) {
        this.thBaigneur = baigneur;
        this.etat = etat;
        this.isCurrent = false;
        this.isCompleted = false;
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

    public Color getColor() {
        if (isCompleted) {
            return Color.GRAY;
        } else if (thBaigneur.isPaused()) {
            return Color.YELLOW;
        } else if (isCurrent) {
            return Color.GREEN;
        }
        return Color.WHITE;
    }
}