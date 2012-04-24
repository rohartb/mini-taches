package ui;

import java.awt.event.*;
import java.io.File;
import javax.swing.*;

class EcouteurDeMenu implements ActionListener {
    Fenetre f;

    public EcouteurDeMenu(Fenetre f) {
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("nouveau")){
            f.changementEtat("nouveau");
        }
        if(e.getActionCommand().equals("ouvrir")){
            f.changementEtat("ouvrir");
        }
        if(e.getActionCommand().equals("sauvegarder")){
            f.changementEtat("sauvegarder");
        }
        if(e.getActionCommand().equals("quitter")){
            f.changementEtat("quitter");
        }
        if(e.getActionCommand().equals("annuler")){
            
        }
        if(e.getActionCommand().equals("restaurer")){
            
        }

        if(e.getActionCommand().equals("aide")){
            f.changementEtat("aide");
        }

        if(e.getActionCommand().equals("propos")){
            f.changementEtat("propos");
        }
        
        if(e.getActionCommand().equals("preference")){
            f.changementEtat("preference");
        }
        
    }
    
}