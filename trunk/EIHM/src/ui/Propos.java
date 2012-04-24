package ui;

import javax.swing.JDialog;
import javax.swing.JLabel;

class Propos extends JDialog{
    Fenetre f;

    public Propos(Fenetre f)  {
        this.f = f;

        this.setTitle("A propos");
        this.setModal(true);

        this.setResizable(false);

        JLabel texte = new JLabel("Team Cahuet");

        this.add(texte);
        this.setSize(500,410);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
