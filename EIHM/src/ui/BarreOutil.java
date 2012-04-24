package ui;
import java.awt.*;
import javax.swing.*;

public class BarreOutil extends JPanel {
    Fenetre f;
    
    public BarreOutil(Fenetre f){
        this.f = f;
        JButton nouveau = new JButton(new ImageIcon("Image/new.gif"));
        JButton ouvrir = new JButton(new ImageIcon("Image/open.gif"));
        JButton sauvegarder = new JButton(new ImageIcon("Image/save.gif"));
        JButton couper = new JButton(new ImageIcon("Image/cut.gif"));
        JButton copier = new JButton(new ImageIcon("Image/copy.gif"));
        JButton coller = new JButton(new ImageIcon("Image/paste.gif"));
        JButton supprimer = new JButton(new ImageIcon("Image/delete.jpg"));
        
        EcouteurOption eo = new EcouteurOption(f);
        
        nouveau.setToolTipText("Nouveau");
        nouveau.setPreferredSize(new Dimension(30,30));
        nouveau.setActionCommand("nb");
        nouveau.addActionListener(eo);
        
        ouvrir.setToolTipText("Ouvrir");
        ouvrir.setPreferredSize(new Dimension(30,30));
        ouvrir.setActionCommand("ob");
        ouvrir.addActionListener(eo);
        
        sauvegarder.setToolTipText("Sauvegarder");
        sauvegarder.setActionCommand("sb");
        sauvegarder.setPreferredSize(new Dimension(30,30));
        sauvegarder.addActionListener(eo);
                
        couper.setToolTipText("Couper");
        couper.setActionCommand("coupb");
        couper.setPreferredSize(new Dimension(30,30));
        couper.addActionListener(eo);
        
        copier.setToolTipText("Copier");
        copier.setActionCommand("copb");
        copier.setPreferredSize(new Dimension(30,30));
        copier.addActionListener(eo);
                
        coller.setToolTipText("Coller");
        coller.setPreferredSize(new Dimension(30,30));
        coller.setActionCommand("collb");
        coller.addActionListener(eo);      
        
        supprimer.setToolTipText("Supprimer");
        supprimer.setPreferredSize(new Dimension(30,30));
        supprimer.setActionCommand("suppb");
        supprimer.addActionListener(eo);  
               
        this.add(nouveau);
        this.add(ouvrir);
        this.add(sauvegarder);
        this.add(couper);
        this.add(copier);
        this.add(coller);
        this.add(supprimer);
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);        
    }
    
    
}
