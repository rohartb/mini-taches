
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
//                Noeud n = f.e.copieArbre(f.arbre.root);                       
//                f.h.ajouterAnnuler(n);
//                f.h.viderRetablir();
                
                Noeud fils = new Noeud(papa,"Tâche_"+f.nbTache,1,0);
                if(f.barreLaterale.bl.papa!=null){
                    f.nbTache++;
                }
                // 1: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils, f);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                //fils.panel.add(new JLabel(new ImageIcon("Image/user.png")));
                fils.panel.add(fils.ajouterImage(1));
            }else if(cmd.equals("abstract")){             
//                Noeud n = f.e.copieArbre(f.arbre.root);                       
//                f.h.ajouterAnnuler(n);
//                f.h.viderRetablir();
                Noeud fils = new Noeud(papa,"Tâche_"+f.nbTache,2,0);
                if(f.barreLaterale.bl.papa!=null){
                    f.nbTache++;
                }
                // 2: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils,f);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                //fils.panel.add(new JLabel(new ImageIcon("Image/abstract.png")));
                fils.panel.add(fils.ajouterImage(2));
            }else if(cmd.equals("application")){             
//                Noeud n = f.e.copieArbre(f.arbre.root);                       
//                f.h.ajouterAnnuler(n);
//                f.h.viderRetablir();
                Noeud fils = new Noeud(papa,"Tâche_"+f.nbTache,3,0);
                if(f.barreLaterale.bl.papa!=null){
                    f.nbTache++;
                }
                // 3: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils,f);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                //fils.panel.add(new JLabel(new ImageIcon("Image/application.png")));
                fils.panel.add(fils.ajouterImage(3));
            }else if(cmd.equals("interaction")){             
//                Noeud n = f.e.copieArbre(f.arbre.root);                       
//                f.h.ajouterAnnuler(n);
//                f.h.viderRetablir();           
                Noeud fils = new Noeud(papa,"Tâche_"+f.nbTache,4,0);
                if(f.barreLaterale.bl.papa!=null){
                    f.nbTache++;
                }
                // 4: type, 0: pas de liaison, 0: pas de propriete
                papa.ajouterFils(fils,f);
                EcouteurNoeud souris = new EcouteurNoeud(f, fils);
                fils.panel.addMouseListener(souris);
                fils.panel.addMouseMotionListener(souris);
                //fils.panel.add(new JLabel(new ImageIcon("Image/interaction.png")));
                fils.panel.add(fils.ajouterImage(4));
            }else if(cmd.equals("prop1")){
                if(papa.propriete[0]==0){             
//                    Noeud n = f.e.copieArbre(f.arbre.root);                       
//                    f.h.ajouterAnnuler(n);
//                    f.h.viderRetablir();           
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
            }else if(papa.getPapa()!=null){
                if(cmd.equals("priorite1")){
                    papa.liaison=1;
                }else if(cmd.equals("priorite2")){
                    papa.liaison=2;
                }else if(cmd.equals("priorite3")){
                    papa.liaison=3;
                }else if(cmd.equals("priorite4")){
                    papa.liaison=4;
                }else if(cmd.equals("priorite5")){
                    papa.liaison=5;
                }else if(cmd.equals("priorite6")){
                    papa.liaison=6;
                }else if(cmd.equals("priorite7")){
                    papa.liaison=7;
                }else if(cmd.equals("priorite8")){
                    papa.liaison=8;
                }
            }
        }
        f.aire.repaint();
    }
    
    public void setPapa(Noeud n){
        papa=n;
    }
    
}
