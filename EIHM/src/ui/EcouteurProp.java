
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class EcouteurProp implements ActionListener {
    Propriete p;

    public EcouteurProp(Propriete p) {
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("it")){
            if(p.f.barreLaterale.bl.papa.propriete[0]==0){
                p.f.barreLaterale.bl.papa.propriete[0]=1;
            } else {
                p.f.barreLaterale.bl.papa.propriete[0]=0;
            }
        }
        if(e.getActionCommand().equals("op")){
            if(p.f.barreLaterale.bl.papa.propriete[1]==0){
                p.f.barreLaterale.bl.papa.propriete[1]=1;
            } else {
                p.f.barreLaterale.bl.papa.propriete[1]=0;
            }
        }
        p.f.barreLaterale.majBouton(p.f.barreLaterale.bl.papa);
        p.f.aire.repaint();
    }
}
