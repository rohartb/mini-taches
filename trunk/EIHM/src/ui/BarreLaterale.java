
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author bastien
 */
class BarreLaterale extends JPanel{
    
    JButton but = new JButton(new ImageIcon("Image/TriangleDroit.png"));
    
    public BarreLaterale(){
        ActionListener ecouteur = new BLListener(this);
        but.addActionListener(ecouteur);
        this.setLayout(new BorderLayout());
        this.add(but, BorderLayout.EAST);
        this.setVisible(true);
    }
}
