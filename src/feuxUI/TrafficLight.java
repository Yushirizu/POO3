package feuxUI;

import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JFrame {
  private final Light feu = new Light();

  public TrafficLight() {
    super("Traffic Light");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(800, 600);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.BLACK);
    g.fillOval(320, 60, 160, 250);
    g.setColor(Color.WHITE);
    g.fillOval(330, 70, 140, 230);
    g.setColor(Color.BLACK);
    g.fillOval(335, 75, 130, 220);

    g.setColor(feu.getCouleurRouge());
    g.fillOval(350, 90, 100, 100);

    g.setColor(feu.getCouleurOrange());
    g.fillOval(350, 200, 100, 100);

    g.setColor(feu.getCouleurVert());
    g.fillOval(350, 310, 100, 100);

    repaint();
  }

  public static void main(String[] args) {
    new TrafficLight();
  }
}