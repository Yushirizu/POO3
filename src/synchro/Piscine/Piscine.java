// Piscine.java
package synchro.Piscine;

import javax.swing.*;
import java.awt.*;

public class Piscine extends JFrame {

    private final int NBR_BAIGNEURS = 7;

    public Piscine() {
        setTitle("Piscine");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 8, 10, 10));
        Header header = new Header();
        add(header.getPanel());
        for (int i = 0; i < NBR_BAIGNEURS; i++) {
            add(new Baigneur("Baigneur " + i));
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new Piscine();
    }
}