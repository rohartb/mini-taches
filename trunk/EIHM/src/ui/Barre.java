package ui;

import javax.swing.*;
import java.awt.*;

public class Barre extends JPanel {
    Fenetre f;
    BarreOutil barreOutil;
    BarrePropriete barrePropriete;
    
    
    public Barre(Fenetre f) {
         this.f = f;
         this.setLayout(new BorderLayout());
         barreOutil = new BarreOutil(f);
         barrePropriete = new BarrePropriete(f);
         BarreZoom barreZ = new BarreZoom(f);
         
         this.add(barreOutil, BorderLayout.WEST);
         this.add(barrePropriete, BorderLayout.CENTER);
         this.add(barreZ, BorderLayout.EAST);

         this.setVisible(true);
    }

    
}
