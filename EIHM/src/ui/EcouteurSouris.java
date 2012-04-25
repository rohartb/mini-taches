/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author bastien
 */
class EcouteurSouris implements MouseListener{
    Fenetre f;

    public EcouteurSouris(Fenetre f) {
        this.f=f;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        f.arbre.deselect(f.arbre.root);
        f.menubar.coller.setEnabled(false);
        f.menubar.copier.setEnabled(false);
        f.menubar.couper.setEnabled(false);
        f.barre.barreOutil.coller.setEnabled(false);
        f.barre.barreOutil.copier.setEnabled(false);
        f.barre.barreOutil.couper.setEnabled(false);
        f.barre.barreOutil.supprimer.setEnabled(false);
        f.barre.barrePropriete.nomTache.setEditable(false);
        f.barre.barrePropriete.listeCategorie.setEnabled(false);
        
        
        f.barreInfo.setInfo("rien");
        f.barreLaterale.bloquer();
        f.aire.destroyBulles();
        f.barreLaterale.bl.setPapa(null);      
        f.aire.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
