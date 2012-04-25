
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
    int y;
    int xAncien=0, yAncien=0;
    int taille=40;
    int etage=70;
    Noeud noeud;
    int nb;
    Fenetre f;
    java.util.List<ElementMenu> dest = new ArrayList<ElementMenu>();
    Boolean menuOn = false;
    
    public AireDeDessin(Fenetre f) {
        this.f = f;
        noeud = f.arbre.root;
        y=etage;
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
        dessinerLien(draw, noeud);
        y=etage;
        
    }
    
    private void dessinerArbre(Graphics2D draw, Noeud n, int wTreeD, int wTreeF) {
        Iterator it;
        
        int width = wTreeF-wTreeD;
        x=wTreeD + width/2;
        int yInter = y;
        if(n.deplace){
            x=n.getX();
            y=n.getY();
        }

        n.panel.setBounds(x-(taille/2), y, taille, taille);
        draw.drawString(n.nom, x-(taille/2), y+taille+15);
        n.setX(x);
        n.setY(y);
        y=yInter;
        
        if(n.select==true){
            draw.setColor(Color.red);
            draw.drawRect(x-(taille/2)-1, y-1, taille+1, taille+1);
            draw.setColor(Color.black);
        }
        
        this.add(n.panel);
        it = n.fils.iterator();
        nb=width/(n.getNbFils()+1);
        int a=0;
        while(it.hasNext()){
            y+=etage;
            x=nb*(a+1);
            int t=width/n.getNbFils();
            dessinerArbre(draw,(Noeud)it.next(),wTreeD+t*a,wTreeD+t*(a+1));
            a++;
        }
        y-=etage;
    }
    
    public void dessinerLien(Graphics2D draw, Noeud n){
        Iterator it = n.fils.iterator();
        int xDep = n.getX();
        int yDep = n.getY()+taille+15;
        while(it.hasNext()){
            Noeud noeud = (Noeud) it.next();
            int xArr = noeud.getX();
            int yArr = noeud.getY();
            draw.drawLine(xDep, yDep, xArr, yArr);
        }
        Iterator it2 = n.fils.iterator();
        
        while(it2.hasNext()){
            dessinerLien(draw,(Noeud) it2.next());
        }
    }
    
    public void deplacer(int x, int y, Noeud n, JPanel p){
        int diffX=x-xAncien;
        int diffY=y-yAncien;
        
        n.setX(n.getX()+diffX);
        n.setY(n.getY()+diffY);
        n.deplace=true;
        repaint();
    }
    
    public void destroyBulles(){
        for(int i=0; i<dest.size(); i++){
            Component c=f.aire.getComponentAt(dest.get(i).getX(), dest.get(i).getY());
            f.aire.remove(c);
        }
    }
    
    public void removePanel(Noeud n){
        Iterator it = n.fils.iterator();
        this.remove(n.panel);
        
        while(it.hasNext()){
            removePanel((Noeud) it.next());
        }
    }
}
