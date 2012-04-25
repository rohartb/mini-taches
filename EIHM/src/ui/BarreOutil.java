package ui;
import java.awt.*;
import javax.swing.*;

public class BarreOutil extends JPanel {
    Fenetre f;
    JButton augmenterEtage;
    JButton diminuerEtage;
    JButton annuler;
    JButton retablir;
    JButton couper;
    JButton copier;
    JButton coller;
    JButton supprimer;
    
    public BarreOutil(Fenetre f){
        this.f = f;
        JButton nouveau = new JButton(new ImageIcon("Image/new.gif"));
        JButton ouvrir = new JButton(new ImageIcon("Image/open.gif"));
        JButton sauvegarder = new JButton(new ImageIcon("Image/save.gif"));
        couper = new JButton(new ImageIcon("Image/cut.gif"));
        copier = new JButton(new ImageIcon("Image/copy.gif"));
        coller = new JButton(new ImageIcon("Image/paste.gif"));
        supprimer = new JButton(new ImageIcon("Image/delete.jpg"));
        annuler = new JButton(new ImageIcon("Image/undo.gif"));
        retablir = new JButton(new ImageIcon("Image/redo.gif"));
        augmenterEtage = new JButton(new ImageIcon("Image/rise.gif"));
        diminuerEtage = new JButton(new ImageIcon("Image/unrise.gif"));
        
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
        couper.setEnabled(false);
        
        copier.setToolTipText("Copier");
        copier.setActionCommand("copb");
        copier.setPreferredSize(new Dimension(30,30));
        copier.addActionListener(eo);
        copier.setEnabled(true);
                
        coller.setToolTipText("Coller");
        coller.setPreferredSize(new Dimension(30,30));
        coller.setActionCommand("collb");
        coller.addActionListener(eo);
        coller.setEnabled(false);
        
        supprimer.setToolTipText("Supprimer");
        supprimer.setPreferredSize(new Dimension(30,30));
        supprimer.setActionCommand("suppb");
        supprimer.addActionListener(eo);
        supprimer.setEnabled(false);
        
        annuler.setToolTipText("Annuler");
        annuler.setPreferredSize(new Dimension(30,30));
        annuler.setActionCommand("annuler");
        annuler.addActionListener(eo);
        annuler.setEnabled(false);
        
        retablir.setToolTipText("Retablir");
        retablir.setPreferredSize(new Dimension(30,30));
        retablir.setActionCommand("retablir");
        retablir.addActionListener(eo); 
        retablir.setEnabled(false);
        
        augmenterEtage.setToolTipText("Augmenter niveau");
        augmenterEtage.setPreferredSize(new Dimension(30,30));
        augmenterEtage.setActionCommand("augn");
        augmenterEtage.addActionListener(eo);
        augmenterEtage.setEnabled(false);
        
        
        diminuerEtage.setToolTipText("Diminuer niveau");
        diminuerEtage.setPreferredSize(new Dimension(30,30));
        diminuerEtage.setActionCommand("dimn");
        diminuerEtage.addActionListener(eo); 
        diminuerEtage.setEnabled(false);
               
        this.add(nouveau);
        this.add(ouvrir);
        this.add(sauvegarder);
        this.add(couper);
        this.add(copier);
        this.add(coller);
        this.add(supprimer);
        this.add(annuler);
        this.add(retablir);
        this.add(augmenterEtage);
        this.add(diminuerEtage);
        
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);        
    }
    
    
}
