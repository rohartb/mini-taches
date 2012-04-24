package ui;

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MenuBar extends JMenuBar {
    Fenetre f;

    public MenuBar(Fenetre f) {
        this.f = f;
        JMenu fichier = new JMenu("Fichier");
        JMenu edition = new JMenu("Edition");
        JMenu apparence = new JMenu("Apparence");
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
        
        JMenuItem annuler = new JMenuItem("Annuler");
        annuler.addActionListener(new EcouteurDeMenu(f));
        annuler.setActionCommand("annuler");
        annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK));
        
        JMenuItem retablir = new JMenuItem("Retablir");
        retablir.addActionListener(new EcouteurDeMenu(f));
        retablir.setActionCommand("retablir");
        retablir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK));
        
        edition.add(annuler);
        edition.add(retablir);
  
        
        //////////////////////////////////////////////////
        //                                              //
        //                  Menu Apparence              //
        //                                              //
        //////////////////////////////////////////////////
        
        
        //////////////////////////////////////////////////
        //                                              //
        //                  Menu Outil                  //
        //                                              //
        //////////////////////////////////////////////////
        
        JMenuItem preference = new JMenuItem("Preferences");
        preference.addActionListener(new EcouteurDeMenu(f));
        preference.setActionCommand("preference");
        preference.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
        
        outil.add(preference);
        
        //////////////////////////////////////////////////
        //                                              //
        //                  Menu Aide                   //
        //                                              //
        //////////////////////////////////////////////////
        
        JMenuItem aPropos = new JMenuItem("A propos");
        JMenuItem aideItem = new JMenuItem("Aide");
        aideItem.setActionCommand("aide");
        aideItem.addActionListener(new EcouteurDeMenu(f));
        aide.add(aPropos);
        aide.add(aideItem);
        
        this.add(fichier);
        this.add(edition);
        this.add(apparence);
        this.add(outil);
        this.add(aide);
        
    }
}
