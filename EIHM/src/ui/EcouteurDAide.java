package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class EcouteurDAide implements ActionListener,WindowListener {

    private Aide a;
    private int nb;
    private Fenetre f;

    public EcouteurDAide(Fenetre f, Aide a, int nb) {
        this.a = a;
        this.nb = nb;
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("quitter")) {
            traiterQuitter();
        } else if (cmd.equals("precedent")) {
            traiterPrecedent();
        } else if (cmd.equals("suivant")) {
            traiterSuivant();
        }
    }

    public void traiterQuitter() {
        a.setVisible(false);
        nb = 1;
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
                //as.lesAstuces.setText("Gagner une partie");
                break;
            case 7:
                nb--;
                a.lesAides.setIcon(a.i[5]);
                //as.lesAstuces.setText("Modifier jeu");
                break;
            case 8:
                nb--;
                a.lesAides.setIcon(a.i[6]);
                a.suivant.setEnabled(true);
        }
    }

    public void traiterSuivant() {
        a.precedent.setEnabled(true);
        switch (nb) {
            case 1:
                nb++;
                a.lesAides.setIcon(a.i[1]);
                //as.lesAstuces.setText("Jeu Avalam");
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
                nb++;
                a.lesAides.setIcon(a.i[5]);
                //as.lesAstuces.setText("Modifier jeu");
                break;
            case 6:
                //as.suivant.setEnabled(false);
                nb++;
                a.lesAides.setIcon(a.i[6]);
                //as.lesAstuces.setText("Fin");
                break;
            case 7:
                a.suivant.setEnabled(false);
                nb++;
                a.lesAides.setIcon(a.i[7]);
        }

    }

    public void windowClosing(WindowEvent e) {
        a.setVisible(false);
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowGainedFocus(WindowEvent e) {
    }

    public void windowLostFocus(WindowEvent e) {
    }

    public void windowStateChanged(WindowEvent e) {
    }
}
