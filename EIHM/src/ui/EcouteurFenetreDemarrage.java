package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EcouteurFenetreDemarrage implements ActionListener {
    
    FenetreDemarrage fd;
    Fenetre f;

    public EcouteurFenetreDemarrage(FenetreDemarrage aThis, Fenetre f) {
        this.fd = aThis;
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ouvrir")){
            this.fd.setVisible(false);
            f.changementEtat("ouvrir");
        }

        if(e.getActionCommand().equals("aide")){
            this.fd.setVisible(false);
            f.changementEtat("aide");
        }
        
        if(e.getActionCommand().equals("astuce")){
            this.fd.setVisible(false);
            f.changementEtat("astuce");
        }
    }
    
}
