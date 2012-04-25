package ui;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Fenetre extends JFrame implements Runnable {

    BarreInfo barreInfo;
    BarreLaterale barreLaterale;
    Barre barre;
    Aide aide;
    Propos propos;
    AireDeDessin aire;
    String name;
    MenuBar menubar;
    Arbre arbre;
    FenetreDemarrage fd;
    Preference p;
    Historique h;
    Edition e;
    EcouteurNoeud souris;
    String[] options = {"Sauvegarder", "Continuer sans sauvegarder", "Annuler"};

    public Fenetre(String name) {
        this.name = name;
        h = new Historique(this);
        e= new Edition(this);
        
    }

    public void reinitialiser() {
        aire.removePanel(arbre.root);
        arbre.supprimerArbre(arbre.root);
        arbre = new Arbre();
        aire.noeud = arbre.root;
        souris.noeud = arbre.root;
        arbre.root.panel.addMouseListener(souris);
        arbre.root.panel.addMouseMotionListener(souris);
        arbre.root.panel.add(new JLabel(new ImageIcon("Image/user.png")));
        aire.repaint();
        barreLaterale.bl.setPapa(arbre.root);
        barreInfo.setInfo("nouveau");
    }

    public void changementEtat(String etat) {

        // Bouton nouveau
        if (etat.equals("nouveau")) {
            if (arbre.root.getNbFils() != 0) {
                int choix = JOptionPane.showOptionDialog(this, "Nouvel arbre :\n Voulez-vous sauvegarder l'arbre actuel", "Nouveau", 0, JOptionPane.QUESTION_MESSAGE, new ImageIcon("./images/question.png"), options, options[0]);
                if (choix == JOptionPane.YES_OPTION) {
                    changementEtat("sauvegarder");
                    reinitialiser();
                } else if (choix == JOptionPane.NO_OPTION) {
                    reinitialiser();
                }
            }
        }

        if (etat.equals("sauvegarder")) {
            barreInfo.setInfo("sauvegarde");
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(menubar);
            File selFile = fc.getSelectedFile();
        }
        if (etat.equals("ouvrir")) {
            barreInfo.setInfo("ouvrir");
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(menubar);
            File selFile = fc.getSelectedFile();

            if (selFile != null && arbre.root.getNbFils() != 0) {
                int choix = JOptionPane.showOptionDialog(this, "Ouverture de fichier :\nVoulez-vous sauvegarder l'arbre actuel", "Ouvrir", 0, JOptionPane.QUESTION_MESSAGE, new ImageIcon("./images/question.png"), options, options[0]);
                if (choix == JOptionPane.YES_OPTION) {
                    changementEtat("sauvegarder");
                    //ouvrir fichier
                } else if (choix == JOptionPane.NO_OPTION) {
                    //ouvrir fichier
                }

            } else {
                barreInfo.setInfo("rien");
            }
        }
        if (etat.equals("aide")) {
            barreInfo.setInfo("aide");
            aide.setVisible(true);
        }

        if (etat.equals("propos")) {
            barreInfo.setInfo("propos");
            propos = new Propos(this);
            barreInfo.setInfo("rien");
        }

        if (etat.equals("supprimer")) {
            if (barreLaterale.bl.papa != arbre.root) {
                barreInfo.setInfo("supression");
                aire.removePanel(barreLaterale.bl.papa);
                arbre.supprimerArbre(barreLaterale.bl.papa);
                aire.repaint();
            } else {
                if (arbre.root.fils.isEmpty()) {
                    barreInfo.setInfo("non supprime");
                }
            }
        }
        if (etat.equals("quitter")) {
            if (arbre.root.getNbFils() != 0) {
                String[] options = {"Sauvegarder", "Quitter sans sauvegarder", "Annuler"};
                int choix = JOptionPane.showOptionDialog(this, "\nVoulez-vous quitter sans sauvegarder ?", "Quitter", 0, JOptionPane.QUESTION_MESSAGE, new ImageIcon("./images/question.png"), options, options[0]);

                if (choix == JOptionPane.YES_OPTION) {
                    barreInfo.setInfo("sauvegarde");
                    changementEtat("sauvegarder");
                    System.exit(0);
                } else if (choix == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
            System.exit(0);
        }

        if (etat.equals("preference")) {
            p = new Preference();
        }
    }

    public void run() {

        fd = new FenetreDemarrage(this);

        //ajout MenuBar
        menubar = new MenuBar(this);
        //ajout BarreOutil
        //BarreOutil barreOutil = new BarreOutil();
        arbre = new Arbre(new Noeud(null, "Root", 1, 0));
        souris = new EcouteurNoeud(this, arbre.root);
        arbre.root.select=true;
        
        
        
        arbre.root.panel.addMouseListener(souris);
        arbre.root.panel.addMouseMotionListener(souris);
        arbre.root.panel.add(new JLabel(new ImageIcon("Image/user.png")));
        aire = new AireDeDessin(this);
        aire.addMouseListener(new EcouteurSouris(this));

        JScrollPane scrollDessin = new JScrollPane(aire,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
	        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
        scrollDessin.getHorizontalScrollBar().addAdjustmentListener(new ScrollAction());
        scrollDessin.getVerticalScrollBar().addAdjustmentListener(new ScrollAction());
        
        aide = new Aide(this);

        //ajout BarreInfo
        barreInfo = new BarreInfo();
        barre = new Barre(this);
        barreLaterale = new BarreLaterale(this);
        //ajout BarrePropriete
        //BarrePropriete barrePropriete = new BarrePropriete();




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
        add(scrollDessin, BorderLayout.CENTER);
        add(barreInfo, BorderLayout.SOUTH);
        aire.setVisible(true);

        setTitle(this.name);
        //setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        
        setMinimumSize(new Dimension(1000, 550));
        setExtendedState(this.MAXIMIZED_BOTH);


        addWindowListener(new EcouteurFenetreIcone(this, fd));
        //setMinimumSize(new Dimension(1000, 800));
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
                    }else{
                        fd.setVisible(false);
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
        pack();
    }
}
