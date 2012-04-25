package ui;

import javax.swing.*;
import java.awt.*;

public class BarrePropriete extends JPanel {

     Choice listeCategorie;
     JTextField nomTache;
     
    
    public BarrePropriete(){
        JLabel labelTache = new JLabel("Nom de la tâche");
        nomTache = new JTextField(8);
        nomTache.setEditable(false);
        
        JLabel labelListeCategorie = new JLabel("Catégorie");
        listeCategorie = new Choice();
        listeCategorie.addItem("");
        listeCategorie.addItem("Utilisateur");
        listeCategorie.addItem("Abstraction");
        listeCategorie.addItem("Application");
        listeCategorie.addItem("Interaction");
        listeCategorie.select("");
                
        
        this.add(labelTache);
        this.add(nomTache);
        this.add(labelListeCategorie);
        this.add(listeCategorie);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setVisible(true);  
    }
    
    
}
