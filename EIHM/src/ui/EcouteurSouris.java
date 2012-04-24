/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

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
        
        if (me.getButton() == 1){
            f.aire.destroyBulles();
            f.aire.repaint();
            f.aire.menuOn=false;
        }
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
