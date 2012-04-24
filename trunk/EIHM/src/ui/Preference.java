package ui;

import javax.swing.JDialog;

public class Preference extends JDialog {

    public Preference() {
        setTitle("Préférences");
        setSize(500, 410);
        setVisible(true);
        
        
        //fenetre centrer
        this.setLocationRelativeTo(null);
    }
    
    
}
