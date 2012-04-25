package ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class EcouteurFenetreIcone implements WindowListener {
    
    FenetreDemarrage fd;
    Fenetre f;

    public EcouteurFenetreIcone(Fenetre aThis, FenetreDemarrage fd) {
        this.f = f;
        this.fd = fd;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //fd.setVisible(false);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //fd.setVisible(true);
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
