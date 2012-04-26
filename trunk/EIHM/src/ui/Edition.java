/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sophie
 */
public class Edition {
    Noeud cop,col;
    Fenetre f;
    static int i=0;
    
    Edition(Fenetre f){
        this.f=f;
        cop = null;
        col=null;
    }
    
    void couper(Noeud n) {
        if(n.getPapa()!=null){
            f.barre.barreOutil.coller.setEnabled(true);
            f.menubar.coller.setEnabled(false);
            cop = copieArbre(n);
            f.aire.removePanel(n);               
            f.arbre.supprimerArbre(n);
            f.aire.repaint();
        }
    }
    

    void copier(Noeud n) {
        cop = copieArbre(n);
        f.barre.barreOutil.coller.setEnabled(true);
        f.menubar.coller.setEnabled(true);       
    }
    
    void coller() {
        if(cop!=null){
            Noeud n = copieArbre(f.arbre.root);
            //f.h.ajouterAnnuler(n);
            //f.h.viderRetablir();
            col=copieEtEcouteur(cop);//copie+ajout des écouteurs 
            col.setPapa(f.barreLaterale.bl.papa);
            f.barreLaterale.bl.papa.ajouterFils(col);          
            f.aire.repaint();
        }
    }

    /*void annuler() {
        //Noeud nouvelArbre = f.h.annuler();
        Noeud copie = copieArbre(f.arbre.root);
        if(nouvelArbre!=null){
            //f.h.ajouterRetablir(copie);
            Noeud res = copieEtEcouteur(nouvelArbre);
            f.aire.removePanel(f.arbre.root);
            f.arbre.supprimerArbre(f.arbre.root);
            f.arbre= new Arbre(res);
            f.aire.noeud = res;
            f.aire.repaint();
        }    
    }*/

    /*void retablir() {
        Noeud nouvelArbre = f.h.retablir();
        Noeud copie = copieArbre(f.arbre.root);
        if(nouvelArbre!=null){
            f.h.ajouterAnnuler(copie);
            Noeud res = copieEtEcouteur(nouvelArbre);
            f.aire.removePanel(f.arbre.root);
            f.arbre.supprimerArbre(f.arbre.root);
            f.arbre= new Arbre(res);
            f.aire.noeud = res;
            f.aire.repaint();
        }
    }*/

    Noeud copieArbre(Noeud cop) {
        Noeud res;
        if(cop.fils.isEmpty()){
            res = new Noeud(null,cop.nom,cop.type,cop.liaison);
            System.arraycopy(cop.propriete, 0, res.propriete, 0, 3);
            res.fils = new ArrayList<Noeud>();
            return res;
        }else{
            Noeud p = new Noeud(null,cop.nom,cop.type,cop.liaison);
            System.arraycopy(cop.propriete, 0, p.propriete, 0, 3);
            p.fils = new ArrayList<Noeud>();
            while(i<cop.fils.size()){
                res = copieArbre(cop.fils.get(i));
                res.setPapa(p);
                p.fils.add(res);
                i++;
            }
            i=0;
            return p;
        }
    }

    private Noeud copieEtEcouteur(Noeud cop) {
        Noeud res;
        if(cop.fils.isEmpty()){
            res = new Noeud(null,cop.nom,cop.type,cop.liaison);
            System.arraycopy(cop.propriete, 0, res.propriete, 0, 3);
            res.fils = new ArrayList<Noeud>();
            ajouterEcouteur(res);
            return res;
        }else{
            Noeud p = new Noeud(null,cop.nom,cop.type,cop.liaison);
            System.arraycopy(cop.propriete, 0, p.propriete, 0, 3);

            p.fils = new ArrayList<Noeud>();
            while(i<cop.fils.size()){
                res = copieEtEcouteur(cop.fils.get(i));
                res.setPapa(p);
                p.fils.add(res);
                i++;
            }
            i=0;
            ajouterEcouteur(p);
            return p;
        }
    }
    
    

    private void ajouterEcouteur(Noeud n) {
        EcouteurNoeud souris = new EcouteurNoeud(f, n);       
        n.panel.addMouseListener(souris);
        n.panel.addMouseMotionListener(souris);
        switch (n.type){
            case 1:
                n.panel.add(new JLabel(new ImageIcon("Image/user.png")));
                break;
            case 2:
                n.panel.add(new JLabel(new ImageIcon("Image/abstract.png")));
                break;
            case 3:
                n.panel.add(new JLabel(new ImageIcon("Image/application.png")));
                break;
            case 4:
                n.panel.add(new JLabel(new ImageIcon("Image/interaction.png")));
                break;
        }
            
    }
}
