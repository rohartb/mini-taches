
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
    int i=1;
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
        
        dessinerArbre(draw, noeud);
        
        
    }

    private void dessinerArbre(Graphics2D draw, Noeud n) {
        Iterator it;
        draw.drawRect(x-20, y, 40, 40);
        it = n.fils.iterator();
        
        if(n.getNbFils()!=0){
            y+=70;
            if (n.getNbFils()>1)
                nb=nb/(n.getNbFils()+1);
        }
        while (it.hasNext()){
            
            x=nb*i;
            draw.drawRect(x-20, y, 40, 40);
            i++;
            it.next();
        }
        i=1;
        x=nb;
        it = n.fils.iterator();
        while (it.hasNext()){
            dessinerArbre(draw, (Noeud)it.next());
        }
    }
}
