
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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
    Fenetre f;
    BLListener bl;
    
    public BarreLaterale(Fenetre f){
        
        this.f=f;
        but = new JToggleButton("!");
        but.setPreferredSize(new Dimension(15,this.getHeight()));

        
        center = new JPanel(new BorderLayout());
        right = new JPanel(new BorderLayout());
        right.add(but);
        
        bl = new BLListener(this,f);
        ActionListener ecouteur = bl;
        
        but.setActionCommand("afficher");
        but.addActionListener(ecouteur);
        
        
        JPanel paneSud = new JPanel();
        paneSud.setPreferredSize(new Dimension(this.getWidth()-15,325));
        JPanel margeGauche = new JPanel();
        margeGauche.setPreferredSize(new Dimension(30,this.getHeight()));
        JPanel margeDroite = new JPanel();
        margeDroite.setPreferredSize(new Dimension(30,this.getHeight()));
        JPanel paneNord = new JPanel();
        paneNord.setPreferredSize(new Dimension(this.getWidth()-15, 25));
        
        JPanel tableCentrale = new JPanel();
                
        GridLayout grid=new GridLayout(2,3,30,30);
        
        JButton but1 = new JButton(new ImageIcon("Image/TriangleDroit.png"));
        but1.setPreferredSize(new Dimension(30,30));
        but1.setActionCommand("type1");
        but1.addActionListener(ecouteur);
        
        JButton but2 = new JButton(new ImageIcon("Image/TriangleDroit.png"));
        but2.setPreferredSize(new Dimension(30,30));
        but2.setActionCommand("supp");
        but2.addActionListener(ecouteur);
        
        JButton but3 = new JButton(new ImageIcon("Image/TriangleDroit.png"));
        but3.setPreferredSize(new Dimension(30,30));
        JButton but4 = new JButton(new ImageIcon("Image/TriangleDroit.png"));
        but4.setPreferredSize(new Dimension(30,30));
        JButton but5 = new JButton(new ImageIcon("Image/TriangleDroit.png"));
        but5.setPreferredSize(new Dimension(30,30));
        JButton but6 = new JButton(new ImageIcon("Image/TriangleDroit.png"));
        but6.setPreferredSize(new Dimension(30,30));
        
        tableCentrale.setLayout(grid);
        tableCentrale.add(but1);
        tableCentrale.add(but2);
        tableCentrale.add(but3);
        tableCentrale.add(but4);
        tableCentrale.add(but5);
        tableCentrale.add(but6);
        center.add(tableCentrale, BorderLayout.CENTER);
        center.add(margeGauche, BorderLayout.WEST);
        center.add(margeDroite, BorderLayout.EAST);
        center.add(paneSud, BorderLayout.SOUTH);
        center.add(paneNord, BorderLayout.NORTH);
        
        this.setLayout(new BorderLayout());
        this.add(center, BorderLayout.CENTER);
        this.add(right,BorderLayout.EAST);
        this.setVisible(true);
    }
}
