package ui;

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MenuBar extends JMenuBar {
    Fenetre f;
    JMenuItem annuler;
    JMenuItem retablir;
    JMenuItem couper;
    JMenuItem copier;
    JMenuItem coller;
    

    public MenuBar(Fenetre f) {
        this.f = f;
        JMenu fichier = new JMenu("Fichier");
        JMenu edition = new JMenu("Edition");
        JMenu outil = new JMenu("Outils");
        JMenu aide = new JMenu("?");

        //////////////////////////////////////////////////
        //                                              //
        //                  Menu Fichier                //
        //                                              //
        //////////////////////////////////////////////////
        
        JMenuItem nouveau = new JMenuItem("Nouveau");
        nouveau.addActionListener(new EcouteurDeMenu(f));
        nouveau.setActionCommand("nouveau");
        nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        
        JMenuItem ouvrir = new JMenuItem("Ouvrir");
        ouvrir.addActionListener(new EcouteurDeMenu(f));
        ouvrir.setActionCommand("ouvrir");
        ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
        
        JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
        sauvegarder.addActionListener(new EcouteurDeMenu(f));
        sauvegarder.setActionCommand("sauvegarder");
        sauvegarder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(new EcouteurDeMenu(f));
        quitter.setActionCommand("quitter");
        quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, Event.ALT_MASK));
        
        fichier.add(nouveau);
        fichier.add(ouvrir);
        fichier.add(sauvegarder);
        fichier.add(quitter);
        
        
        //////////////////////////////////////////////////
        //                                              //
        //                  Menu Edition                //
        //                                              //
        //////////////////////////////////////////////////
        
        annuler = new JMenuItem("Annuler");
        annuler.addActionListener(new EcouteurDeMenu(f));
        annuler.setActionCommand("annuler");
        annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK));
        annuler.setEnabled(false);
        
        retablir = new JMenuItem("Retablir");
        retablir.addActionListener(new EcouteurDeMenu(f));
        retablir.setActionCommand("retablir");
        retablir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK));
        retablir.setEnabled(false);
        
        couper = new JMenuItem("Couper");
        couper.addActionListener(new EcouteurDeMenu(f));
        couper.setActionCommand("couper");
        couper.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
        couper.setEnabled(false);        
        
        copier = new JMenuItem("Copier");
        copier.addActionListener(new EcouteurDeMenu(f));
        copier.setActionCommand("copier");
        copier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
        copier.setEnabled(true);
        
        coller = new JMenuItem("Coller");
        coller.addActionListener(new EcouteurDeMenu(f));
        coller.setActionCommand("coller");
        coller.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
        couper.setEnabled(false);
        
        edition.add(annuler);
        edition.add(retablir);
        edition.add(couper);
        edition.add(copier);
        edition.add(coller);
  
        
        
        //////////////////////////////////////////////////
        //                                              //
        //                  Menu Outil                  //
        //                                              //
        //////////////////////////////////////////////////
        
        JMenuItem preference = new JMenuItem("Preferences");
        preference.addActionListener(new EcouteurDeMenu(f));
        preference.setActionCommand("preference");
        preference.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
        
        JMenuItem prop = new JMenuItem("Propriétés");
        prop.addActionListener(new EcouteurDeMenu(f));
        prop.setActionCommand("prop");
        
        outil.add(preference);
        outil.add(prop);
        
        //////////////////////////////////////////////////
        //                                              //
        //                  Menu Aide                   //
        //                                              //
        //////////////////////////////////////////////////
        
        JMenuItem aPropos = new JMenuItem("A propos");
        aPropos.setActionCommand("propos");
        aPropos.addActionListener(new EcouteurDeMenu(f));
        JMenuItem aideItem = new JMenuItem("Astuces");
        aideItem.setActionCommand("astuce");
        aideItem.addActionListener(new EcouteurDeMenu(f));
        aide.add(aPropos);
        aide.add(aideItem);
        
        this.add(fichier);
        this.add(edition);
        this.add(outil);
        this.add(aide);
        
    }
}
