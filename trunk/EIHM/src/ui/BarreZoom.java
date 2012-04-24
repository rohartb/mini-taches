package ui;

import java.awt.*;
import javax.swing.*;

class BarreZoom extends JPanel {
    Fenetre f;

    public BarreZoom(Fenetre f) {
        this.f = f;

        JSlider s = new JSlider(0, 100,20);
        s.setMajorTickSpacing(50);
        s.setMinorTickSpacing(10);
        s.setPaintTicks(true);
        s.setPaintLabels(true);
        
        setLayout(new BorderLayout());
        JLabel l = new JLabel(" Zoom ");
        setBorder(BorderFactory.createLineBorder(Color.black));
        add(l,BorderLayout.WEST);
        add(s,BorderLayout.CENTER);
        add(new JPanel(),BorderLayout.EAST);

    }


}
