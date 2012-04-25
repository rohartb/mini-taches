package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Propos extends JDialog{
    Fenetre f;

    public Propos(Fenetre f)  {
        this.f = f;

        this.setTitle("A propos");
        this.setModal(true);
        setLayout(new BorderLayout());

        this.setResizable(false);
        JLabel team = new JLabel(new ImageIcon("Image/team2.jpg"));
        JPanel lala = new JPanel(new BorderLayout());
        
        JLabel texte = new JLabel("Version 12.4");
        texte.setPreferredSize(new Dimension(this.getWidth(),40));
        texte.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel texte2 = new JLabel("Logiciel développé par la TeamCahuet");
        texte2.setPreferredSize(new Dimension(this.getWidth(),40));
        texte2.setHorizontalAlignment(JLabel.CENTER);
        
        lala.add(texte,BorderLayout.CENTER);
        lala.add(texte2,BorderLayout.SOUTH);
        
        this.add(team,BorderLayout.CENTER);
        this.add(lala,BorderLayout.SOUTH);
        this.setSize(500,410);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
