package eihm;


import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {

    public MenuBar() {
       
        JMenu fichier = new JMenu("Fichier");
        JMenu edition = new JMenu("Edition");
        JMenu apparence = new JMenu("Apparence");
        JMenu outil = new JMenu("Outils");
        JMenu aide = new JMenu("?");
        
        //Menu fichier
        JMenuItem nouveau = new JMenuItem("Nouveau");
        JMenuItem ouvrir = new JMenuItem("Ouvrir");
        JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
        JMenuItem quitter = new JMenuItem("Quitter");
        
        fichier.add(nouveau);
        fichier.add(ouvrir);
        fichier.add(sauvegarder);
        fichier.add(quitter);
        
        this.add(fichier);
        this.add(edition);
        this.add(apparence);
        this.add(outil);
        this.add(aide);
        
        
        
    }
    
       
    
}
