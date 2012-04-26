package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class EcouteurDAide implements ActionListener {

    private Aide a;
    static int nb;
    private Fenetre f;



    public EcouteurDAide(Fenetre f, Aide a) {
        this.a = a;
        this.nb = 1;
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("quitter")) {
            f.barreInfo.setInfo("rien");
            traiterQuitter();
        } else if (cmd.equals("precedent")) {
            traiterPrecedent();
        } else if (cmd.equals("suivant")) {
            traiterSuivant();
        }
    }

    public void traiterQuitter() {
        a.setVisible(false);
        this.nb = 1;
    }

    public void traiterPrecedent() {
        switch (nb) {
            case 2:
                nb--;
                //as.lesAstuces.setText("Bienvenue");
                a.lesAides.setIcon(a.i[0]);
                a.precedent.setEnabled(false);
                break;
            case 3:
                nb--;
                a.lesAides.setIcon(a.i[1]);
                //as.lesAstuces.setText("Jeu Avalam");
                break;
            case 4:
                nb--;
                a.lesAides.setIcon(a.i[2]);
                //as.lesAstuces.setText("Comment jouer");
                break;
            case 5:
                nb--;
                a.lesAides.setIcon(a.i[3]);
                //as.lesAstuces.setText("Faire des tours");
                break;
            case 6:
                nb--;
                a.lesAides.setIcon(a.i[4]);
                a.suivant.setEnabled(true);
                break;
                
        }
    }

    public void traiterSuivant() {
        a.precedent.setEnabled(true);
        switch (nb) {
            case 1:
                nb++;
                a.lesAides.setIcon(a.i[1]);
                break;
            case 2:
                a.lesAides.setIcon(a.i[2]);
                nb++;
                //as.lesAstuces.setText("Comment jouer");
                break;
            case 3:
                nb++;
                a.lesAides.setIcon(a.i[3]);
                //as.lesAstuces.setText("Faire des tours");
                break;
            case 4:
                nb++;
                a.lesAides.setIcon(a.i[4]);
                //as.lesAstuces.setText("Gagner une partie");
                break;
            case 5:
                a.suivant.setEnabled(false);
                nb++;
                a.lesAides.setIcon(a.i[5]);
                break;      
        }

    }
   
}
