/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sophie
 */
public class EcouteurOption implements ActionListener {
    Fenetre f;

    public EcouteurOption(Fenetre f) {
        this.f = f;
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
                f.e.couper(f.barreLaterale.bl.papa);
                f.barreInfo.setInfo("couper");
            }
        }
        else if(ae.getActionCommand().equals("copb")){
            if(f.barreLaterale.bl.papa!=null){
                f.e.copier(f.barreLaterale.bl.papa);
                f.barreInfo.setInfo("copier");          
            }
        }
        else if(ae.getActionCommand().equals("collb")){
                f.e.coller();
                f.barreInfo.setInfo("coller");
        }
        else if(ae.getActionCommand().equals("ob")){
            f.changementEtat("ouvrir");
        }
        
        else if(ae.getActionCommand().equals("suppb")){
            f.changementEtat("supprimer");
        }
        
        else if(ae.getActionCommand().equals("annuler")){
            f.e.annuler();
        }
        
        else if(ae.getActionCommand().equals("retablir")){
            f.e.retablir();
        }
        
        else if(ae.getActionCommand().equals("augn")){
            int y;
            for (int i=0; i<f.arbre.root.getNbFils();i++){
                y = f.arbre.root.fils.get(i).getY() + 10;
                f.arbre.root.fils.get(i).setY(y);                
            }          
        }
        
        else if(ae.getActionCommand().equals("dimn")){
            int y;
            for (int i=0; i<f.arbre.root.getNbFils();i++){
                y = f.arbre.root.fils.get(i).getY() - 10;
                f.arbre.root.fils.get(i).setY(y);                
            } 
        }
        
    }
}
