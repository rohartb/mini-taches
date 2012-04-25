/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author bastien
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
/**
* Classe qui definit une bulle
*
* @author bastien
*
*/
public class ElementMenu extends JPanel {
/**
* largeur de la bulle
*/
private int largeur; 
public String menu="rien";

/**
* couleur de la bulle
*/
private Color couleur;
/**
* Couleur de la bulle active
*/
private Color couleurActif;
/**
* Couleur de la bulle normale
*/
private Color couleurNormal;
private String texte;
/**
* Constructeur de bulle
* @param couleur : la couleur
* @param taille : la taille
*/
public ElementMenu(String texte, Color couleurNormal, Color couleurActif, int taille) {
    this.couleur=couleurNormal;
    this.couleurNormal=couleurNormal;
    this.couleurActif=couleurActif;
    this.texte=texte;
    largeur=taille;
    this.setSize(new Dimension(largeur + 10, largeur + 10));
    this.setOpaque(false);
    ajouterListener();
}
private void ajouterListener(){
addMouseListener(new MouseListener() {
public void mouseClicked(MouseEvent e) {
    if(menu.equals("Supprimer")){
        
    }
}
public void mouseReleased(MouseEvent e) {}
public void mousePressed(MouseEvent e) {}
public void mouseExited(MouseEvent e) {
couleur=couleurNormal;
repaint();
}
public void mouseEntered(MouseEvent e) {
couleur=couleurActif;
setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
repaint();
}
});
}
/**
* Surcharge de paintComponent
*/
public void paint(Graphics arg0) {
    super.paint(arg0);
    Graphics2D g2d = (Graphics2D) arg0;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(couleur);
    g2d.setStroke(new BasicStroke(3));
    g2d.fillOval(4, 4, largeur, largeur);
    g2d.fillOval(4+largeur/5, 4, 5*largeur/8, largeur/3);
    g2d.setColor(Color.WHITE);
    g2d.setFont(new Font("Calibri", Font.BOLD, 14));
    FontMetrics fm = g2d.getFontMetrics();
    int x = (this.getWidth() - fm.stringWidth(texte)) / 2;
    int y = (fm.getAscent() + (this.getHeight() -
    (fm.getAscent() + fm.getDescent())) / 2);
    g2d.drawString(texte, x, y);
}
public String getNom(){
    return this.texte;
}

public Color getCouleurNormal(){
    return this.couleurNormal;
}

public Color getCouleurActif(){
    return this.couleurActif;
}

}


