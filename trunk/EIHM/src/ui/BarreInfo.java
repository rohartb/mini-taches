package ui;

import java.awt.Color;
import javax.swing.*;

public class BarreInfo extends JPanel {
    JLabel info;
    
    public BarreInfo() {
        info = new JLabel("Nouveau projet");
        this.add(info);
        this.setBorder(BorderFactory.createLineBorder(Color.green));
        this.setVisible(true);
    }

    void changerStatus(String status) {
        if(status.equals("nouveau")){
            info.setText("Nouveau projet arbre blabla");
        }
    }
    
}

