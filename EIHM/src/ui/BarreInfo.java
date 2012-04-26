package ui;

import java.awt.Color;
import javax.swing.*;

public class BarreInfo extends JPanel {
    JLabel info;
    
    public BarreInfo() {
        info = new JLabel("Nouvel arbre des taches");
        this.add(info);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setVisible(true);
    }

    void setInfo(String string) {
        if(string.equals("sauvegarde")){
            info.setText("Sauvegarde de l'arbre");
        }
        if(string.equals("non supprime")){
            info.setText("Le noeud racine en peut pas etre supprimé");
        }
        if(string.equals("supression")){
            info.setText("Suppression d'une tache");
        }
        if(string.equals("deplacement")){
            info.setText("Déplacement de la tache");
        }
        if(string.equals("modif")){
            info.setText("Modification de la tache");
        }
        if(string.equals("couper")){
            info.setText("Tache coupée");
        }
        if(string.equals("coller")){
            info.setText("Tache collée");
        }
        if(string.equals("copier")){
            info.setText("Tache copiée");
        }
        if(string.equals("nouveau")){
            info.setText("Nouvel arbre des taches");
        }
        if(string.equals("rien")){
            info.setText("Aucune tache séléctionée");
        }
        if(string.equals("propos")){
            info.setText("A propos");
        }
        if(string.equals("ouvrir")){
            info.setText("Ouverture du fichier");
        }
        if(string.equals("aide")){
            info.setText("Démarrage de l'aide");
        } 
        if(string.equals("Menu non affichable")){
            info.setText("Menu non affichable");
        } 
    }
    
}

