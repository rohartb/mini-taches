/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author bastien
 */
class BLListener implements ActionListener {
    
    BarreLaterale bl;
    Fenetre f;
    Noeud papa;

    public BLListener(BarreLaterale bl,Fenetre f) {
        this.bl = bl;
        this.f=f;
        papa = f.arbre.root;
    }

    
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("afficher")){             
            bl.center.setVisible(!bl.but.isSelected());  
        }else if(papa!=null){ //il y a un noeud selectionné
            
            
            if(cmd.equals("user")){
                Noeud fils = new Noeud(papa,"sans_nom",1,0);
                // 1: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils, f);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                fils.panel.add(new JLabel(new ImageIcon("Image/user.png")));
            }else if(cmd.equals("abstract")){
                Noeud fils = new Noeud(papa,"sans_nom",2,0);
                // 2: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils,f);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                fils.panel.add(new JLabel(new ImageIcon("Image/abstract.png")));
            }else if(cmd.equals("application")){
                Noeud fils = new Noeud(papa,"sans_nom",3,0);
                // 3: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils,f);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                fils.panel.add(new JLabel(new ImageIcon("Image/application.png")));
            }else if(cmd.equals("interaction")){
                Noeud fils = new Noeud(papa,"sans_nom",4,0);
                // 4: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils,f);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                fils.panel.add(new JLabel(new ImageIcon("Image/interaction.png")));

            }else if(cmd.equals("prop1")){
                if(papa.propriete[0]==0){
                    bl.but13.setSelected(true);
                    papa.propriete[0]=1;
                } else {
                    bl.but13.setSelected(false);
                    papa.propriete[0]=0;
                }

            }else if(cmd.equals("prop2")){
                if(papa.propriete[1]==0){
                    bl.but14.setSelected(true);
                    papa.propriete[1]=1;
                } else {
                    bl.but14.setSelected(false);
                    papa.propriete[1]=0;
                }

            }else if(cmd.equals("prop3")){
                if(papa.propriete[2]==0){
                    bl.but15.setSelected(true);
                    papa.propriete[2]=1;
                } else {
                    bl.but15.setSelected(false);
                    papa.propriete[2]=0;
                }
            }
        }
        f.aire.repaint();
    }
    
    public void setPapa(Noeud n){
        papa=n;
    }
    
}
