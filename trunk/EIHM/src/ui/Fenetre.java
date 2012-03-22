package ui;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame implements Runnable{
    
    String name;
    
    public Fenetre(String name){
          this.name = name;
          SwingUtilities.invokeLater(this);
    }
    
    public void run(){
              
        //ajout MenuBar
        MenuBar menubar = new MenuBar();
        
        //////////////////////////////////////////////////
        //                                              //
        //          Addaptation de l'apparence          //
        //               par rapport a l'OS             //
        //////////////////////////////////////////////////
        try {
            if (System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty ("apple.laf.useScreenMenuBar","true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Test");
            } else {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch(Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }
        
        
        //////////////////////////////////////////////////
        //                                              //
        //            Création de la fenetre            //
        //                                              //
        //////////////////////////////////////////////////

        Image icone = Toolkit.getDefaultToolkit().getImage("Image/check.png");
        this.setIconImage(icone);
        this.setJMenuBar(menubar);
        this.setTitle(this.name);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        
        this.setVisible(true);
        
        
    }
    
    
    
}
