package ui;

import javax.swing.*;
import java.awt.*;

public class Barre extends JPanel {

    public Barre() {
        
         this.setLayout(new BorderLayout());
         BarreOutil barreOutil = new BarreOutil();
         BarrePropriete barrePropriete = new BarrePropriete();
         
         this.add(barreOutil, BorderLayout.NORTH);
         this.add(barrePropriete, BorderLayout.SOUTH);
         
         this.setVisible(true);
    }
    
}
