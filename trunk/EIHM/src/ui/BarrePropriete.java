package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BarrePropriete extends JPanel {

     Choice listeCategorie;
     JTextField nomTache;
     Fenetre f;
     JLabel label;
     
    
    public BarrePropriete(Fenetre f){
        this.f = f;
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
        
        
        listeCategorie.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                Choice item = (Choice)e.getSource();
                
                if (listeCategorie.getSelectedItem().equals("Utilisateur")){
            
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.removeAll();
                    BarrePropriete.this.label = new JLabel(new ImageIcon("Image/user.png"));
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.add(label);
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.validate();
                }else if (listeCategorie.getSelectedItem().equals("Abstraction")){
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.removeAll();
                    BarrePropriete.this.label = new JLabel(new ImageIcon("Image/abstract.png"));
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.add(label);
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.validate();
                }else if( listeCategorie.getSelectedItem().equals("Application")){
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.removeAll();
                    BarrePropriete.this.label = new JLabel(new ImageIcon("Image/application.png"));
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.add(label);
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.validate();
                }else if (listeCategorie.getSelectedItem().equals("Interaction")){
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.removeAll();
                    BarrePropriete.this.label = new JLabel(new ImageIcon("Image/interaction.png"));
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.add(label);
                    BarrePropriete.this.f.barreLaterale.bl.papa.panel.validate();
                }
                BarrePropriete.this.f.aire.repaint();
            }
        
        });        
        
        this.add(labelTache);
        this.add(nomTache);
        this.add(labelListeCategorie);
        this.add(listeCategorie);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setVisible(true);  
    }
    
    
}
