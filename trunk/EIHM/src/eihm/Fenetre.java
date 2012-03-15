package eihm;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame implements Runnable{
    
    
    public Fenetre(String name){
          SwingUtilities.invokeLater(this);
    }
    
    public void run(){
                
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
        
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        
        //frame.setSize(1000,800);
        this.setVisible(true);
    }
    
    
    
}
