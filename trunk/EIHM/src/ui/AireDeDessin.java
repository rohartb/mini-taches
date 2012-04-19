
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class AireDeDessin extends JComponent {
    int height;
    int width;
    int x;
    int y = 50;
    Noeud noeud;
    int nb;
    Fenetre f;

    public AireDeDessin(Fenetre f) {
        this.f = f;
        noeud = f.arbre.root;
        this.setBorder(BorderFactory.createLineBorder(Color.pink));
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D draw = (Graphics2D) g;
        
        x = this.getWidth()/2;
        nb = this.getWidth();
        height = this.getHeight();
        width = this.getWidth();
        draw.setColor(Color.pink);
        draw.fillRect(0, 0,(int)width,(int)height);
        draw.setPaint(Color.black);
        
        dessinerArbre(draw, noeud, 0, this.getWidth());
        y=50;
        
        
    }
    
    private void dessinerArbre(Graphics2D draw, Noeud n, int wTreeD, int wTreeF) {
        Iterator it;
        int width = wTreeF-wTreeD;
        x=wTreeD + width/2;
        draw.drawRect(x-20, y, 40, 40);
        it = n.fils.iterator();
        
        
        nb=width/(n.getNbFils()+1);
        
        int a=0;
        while(it.hasNext()){
            y+=70;
            x=nb*(a+1);
            int taille=width/n.getNbFils();
            dessinerArbre(draw,(Noeud)it.next(),wTreeD+taille*a,wTreeD+taille*(a+1));
            a++;
        }
        y-=70;
    }
}
