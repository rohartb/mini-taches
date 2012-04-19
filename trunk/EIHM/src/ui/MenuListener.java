package ui;

import java.awt.event.*;
import java.io.File;
import javax.swing.*;

class MenuListener implements ActionListener {
    Fenetre f;

    public MenuListener(Fenetre f) {
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
            System.exit(0);
        }
        if(e.getActionCommand().equals("annuler")){
            
        }
        if(e.getActionCommand().equals("restaurer")){
            
        }

        if(e.getActionCommand().equals("aide")){
            f.changementEtat("aide");
        }
        
    }
    
}
