package ui;

import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        
        setTitle("Propriétés");
        setSize(300, 250);
        setVisible(true);
        setLayout(new BorderLayout());
        
        JLabel l = new JLabel("Nom de la tâche");
        
        panN = new JPanel();
        
        panN.setBorder(BorderFactory.createTitledBorder("Nom de la tâche"));
        panN.add(nomTache);
        
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
        
        JPanel panC = new JPanel();
        JPanel panL = new JPanel();
        
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

                    Propriete.this.f.barreLaterale.bl.papa.panel.removeAll();
                    Propriete.this.label = new JLabel(new ImageIcon("Image/user.png"));
                    Propriete.this.f.barreLaterale.bl.papa.panel.add(label);
                    Propriete.this.f.barreLaterale.bl.papa.panel.validate();
                }else if (listeCategorie.getSelectedItem().equals("Abstraction")){
                    Propriete.this.f.barreLaterale.bl.papa.panel.removeAll();
                    Propriete.this.label = new JLabel(new ImageIcon("Image/abstract.png"));
                    Propriete.this.f.barreLaterale.bl.papa.panel.add(label);
                    Propriete.this.f.barreLaterale.bl.papa.panel.validate();
                }else if( listeCategorie.getSelectedItem().equals("Application")){
                    Propriete.this.f.barreLaterale.bl.papa.panel.removeAll();
                    Propriete.this.label = new JLabel(new ImageIcon("Image/application.png"));
                    Propriete.this.f.barreLaterale.bl.papa.panel.add(label);
                    Propriete.this.f.barreLaterale.bl.papa.panel.validate();
                }else if (listeCategorie.getSelectedItem().equals("Interaction")){
                    Propriete.this.f.barreLaterale.bl.papa.panel.removeAll();
                    Propriete.this.label = new JLabel(new ImageIcon("Image/interaction.png"));
                    Propriete.this.f.barreLaterale.bl.papa.panel.add(label);
                    Propriete.this.f.barreLaterale.bl.papa.panel.validate();
                }
                Propriete.this.f.aire.repaint();
            }

        });
            
        //panC.add(labelListeCategorie);
        panC.setBorder(BorderFactory.createTitledBorder("Catégorie"));
        panC.add(listeCategorie);

        JPanel panD = new JPanel(new BorderLayout());
        panD.setBorder(BorderFactory.createTitledBorder("Attribut de la tache"));
        //panD.add(la,BorderLayout.NORTH);

        EcouteurProp c = new EcouteurProp(this);

        JPanel att = new JPanel();
        JCheckBox it = new JCheckBox("Itérative");
        it.setActionCommand("it");
        it.addActionListener(c);

        JCheckBox b = new JCheckBox("Optionnel");
        b.setActionCommand("op");
        b.addActionListener(c);
        att.add(it);
        att.add(b);
        
        panD.add(att);

        panL.add(panC);
        panL.add(panD);

        //JPanel panW = new JPanel(new BorderLayout());
        //JPanel panE = new JPanel(new BorderLayout());
        JPanel panS = new JPanel();

        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Propriete.this.setVisible(false);
            }
        });

        panS.add(quitter);
        
        this.add(panN,BorderLayout.NORTH);
        //this.add(panW,BorderLayout.WEST);
        this.add(panL,BorderLayout.CENTER);
        //this.add(panE,BorderLayout.EAST);
        this.add(panS,BorderLayout.SOUTH);
        
        this.setVisible(true);  
        
        Image icone = Toolkit.getDefaultToolkit().getImage("Image/check.png");
        setIconImage(icone);
       
        JButton valider = new JButton("Valider");
        
        setLocationRelativeTo(null);
       
       
    }

    
}
