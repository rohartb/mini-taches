package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

public class Fenetre extends JFrame implements Runnable {

    BarreInfo barreInfo;
    BarreLaterale barreLaterale;
    Barre barre;
    Aide aide;
    AireDeDessin aire;
    String name;
    MenuBar menubar;
    Boolean menuOn = false;
    Arbre arbre;
    FenetreDemarrage fd;

    public Fenetre(String name) {
        this.name = name;
    }

    public void changementEtat(String etat) {
        if (etat.equals("nouveau")) {
            String[] options = {"Sauvegarder", "Continuer sans sauvegarder", "Annuler"};
            int choix = JOptionPane.showOptionDialog(this, "Nouvel arbre :\n Voulez-vous sauvegarder l'arbre actuel", "Nouveau", 0, JOptionPane.QUESTION_MESSAGE, new ImageIcon("./images/question.png"), options, options[0]);

            if (choix == JOptionPane.YES_OPTION) {
                changementEtat("sauvegarder");
                arbre = new Arbre(new Noeud(null, "papa", 0, 0, 0));
                aire.repaint();
                barreInfo.info.setText("Nouveau");
            } else if (choix == JOptionPane.NO_OPTION) {
                arbre = new Arbre(new Noeud(null, "papa", 0, 0, 0));
                aire.repaint();
                barreInfo.info.setText("Nouveau");
            }
        }
        if (etat.equals("sauvegarder")) {
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(menubar);
            File selFile = fc.getSelectedFile();
        }
        if (etat.equals("ouvrir")) {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(menubar);
            File selFile = fc.getSelectedFile();
            if (selFile != null && arbre.root.getNbFils()!=0) {
                String[] options = {"Sauvegarder", "Continuer sans sauvegarder", "Annuler"};
                int choix = JOptionPane.showOptionDialog(this, "Nouvel arbre :\n Voulez-vous sauvegarder l'arbre actuel", "Ouvrir", 0, JOptionPane.QUESTION_MESSAGE, new ImageIcon("./images/question.png"), options, options[0]);

                if (choix == JOptionPane.YES_OPTION) {
                    changementEtat("sauvegarder");
                    arbre = new Arbre(new Noeud(null, "papa", 0, 0, 0));
                    aire.repaint();
                    barreInfo.info.setText("Nouveau");
                } else if (choix == JOptionPane.NO_OPTION) {
                    arbre = new Arbre(new Noeud(null, "papa", 0, 0, 0));
                    aire.repaint();
                    barreInfo.info.setText("Nouveau");
                }
            }
        }
        if (etat.equals("aide")) {
            aide.setVisible(true);
        }
        /*if(etat.equals("demo")){
        }*/
    }

    public void run() {

        fd = new FenetreDemarrage(this);

        //ajout MenuBar
        menubar = new MenuBar(this);
        //ajout BarreOutil
        //BarreOutil barreOutil = new BarreOutil();
        arbre = new Arbre(new Noeud(null, "Papa", 0, 0, 0));
        aire = new AireDeDessin(this);
        aide = new Aide(this);
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
        add(barre, BorderLayout.NORTH);
        add(aire, BorderLayout.CENTER);
        add(barreInfo, BorderLayout.SOUTH);
        aire.setVisible(true);

        setTitle(this.name);
        pack();
        //setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(this.MAXIMIZED_BOTH);

        addWindowListener(new EcouteurFenetreIcone(this,fd));
        
        setVisible(true);

        // On vérifie si il faut afficher la fenetre de démarrage
        String fichier = "config.txt";
        File config = new File(fichier);
        if (config.exists()) {
            //lecture du fichier texte	
            try {
                InputStream ips = new FileInputStream(fichier);
                InputStreamReader ipsr = new InputStreamReader(ips);
                BufferedReader br = new BufferedReader(ipsr);
                String valeurCheckBox;
                while ((valeurCheckBox = br.readLine()) != null) {
                    if (valeurCheckBox.equals("false")) {
                        fd.setAlwaysOnTop(true);
                        fd.setVisible(true);
                    }
                }
                br.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            //Dans le cas du premier lancement de l'application, le fichier config n'existe pas
            //donc on affiche obligatoirement la fenetre
            //Et dans le cas aussi que même si au premier lancement on ne clique pas sur la checkBox
            //on doit afficher la fenetre au prochain démarrage de l'application
            fd.setAlwaysOnTop(true);
            fd.setVisible(true);
        }
    }
}
