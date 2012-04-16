package ui;

import java.awt.event.MouseListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EcouteurNoeud implements MouseListener {
    Fenetre f;
    int taille = 50;
    int rayon = 75;
    java.util.List<ElementMenu> items = new ArrayList<ElementMenu>();
    Boolean menuOn = false;
    
    public EcouteurNoeud(Fenetre aThis) {
        f=aThis;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 3 && menuOn==false){
            build(e.getX(), e.getY());
            f.aire.repaint();
            menuOn=true;
        }else if (e.getButton() == 1){
            f.aire.removeAll();
            f.aire.updateUI();
            f.aire.repaint();
            menuOn=false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    private void build(int xCentre, int yCentre){
        if(items.size() == 0){
        items.add(new ElementMenu("Ça", new Color(244, 70, 97), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("marche", new Color(40, 40, 40), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("pas", new Color(245, 124, 3), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("cette", new Color(90, 37, 180), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("merde", new Color(194, 186, 18), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("bordel", new Color(15, 88, 149), new Color(162, 198, 232), 100));
        items.add(new ElementMenu("!!", new Color(84, 170, 47), new Color(162, 198, 232), 100));
        }
        if(items!=null && items.size()>0){
            double angle=2*Math.PI/(items.size());
            for(int i=0; i<items.size(); i++){
                ElementMenu bulle = new ElementMenu(items.get(i).getNom(), items.get(i).getCouleurNormal(), items.get(i).getCouleurActif(), taille);
                bulle.setBounds((int)(xCentre-taille/2+rayon*Math.cos(i*angle)), (int)(yCentre-taille/2+rayon*Math.sin(i*angle)), taille+10, taille+10);
                f.aire.add(bulle);
            }
        }
    }
    
}
