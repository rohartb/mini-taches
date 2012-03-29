package ui;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame implements Runnable{
    BarreInfo barreInfo;
    BarreLaterale barreLaterale;
    Barre barre;
    AireDeDessin aire;
    String name;
    MenuBar menubar;
    
    public Fenetre(String name){
          this.name = name;
    }

    public void changementEtat(String etat){
        if(etat.equals("nouveau")){
            barreInfo.changerStatus("nouveau");
        }
        if(etat.equals("nouveau")){
            
        }
        if(etat.equals("nouveau")){

        }
    }

    public void run(){
              
        //ajout MenuBar
        menubar = new MenuBar(this);
        //ajout BarreOutil
        //BarreOutil barreOutil = new BarreOutil();
        aire = new AireDeDessin();
        //ajout BarreInfo
        barreInfo = new BarreInfo();
        barreLaterale = new BarreLaterale();
        //ajout BarrePropriete
        //BarrePropriete barrePropriete = new BarrePropriete();
        Barre barre = new Barre();
        
        
        //////////////////////////////////////////////////
        //                                              //
        //          Addaptation de l'apparence          //
        //               par rapport a l'OS             //
        //////////////////////////////////////////////////
        /*try {
            if (System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty ("apple.laf.useScreenMenuBar","true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Test");
            } else {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch(Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }*/
        
        
        //////////////////////////////////////////////////
        //                                              //
        //            Création de la fenetre            //
        //                                              //
        //////////////////////////////////////////////////

        Image icone = Toolkit.getDefaultToolkit().getImage("Image/check.png");
        setIconImage(icone);

        setJMenuBar(menubar);

        add(barreLaterale, BorderLayout.WEST);
        //add(barreOutil,BorderLayout.NORTH);
        add(barre,BorderLayout.NORTH);
        add(aire,BorderLayout.CENTER);
        add(barreInfo,BorderLayout.SOUTH);

        aire.setVisible(true);
        
        setTitle(this.name);
        pack();
        //setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(this.MAXIMIZED_BOTH);
        
        setVisible(true);
    }
    
    
    
}
