/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
                f.aire.removePanel(f.barreLaterale.bl.papa);               
                f.arbre.supprimerArbre(f.barreLaterale.bl.papa);
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
                col = new Noeud(null,cop.nom,cop.type,cop.liaison);
                col.fils = new ArrayList<Noeud>();
                col=copieEtEcouteur(cop);//copie+ajout des écouteurs             
                coller(col);
                f.aire.repaint();
            }
        }
        else if(ae.getActionCommand().equals("ob")){
            f.changementEtat("ouvrir");
        }
        
         else if(ae.getActionCommand().equals("suppb")){
            f.changementEtat("supprimer");
        }
    }
    
    
    private void coller(Noeud n) {
        f.barreLaterale.bl.papa.ajouterFils(n);        
    }

    private Noeud copie(Noeud cop) {
        Noeud res;
        if(cop.fils.isEmpty()){
            res = new Noeud(null,cop.nom,cop.type,cop.liaison);
            res.fils = new ArrayList<Noeud>();
            return res;
        }else{
            Noeud p = new Noeud(null,cop.nom,cop.type,cop.liaison);
            p.fils = new ArrayList<Noeud>();
            while(i<cop.fils.size()){
                res = copie(cop.fils.get(i));
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
            res = new Noeud(null,cop.nom,cop.type,cop.liaison,cop.propriete);
            res.fils = new ArrayList<Noeud>();
            ajouterEcouteur(res);
            return res;
        }else{
            Noeud p = new Noeud(null,cop.nom,cop.type,cop.liaison,cop.propriete);
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
