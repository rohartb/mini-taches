
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
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
        
        //Panneau des types de tache
        JPanel paneauHaut = new JPanel(new BorderLayout());
        
        //Label du haut
        JLabel nomPane = new JLabel(" Type de Taches :");
        nomPane.setPreferredSize(new Dimension(this.getWidth(),40));
        
        //Panel Global
        paneauHaut.add(nomPane);
        paneauHaut.setBackground(new Color(153,204,255));

        //Panel du bas
        JPanel paneSud = new JPanel();
        paneSud.setBackground(new Color(153,204,255));
        
        JButton but1 = new JButton(new ImageIcon("Image/user.png"));
        but1.setPreferredSize(new Dimension(50,50));
        but1.setActionCommand("user");
        but1.addActionListener(ecouteur);  
        but1.setBackground(Color.white);
        but1.setToolTipText("Utilisateur");
        
        JButton but2 = new JButton(new ImageIcon("Image/abstract.png"));
        but2.setPreferredSize(new Dimension(50,50));
        but2.setActionCommand("abstract");
        but2.addActionListener(ecouteur);
        but2.setBackground(Color.white);
        but2.setToolTipText("Abstraction");
        
        JButton but3 = new JButton(new ImageIcon("Image/application.png"));
        but3.setPreferredSize(new Dimension(50,50));
        but3.setActionCommand("application");
        but3.addActionListener(ecouteur);
        but3.setBackground(Color.white);
        but3.setToolTipText("Application");
        
        JButton but4 = new JButton(new ImageIcon("Image/interaction.png"));
        but4.setPreferredSize(new Dimension(50,50));
        but4.setActionCommand("interaction");
        but4.addActionListener(ecouteur);
        but4.setBackground(Color.white); 
        but4.setToolTipText("Interaction");

        paneSud.add(but1);
        paneSud.add(but2);
        paneSud.add(but3);
        paneSud.add(but4);
        
        paneauHaut.add(nomPane,BorderLayout.CENTER);
        paneauHaut.add(paneSud,BorderLayout.SOUTH);
        
        
        //Panneau des Liaisons
        JPanel paneMilieu = new JPanel(new BorderLayout());
        paneMilieu.setBackground(new Color(102 ,153 ,204));
        
        JLabel l1 = new JLabel(" Haute Priorité ");
        l1.setPreferredSize(new Dimension(this.getWidth(),40));
        
        paneMilieu.add(l1,BorderLayout.NORTH);
        
        JPanel lala = new JPanel(new BorderLayout());
        lala.setPreferredSize(new Dimension(this.getWidth(),150));
        
        JPanel paneSudMileu1 = new JPanel();
        paneSudMileu1.setBackground(new Color(102 ,153 ,204));
        
        JPanel paneSudMileu2 = new JPanel();
        paneSudMileu2.setBackground(new Color(102 ,153 ,204));
                
        JButton but5 = new JButton(new ImageIcon("Image/priorite1.png"));
        but5.setPreferredSize(new Dimension(50,50));
        but5.setActionCommand("priorite1");
        but5.addActionListener(ecouteur);
        but5.setBackground(Color.white);
        
        JButton but6 = new JButton(new ImageIcon("Image/priorite2.png"));
        but6.setPreferredSize(new Dimension(50,50));
        but6.setActionCommand("priorite2");
        but6.addActionListener(ecouteur);
        but6.setBackground(Color.white);
        
        JButton but7 = new JButton(new ImageIcon("Image/priorite3.png"));
        but7.setPreferredSize(new Dimension(50,50));
        but7.setActionCommand("priorite3");
        but7.addActionListener(ecouteur);
        but7.setBackground(Color.white);
        
        JButton but8 = new JButton(new ImageIcon("Image/priorite4.png"));
        but8.setPreferredSize(new Dimension(50,50));
        but8.setActionCommand("priorite4");
        but8.addActionListener(ecouteur);
        but8.setBackground(Color.white);
        
        JButton but9 = new JButton(new ImageIcon("Image/priorite5.png"));
        but9.setPreferredSize(new Dimension(50,50));
        but9.setActionCommand("priorite5");
        but9.addActionListener(ecouteur);
        but9.setBackground(Color.white);
        
        JButton but10 = new JButton(new ImageIcon("Image/priorite6.png"));
        but10.setPreferredSize(new Dimension(50,50));
        but10.setActionCommand("priorite6");
        but10.addActionListener(ecouteur);
        but10.setBackground(Color.white);
        
        JButton but11 = new JButton(new ImageIcon("Image/priorite7.png"));
        but11.setPreferredSize(new Dimension(50,50));
        but11.setActionCommand("priorite7");
        but11.addActionListener(ecouteur);
        but11.setBackground(Color.white);
        
        JButton but12 = new JButton(new ImageIcon("Image/priorite8.png"));
        but12.setPreferredSize(new Dimension(50,50));
        but12.setActionCommand("priorite8");
        but12.addActionListener(ecouteur);
        but12.setBackground(Color.white);
        
        paneSudMileu1.add(but5);
        paneSudMileu1.add(but6);
        paneSudMileu1.add(but7);
        paneSudMileu1.add(but8);
        
        paneSudMileu2.add(but9);
        paneSudMileu2.add(but10);
        paneSudMileu2.add(but11);
        paneSudMileu2.add(but12);
        
        lala.add(paneSudMileu1,BorderLayout.NORTH);
        lala.add(paneSudMileu2,BorderLayout.CENTER);
        
        JLabel l2 = new JLabel(" Basse Priorité ");
        l2.setPreferredSize(new Dimension(this.getWidth(),40));
        
        paneMilieu.add(lala,BorderLayout.CENTER);
        paneMilieu.add(l2,BorderLayout.SOUTH);
        
        //Panel du bas
        
        JPanel paneauSud = new JPanel();
        paneauSud.setPreferredSize(new Dimension(this.getWidth(),620));
        paneauSud.setBackground(new Color(102 ,153 ,204));
        
        
        center.add(paneauHaut, BorderLayout.NORTH);
        center.add(paneMilieu, BorderLayout.CENTER);
        center.add(paneauSud, BorderLayout.SOUTH);
        
        this.setLayout(new BorderLayout());
        this.add(center, BorderLayout.CENTER);
        this.add(right,BorderLayout.EAST);
        this.setVisible(true);
    }
}
