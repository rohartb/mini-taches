package ui;
import java.awt.*;
import javax.swing.*;

public class BarreOutil extends JPanel {
    
    public BarreOutil(){
        JButton nouveau = new JButton(new ImageIcon("Image/nouveau.jpg"));
        JButton sauvegarder = new JButton(new ImageIcon("Image/sauvegarder.jpg"));
        JButton copier = new JButton(new ImageIcon("Image/copier.jpg"));
        JButton coller = new JButton(new ImageIcon("Image/coller.jpg"));
        
        nouveau.setToolTipText("Nouveau");
        sauvegarder.setToolTipText("Sauvegarder");
        copier.setToolTipText("Copier");
        coller.setToolTipText("Coller");
               
        this.add(nouveau);
        this.add(sauvegarder);
        this.add(copier);
        this.add(coller);
        
        this.setLayout(new GridLayout(0,20));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);        
    }
    
    
}
