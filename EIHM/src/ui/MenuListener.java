package ui;

import java.awt.event.*;
import java.io.File;
import javax.swing.*;

class MenuListener implements ActionListener {
    
    MenuBar menubar;

    public MenuListener(MenuBar menubar) {
        this.menubar = menubar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("nouveau")){

        }
        if(e.getActionCommand().equals("ouvrir")){
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(menubar);
            File selFile = fc.getSelectedFile();
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
