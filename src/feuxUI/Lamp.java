package feuxUI;

import java.awt.*;

/**
 * Class Lamp
 */
public class Lamp {

  //
  // Fields
  //

  private Etat etat = Etat.OFF;
  private long delai;
  private Color couleur;
  
  //
  // Constructors
  //
  public Lamp() {
    this.delai = 0;

  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of etat
   * @param etat the new value of etat
   */
  public void setEtat (Etat etat) {
    this.etat = etat;
  }

  /**
   * Get the value of etat
   * @return the value of etat
   */
  public Etat getEtat () {
    return etat;
  }

  /**
   * Set the value of delai
   * @param delai the new value of delai
   */
  public void setDelai (long delai) {
    this.delai = delai;
  }

  /**
   * Get the value of delai
   * @return the value of delai
   */
  public long getDelai () {
    return delai;
  }

  public Color getCouleur() {
    return couleur;
  }

  public void setCouleur(Color couleur) {
    this.couleur = couleur;
  }
}
