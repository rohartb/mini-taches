package ui;

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar() {
       
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
        nouveau.addActionListener(new MenuListener());
        nouveau.setActionCommand("nouveau");
        nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        
        JMenuItem ouvrir = new JMenuItem("Ouvrir");
        ouvrir.addActionListener(new MenuListener());
        ouvrir.setActionCommand("ouvrir");
        ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
        
        JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
        sauvegarder.addActionListener(new MenuListener());
        sauvegarder.setActionCommand("sauvegarder");
        sauvegarder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(new MenuListener());
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
        annuler.addActionListener(new MenuListener());
        annuler.setActionCommand("annuler");
        annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK));
        
        JMenuItem retablir = new JMenuItem("Retablir");
        retablir.addActionListener(new MenuListener());
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
        
        
        //////////////////////////////////////////////////
        //                                              //
        //                  Menu Aide                   //
        //                                              //
        //////////////////////////////////////////////////
        
        this.add(fichier);
        this.add(edition);
        this.add(apparence);
        this.add(outil);
        this.add(aide);
        
    }
}