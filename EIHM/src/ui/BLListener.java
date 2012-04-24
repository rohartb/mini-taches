/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bastien
 */
class BLListener implements ActionListener {
    
    BarreLaterale bl;
    Fenetre f;
    Noeud papa;

    public BLListener(BarreLaterale bl,Fenetre f) {
        this.bl = bl;
        this.f=f;
        papa = f.arbre.root;
    }

    
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("afficher")){             
            bl.center.setVisible(!bl.but.isSelected());
            f.aire.repaint();
            f.aire.menuOn=false;
        }else if(papa!=null){ //il y a un noeud selectionné
            if(cmd.equals("type1")){
                Noeud fils = new Noeud(papa,"sans_nom",1,0,0);
                // 1: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                f.aire.repaint();
            }else if(cmd.equals("type2")){
                Noeud fils = new Noeud(papa,"sans_nom",2,0,0);
                // 2: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                f.aire.repaint();
            }else if(cmd.equals("type3")){
                Noeud fils = new Noeud(papa,"sans_nom",3,0,0);
                // 3: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                
                f.aire.repaint();
            }else if(cmd.equals("type4")){
                Noeud fils = new Noeud(papa,"sans_nom",4,0,0);
                // 4: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                f.aire.repaint();
            }else if(cmd.equals("supp")){
                f.arbre.supprimerArbre(papa);
                f.aire.repaint();
            }
        }
    }
    
    public void setPapa(Noeud n){
        papa=n;
    }
    
}
