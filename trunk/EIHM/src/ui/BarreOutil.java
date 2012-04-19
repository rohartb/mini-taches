package ui;
import java.awt.*;
import javax.swing.*;

public class BarreOutil extends JPanel {
    Fenetre f;
    
    public BarreOutil(Fenetre f){
        this.f = f;
        JButton nouveau = new JButton(new ImageIcon("Image/nouveau.jpg"));
        JButton sauvegarder = new JButton(new ImageIcon("Image/sauvegarder.jpg"));
        JButton copier = new JButton(new ImageIcon("Image/copier.jpg"));
        JButton coller = new JButton(new ImageIcon("Image/coller.jpg"));
        
        EcouteurOption eo = new EcouteurOption(f);
        
        nouveau.setToolTipText("Nouveau");
        nouveau.setActionCommand("nb");
        nouveau.addActionListener(eo);   
        
        sauvegarder.setToolTipText("Sauvegarder");
        sauvegarder.setActionCommand("sb");
        sauvegarder.addActionListener(eo);
                
        copier.setToolTipText("Copier");
        copier.setActionCommand("copb");
        copier.addActionListener(eo);
                
        coller.setToolTipText("Coller");
        coller.setActionCommand("colb");
        coller.addActionListener(eo);       
               
        this.add(nouveau);
        this.add(sauvegarder);
        this.add(copier);
        this.add(coller);
        
        this.setLayout(new GridLayout(0,20));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);        
    }
    
    
}
