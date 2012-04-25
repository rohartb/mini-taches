package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JCheckBox;


class EcouteurPreference implements ActionListener {
    
    

    public EcouteurPreference() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JCheckBox box = (JCheckBox)ae.getSource();
        if (box.isSelected()){
            System.out.println("Test1");
            String fichier = "config.txt";
            File config = new File(fichier);
            if (config.exists()) {
                config.delete();
            }
        }
    }
    
}
