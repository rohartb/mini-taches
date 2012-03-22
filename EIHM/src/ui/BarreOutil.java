package ui;
import java.awt.*;
import javax.swing.*;

public class BarreOutil extends JPanel {
    
    public BarreOutil(){
        JButton nouveau = new JButton("N");
        JButton sauvegarder = new JButton("S");
        JButton copier = new JButton("Cop");
        JButton coller = new JButton("Col");
               
        this.add(nouveau);
        this.add(sauvegarder);
        this.add(copier);
        this.add(coller);
        
        this.setLayout(new GridLayout(0,20));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);        
    }
    
    
}
