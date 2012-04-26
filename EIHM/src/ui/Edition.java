
package ui;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Edition {
    Noeud cop,col;
    Fenetre f;
    
    Edition(Fenetre f){
        this.f=f;
        cop = null;
        col=null;
    }
    
    void couper(Noeud n) {
        if(n.getPapa()!=null){
            Noeud l = copieEtEcouteur(f.arbre.root);
            f.h.ajouterAnnuler(l);
            f.h.viderRetablir();
            f.barre.barreOutil.coller.setEnabled(true);
            f.menubar.coller.setEnabled(false);
            cop = copieEtEcouteur(n);
            f.aire.removePanel(n);               
            f.arbre.supprimerArbre(n);
            f.aire.repaint();
        }
    }
    

    void copier(Noeud n) {
        cop = copieEtEcouteur(n);
        f.barre.barreOutil.coller.setEnabled(true);
        f.menubar.coller.setEnabled(true);       
    }
    
    void coller() {
        System.out.println(cop!=null);
        if(cop!=null){
            Noeud n = copieEtEcouteur(f.arbre.root);
            f.h.ajouterAnnuler(n);
            f.h.viderRetablir();
            col=copieEtEcouteur(cop);//copie+ajout des écouteurs 
            col.setPapa(f.barreLaterale.bl.papa);
            f.barreLaterale.bl.papa.ajouterFils(col);          
            f.aire.repaint();
        }
    }

    void annuler() {
        Noeud nouvelArbre = f.h.annuler();
        Noeud copie = copieEtEcouteur(f.arbre.root);
        if(nouvelArbre!=null){
            f.h.ajouterRetablir(copie);
            Noeud res = copieEtEcouteur(nouvelArbre);
            f.aire.removePanel(f.arbre.root);
            f.arbre.supprimerArbre(f.arbre.root);
            f.arbre= new Arbre(res);
            f.aire.noeud = res;
            f.aire.repaint();
        }    
    }

    void retablir() {
        Noeud nouvelArbre = f.h.retablir();
        Noeud copie = copieEtEcouteur(f.arbre.root);
        if(nouvelArbre!=null){
            f.h.ajouterAnnuler(copie);
            Noeud res = copieEtEcouteur(nouvelArbre);
            f.aire.removePanel(f.arbre.root);
            f.arbre.supprimerArbre(f.arbre.root);
            f.arbre= new Arbre(res);
            f.aire.noeud = res;
            f.aire.repaint();
        }
    }



    Noeud copieEtEcouteur(Noeud cop) {
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
            Iterator it = cop.fils.iterator();
            while(it.hasNext()){
                Noeud tmp = (Noeud) it.next();
                res = copieEtEcouteur(tmp);
                res.setPapa(p);
                p.fils.add(res);
            }
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
