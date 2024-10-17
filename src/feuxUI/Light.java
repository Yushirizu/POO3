package feuxUI;

import java.awt.*;

public class Light extends Thread {
  private Etat etatRouge = Etat.OFF;
  private Etat etatOrange = Etat.OFF;
  private Etat etatVert = Etat.OFF;
  private long delaiRouge = 1000;
  private long delaiOrange = 500;
  private long delaiVert = 1000; // Increased delay for green light

  @Override
  public void run() {
    while (true) {
      try {
        setEtatRouge(Etat.ON);
        setEtatOrange(Etat.OFF);
        setEtatVert(Etat.OFF);
        sleep(delaiRouge);

        setEtatRouge(Etat.OFF);
        setEtatOrange(Etat.OFF);
        setEtatVert(Etat.ON);
        sleep(delaiVert);

        setEtatRouge(Etat.OFF);
        setEtatOrange(Etat.ON);
        setEtatVert(Etat.OFF);
        sleep(delaiOrange);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public Etat getEtatRouge() {
    return etatRouge;
  }

  public void setEtatRouge(Etat etat) {
    this.etatRouge = etat;
  }

  public Etat getEtatOrange() {
    return etatOrange;
  }

  public void setEtatOrange(Etat etat) {
    this.etatOrange = etat;
  }

  public Etat getEtatVert() {
    return etatVert;
  }

  public void setEtatVert(Etat etat) {
    this.etatVert = etat;
  }

  public Color getCouleurRouge() {
    return etatRouge == Etat.ON ? Color.RED : Color.GRAY;
  }

  public Color getCouleurOrange() {
    return etatOrange == Etat.ON ? Color.ORANGE : Color.GRAY;
  }

  public Color getCouleurVert() {
    return etatVert == Etat.ON ? Color.GREEN : Color.GRAY;
  }
}