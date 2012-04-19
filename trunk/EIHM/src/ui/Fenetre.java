package ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.swing.border.LineBorder;

public class Fenetre extends JFrame implements Runnable{
    BarreInfo barreInfo;
    BarreLaterale barreLaterale;
    Barre barre;
    AireDeDessin aire;
    String name;
    MenuBar menubar;
    Boolean menuOn = false;
    Arbre arbre;
    
    public Fenetre(String name){
          this.name = name;
    }

    public void changementEtat(String etat){
        if(etat.equals("nouveau")){
            barreInfo.changerStatus("nouveau");
        }
        if(etat.equals("sauvegarder")){
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(menubar);
            File selFile = fc.getSelectedFile();
        }
        if(etat.equals("ouvrir")){
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(menubar);
            File selFile = fc.getSelectedFile();
        }
    }

    public void run(){
              
        //ajout MenuBar
        menubar = new MenuBar(this);
        //ajout BarreOutil
        //BarreOutil barreOutil = new BarreOutil();
        Noeud n1 = new Noeud(null, "fils1",0,0,0);
        Noeud n2= new Noeud(null, "fils1",0,0,0);
        arbre = new Arbre(new Noeud(null, "Papa", 0,0,0));
        arbre.root.ajouterFils(n1);
        n1.ajouterFils(new Noeud(null, "fils6",0,0,0));
        n1.ajouterFils(new Noeud(null, "fils6",0,0,0));
        n1.ajouterFils(new Noeud(null, "fils6",0,0,0));
        //n2.ajouterFils(new Noeud(null, "fils6",0,0,0));
        //n2.ajouterFils(new Noeud(null, "fils6",0,0,0));
        //n2.ajouterFils(new Noeud(null, "fils6",0,0,0));
        arbre.root.ajouterFils(n2);
        arbre.root.ajouterFils(new Noeud(null, "fils3",0,0,0));
        arbre.root.ajouterFils(new Noeud(null, "fils4",0,0,0));
        arbre.root.ajouterFils(new Noeud(null, "fils5",0,0,0));
        aire = new AireDeDessin(this);
        //aire.addMouseListener(new EcouteurNoeud(this));
        //ajout BarreInfo
        barreInfo = new BarreInfo();
        barreLaterale = new BarreLaterale(this);
        //ajout BarrePropriete
        //BarrePropriete barrePropriete = new BarrePropriete();
        barre = new Barre(this);
        
        
        
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
