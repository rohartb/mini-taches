package ui;

import javax.swing.*;
import java.awt.*;

public class BarrePropriete extends JPanel {

    public BarrePropriete(){
        JLabel labelTache = new JLabel("Nom de la tâche");
        JTextField nomTache = new JTextField(8);    
        
        JLabel labelPriorite = new JLabel("Priorité : ");
        
        JButton bouton1 = new JButton("P1");
        JButton bouton2 = new JButton("P2");
        JButton bouton3 = new JButton("P3");
        JButton bouton4 = new JButton("P4");
        
        this.add(labelTache);
        this.add(nomTache);
        this.add(labelPriorite);
        this.add(bouton1);
        this.add(bouton2);
        this.add(bouton3);
        this.add(bouton4);
        this.setBorder(BorderFactory.createLineBorder(Color.red));
        this.setVisible(true);  
    }
    
    
}
