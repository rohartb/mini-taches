package ui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Sauvegarde {
    
    String nom;
    Fenetre f;
    
    public Sauvegarde(Fenetre f){
        this.f = f;    }

    void sauver(){
        nom = (String)JOptionPane.showInputDialog(f,"Entrez votre nom de sauvegarde","Sauvegarder",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Image/icone_sauvegarder.png"), null,null);
    }
    
    void charger(String st){}

    public void afficherCharger() {}

    public void miseAJourListCharger() {}

    public boolean fichierAChargerSontPresents() {
        return false;
    }
}
