/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author sophie
 */
public class EcouteurOption implements ActionListener {
    Fenetre f;
    Noeud cop;
    Noeud col;
    ArrayList<Noeud> clone = new ArrayList<Noeud>();
    static int i=0;

    public EcouteurOption(Fenetre f) {
        this.f = f;
        cop=null;
        col = null;
    }
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("nb")){
            f.changementEtat("nouveau");
        }
        else if(ae.getActionCommand().equals("sb")){
            f.changementEtat("sauvegarder");
        }
        else if(ae.getActionCommand().equals("coupb")){
            if(f.barreLaterale.bl.papa!=null){
                cop= copie(f.barreLaterale.bl.papa);
                f.arbre.supprimerArbre(f.barreLaterale.bl.papa);  
                f.aire.removeAll();
                f.aire.updateUI();
                f.aire.repaint();
            }
        }
        else if(ae.getActionCommand().equals("copb")){
            if(f.barreLaterale.bl.papa!=null){
                cop= f.barreLaterale.bl.papa;           
            }
        }
        else if(ae.getActionCommand().equals("collb")){
            if(cop!=null){
                col = new Noeud(null,cop.nom,cop.type,cop.liaison,cop.propriete);
                col.fils = new ArrayList<Noeud>();
                col=copie(cop);             
                coller(col);
                f.aire.repaint();
            }
        }
        else if(ae.getActionCommand().equals("ob")){
            f.changementEtat("ouvrir");
        }
    }
    
    
    private void coller(Noeud n) {
        f.barreLaterale.bl.papa.ajouterFils(n);                   
    }

    private Noeud copie(Noeud cop) {
        Noeud res;
        if(cop.fils.isEmpty()){
            res = new Noeud(null,cop.nom,cop.type,cop.liaison,cop.propriete);
            res.fils = new ArrayList<Noeud>();
            return res;
        }else{
            Noeud p = new Noeud(null,cop.nom,cop.type,cop.liaison,cop.propriete);
            p.fils = new ArrayList<Noeud>();
            while(i<cop.fils.size()){
                res = copie(cop.fils.get(i));
                p.fils.add(res);
                res.papa=p;
                i++;
            }
            i=0;
            return p;
        }
    }

}
