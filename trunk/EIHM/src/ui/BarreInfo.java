package ui;

import java.awt.Color;
import javax.swing.*;

public class BarreInfo extends JPanel {
    JLabel info;
    
    public BarreInfo() {
        info = new JLabel("Test bisounours !!!!!! LALALALALAALA");
        this.add(info);
        this.setBorder(BorderFactory.createLineBorder(Color.green));
        this.setVisible(true);
    }
    
}

