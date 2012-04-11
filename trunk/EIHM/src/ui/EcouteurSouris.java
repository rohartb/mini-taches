/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bastien
 */
class EcouteurSouris implements MouseListener {
    Fenetre f;
    int taille = 50;
    int rayon = 75;
    List<ElementMenu> items = new ArrayList<ElementMenu>();

    public EcouteurSouris(Fenetre aThis) {
        f=aThis;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton() == 3){
            build(me.getX(), me.getY());
            f.aire.repaint();
        }else if (me.getButton() == 1){
            f.aire.removeAll();
            f.aire.updateUI();
            f.aire.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    private void build(int xCentre, int yCentre){
        if(items.size() == 0){
        items.add(new ElementMenu("Menu1", new Color(244, 70, 97), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("Menu2", new Color(40, 40, 40), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("Menu3", new Color(245, 124, 3), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("Menu4", new Color(90, 37, 180), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("Menu5", new Color(194, 186, 18), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("Menu6", new Color(15, 88, 149), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("Menu7", new Color(84, 170, 47), new Color(162, 198, 232), 100));
        }
        if(items!=null && items.size()>0){
            f.setLayout(null);
            double angle=2*Math.PI/(items.size());
            for(int i=0; i<items.size(); i++){
                ElementMenu bulle = new ElementMenu(items.get(i).getNom(), items.get(i).getCouleurNormal(), items.get(i).getCouleurActif(), taille);
                bulle.setBounds((int)(xCentre-taille/2+rayon*Math.cos(i*angle)), (int)(yCentre-taille/2+rayon*Math.sin(i*angle)), taille+10, taille+10);
                f.aire.add(bulle);
            }
        }
    }

    
}
