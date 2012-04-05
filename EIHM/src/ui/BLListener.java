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

    public BLListener(BarreLaterale bl) {
        this.bl = bl;
    }

    
    public void actionPerformed(ActionEvent e) {
        bl.center.setVisible(!bl.but.isSelected());
    }
    
}
