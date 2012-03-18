package ui;

import java.awt.event.*;

class MenuListener implements ActionListener {

    public MenuListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("nouveau")){

        }
        if(e.getActionCommand().equals("ouvrir")){
            
        }
        if(e.getActionCommand().equals("sauvegarder")){
            
        }
        if(e.getActionCommand().equals("quitter")){
            System.exit(0);
        }
        if(e.getActionCommand().equals("annuler")){
            
        }
        if(e.getActionCommand().equals("restorer")){
            
        }
        
    }
    
}
