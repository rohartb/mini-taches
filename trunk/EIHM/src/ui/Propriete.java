package ui;

import java.awt.Image;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class Propriete extends JDialog{
    Choice listeCategorie;
     JTextField nomTache;
     Fenetre f;
     JPanel panN;
     JLabel label;
    
    public Propriete(final Fenetre f) {
        this.f = f;
        JLabel labelTache = new JLabel("Nom de la tâche :");
        nomTache = new JTextField(8);

        
        setTitle("Propriété");
        setSize(300, 200);
        setVisible(true);
        setLayout(new BorderLayout());
        
        JLabel l = new JLabel("Nom de la tache");
        
        panN = new JPanel(new BorderLayout());
        
        panN.add(l,BorderLayout.NORTH);
        panN.add(nomTache,BorderLayout.WEST);
        
        nomTache.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {            
            f.barreLaterale.bl.papa.setNom(nomTache.getText());
            f.aire.repaint();
        }
        public void removeUpdate(DocumentEvent e) {
            f.barreLaterale.bl.papa.setNom(nomTache.getText());
            f.aire.repaint();
        }
        public void insertUpdate(DocumentEvent e) {
            f.barreLaterale.bl.papa.setNom(nomTache.getText());
            f.aire.repaint();
        }

        });
        
        JPanel panC = new JPanel(new BorderLayout());

        
        JLabel labelListeCategorie = new JLabel("Catégorie");
        listeCategorie = new Choice();
        listeCategorie.addItem("");
        listeCategorie.addItem("Utilisateur");
        listeCategorie.addItem("Abstraction");
        listeCategorie.addItem("Application");
        listeCategorie.addItem("Interaction");
        listeCategorie.select("");
            
        panC.add(labelListeCategorie,BorderLayout.NORTH);
        panC.add(listeCategorie,BorderLayout.WEST);
        
        
        JPanel panW = new JPanel(new BorderLayout());
        JPanel panE = new JPanel(new BorderLayout());
        
        this.add(panN,BorderLayout.NORTH);
        this.add(panW,BorderLayout.WEST);
        this.add(panC,BorderLayout.CENTER);
        this.add(panE,BorderLayout.EAST);
        
        this.setVisible(true);  
        
        Image icone = Toolkit.getDefaultToolkit().getImage("Image/check.png");
        setIconImage(icone);
       
        JButton valider = new JButton("Valider");
        
        setLocationRelativeTo(null);
       
       
    }

    
}
