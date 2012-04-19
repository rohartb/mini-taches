package ui;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JComponent;

public class Aide extends JDialog{
    private static final long serialVersionUID = 1L;
    EcouteurDAide eas;
    int nbAide;
    JButton precedent;
    JButton suivant;
    JLabel lesAides;
    ImageIcon i[] = new ImageIcon[8];
    Fenetre f;
    
    public Aide(Fenetre f){
        /*i[0] = new ImageIcon("images/aide1.png");
        i[1] = new ImageIcon("images/aide2.png");
        i[2] = new ImageIcon("images/aide3.png");
        i[3] = new ImageIcon("images/aide4.png");
        i[4] = new ImageIcon("images/aide5.png");
        i[5] = new ImageIcon("images/aide6.png");
        i[6] = new ImageIcon("images/aide7.png");
        i[7] = new ImageIcon("images/aide8.png");*/

	this.f = f;
	this.nbAide = 1;
	this.eas = new EcouteurDAide(f,this,this.nbAide);

	this.setTitle("Aide");
        this.setModal(true);

        this.setResizable(false);
        //this.addWindowListener(eas);
	this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	lesAides = new JLabel();


	// Quitter / Suivant / Précédent

	JPanel panelBouton = new JPanel(); //Panel du boutons ok/annuler
	JButton quitter = new JButton("Quitter");
	quitter.setActionCommand("quitter");
	quitter.addActionListener(eas);

	precedent = new JButton("Précédent");
	precedent.setActionCommand("precedent");
	precedent.addActionListener(eas);

	suivant = new JButton("Suivant");
	suivant.setActionCommand("suivant");
	suivant.addActionListener(eas);

	panelBouton.add(quitter);
	panelBouton.add(precedent);
	panelBouton.add(suivant);

	this.precedent.setEnabled(false);

	this.add(lesAides, BorderLayout.NORTH);
	this.add(panelBouton,BorderLayout.SOUTH);
	this.setSize(500,410);


	// Position au centre de la fenetre principale
	this.setLocationRelativeTo(null);
    }


    public void afficherAide(){
	nbAide = 1;
	this.lesAides.setIcon(i[0]) ;
	this.precedent.setEnabled(false);
	this.suivant.setEnabled(true);
	this.setVisible(true);

    }
}