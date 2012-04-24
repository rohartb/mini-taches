package ui;

import java.awt.event.MouseListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class EcouteurNoeud implements MouseListener,MouseMotionListener {
    Fenetre f;
    int taille = 40;
    int rayon = 50;
    java.util.List<ElementMenu> items = new ArrayList<ElementMenu>();
    Noeud noeud;
    JPanel pane;
    
    public EcouteurNoeud(Fenetre aThis, Noeud n) {
        f=aThis;
        noeud = n;
        pane = noeud.panel;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
            f.aire.destroyBulles();
            f.aire.repaint();
            f.aire.menuOn=false;
        f.barreLaterale.bl.setPapa(noeud);
        if(e.getButton() == 3 && f.aire.menuOn==false){
            build(noeud.x+20, noeud.y+20);
            f.aire.repaint();
            f.aire.menuOn=true;
        }else if (e.getButton() == 1){
            f.aire.destroyBulles();
            f.aire.repaint();
            f.aire.menuOn=false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //f.aire.drag=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //f.aire.drag = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    

    @Override
    public void mouseDragged(MouseEvent me) {
            f.aire.deplacer(me.getX(), me.getY(), noeud, pane);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    
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
                f.aire.dest.add(bulle);
                f.aire.add(bulle);
            }
        }
    }
    
}
