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

    public BLListener(BarreLaterale bl,Fenetre f) {
        this.bl = bl;
        this.f=f;
    }

    
    public void actionPerformed(ActionEvent e) {
        bl.center.setVisible(!bl.but.isSelected());
        f.aire.removeAll();
        f.aire.updateUI();
        f.aire.repaint();
        f.menuOn=false;
    }
    
}
