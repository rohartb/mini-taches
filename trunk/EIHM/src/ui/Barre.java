package ui;

import javax.swing.*;
import java.awt.*;

public class Barre extends JPanel {
    Fenetre f;
    
    public Barre(Fenetre f) {
         this.f = f;
         this.setLayout(new BorderLayout());
         BarreOutil barreOutil = new BarreOutil(f);
         BarrePropriete barrePropriete = new BarrePropriete();
         BarreZoom barreZ = new BarreZoom(f);
         
         this.add(barreOutil, BorderLayout.NORTH);
         this.add(barrePropriete, BorderLayout.WEST);
         this.add(barreZ, BorderLayout.EAST);

         this.setVisible(true);
    }
    
}
