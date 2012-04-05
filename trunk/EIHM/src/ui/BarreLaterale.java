
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author bastien
 */
class BarreLaterale extends JPanel{
    
    JToggleButton but;
    JPanel center;
    JPanel right;
    public BarreLaterale(){
        
        but = new JToggleButton("!");
        
        center = new JPanel(new BorderLayout());
        center.setVisible(true);
        center.add(new JLabel("lalalala"));
        center.setPreferredSize(new Dimension(115,0));
        right = new JPanel(new BorderLayout());
        right.setVisible(true);
        right.add(but);
        right.setPreferredSize(new Dimension(15, 0));
        
        ActionListener ecouteur = new BLListener(this);
        
        but.addActionListener(ecouteur);
        
        this.setLayout(new BorderLayout());
        this.add(center, BorderLayout.CENTER);
        this.add(right,BorderLayout.EAST);
        this.setVisible(true);
    }
}
