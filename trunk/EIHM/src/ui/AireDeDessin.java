
package ui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AireDeDessin extends JComponent {
    int height;
    int width;
    int x;
    int y = 50;
    int xAncien=0, yAncien=0;
    Noeud noeud;
    int nb;
    Fenetre f;
    java.util.List<ElementMenu> dest = new ArrayList<ElementMenu>();
    Boolean menuOn = false;
    
    public AireDeDessin(Fenetre f) {
        this.f = f;
        noeud = f.arbre.root;
        //this.setBorder(BorderFactory.createLineBorder(Color.pink));
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D draw = (Graphics2D) g;
        
        x = this.getWidth()/2;
        nb = this.getWidth();
        height = this.getHeight();
        width = this.getWidth();
        draw.setColor(Color.WHITE);
        draw.fillRect(0, 0,(int)width,(int)height);
        draw.setPaint(Color.black);
        
        dessinerArbre(draw, noeud, 0, this.getWidth());
        y=50;
        
        
    }
    
    private void dessinerArbre(Graphics2D draw, Noeud n, int wTreeD, int wTreeF) {
        Iterator it;
        
        int width = wTreeF-wTreeD;
        x=wTreeD + width/2;
        int yLien;
        int xLien=x;
        n.panel.setBounds(x-20, y, 40, 40);
        draw.drawString(n.nom, x-20, y+50);
        n.setX(x-20);
        n.setY(y);
            
        this.add(n.panel);
        it = n.fils.iterator();
        
        
        nb=width/(n.getNbFils()+1);
        
        int a=0;
        while(it.hasNext()){
            yLien=y+40;
            y+=70;
            x=nb*(a+1);
            int taille=width/n.getNbFils();
            int xSuivant =  (wTreeD+taille*a)+((wTreeD+taille*(a+1)-(wTreeD+taille*a)))/2;
            draw.drawLine(xLien, yLien+10, xSuivant, y);
            
            dessinerArbre(draw,(Noeud)it.next(),wTreeD+taille*a,wTreeD+taille*(a+1));
            a++;
        }
        y-=70;
    }
    
    public void deplacer(int x, int y, Noeud n, JPanel p){
        int diffX=x-xAncien;
        int diffY=y-yAncien;
        
        n.setX(n.getX()-diffX);
        n.setY(n.getY()+diffY);
        p.setBounds(n.getX(), n.getY(), 40, 40);
        repaint();
    }
    
    public void destroyBulles(){
        for(int i=0; i<dest.size(); i++){
            Component c=f.aire.getComponentAt(dest.get(i).getX(), dest.get(i).getY());
            f.aire.remove(c);
        }
    }
}
