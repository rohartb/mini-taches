package ui;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


class EcouteurListeCategorie implements ItemListener {
    
    Noeud noeud;
    Fenetre f;
    JLabel label;    

    public EcouteurListeCategorie(Noeud noeud,Fenetre f) {
        this.noeud = noeud;
        this.f = f;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Choice item = (Choice)e.getSource();
        if (item.getSelectedItem().equals("Utilisateur")){
            noeud.panel.removeAll();
            label = new JLabel(new ImageIcon("Image/user.png"));
            noeud.panel.add(label);
            noeud.panel.validate();
        }else if (item.getSelectedItem().equals("Abstraction")){
            noeud.panel.removeAll();
            label = new JLabel(new ImageIcon("Image/abstract.png"));
            noeud.panel.add(label);
            noeud.panel.validate();
        }else if( item.getSelectedItem().equals("Application")){
            noeud.panel.removeAll();
            label = new JLabel(new ImageIcon("Image/application.png"));
            noeud.panel.add(label);
            noeud.panel.validate();
        }else if (item.getSelectedItem().equals("Interaction")){
            noeud.panel.removeAll();
            label = new JLabel(new ImageIcon("Image/interaction.png"));
            noeud.panel.add(label);
            noeud.panel.validate();
        }
        f.aire.repaint();
    }
    
}
