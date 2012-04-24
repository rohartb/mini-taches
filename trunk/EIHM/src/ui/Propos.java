package ui;

import java.awt.BorderLayout;
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
        JLabel team = new JLabel(new ImageIcon("Image/roux.jpg"));
        JLabel texte = new JLabel("Développation par la team Cahuet -- Version 12.4");

        this.add(team,BorderLayout.CENTER);
        this.add(texte,BorderLayout.SOUTH);
        this.setSize(500,410);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
