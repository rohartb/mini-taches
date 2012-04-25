
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
    int hauteur=0;
    Noeud noeud;
    int nb;
    Fenetre f;
    java.util.List<ElementMenu> dest = new ArrayList<ElementMenu>();
    private int[] fait=new int[50];
    Boolean menuOn = false;
    Boolean zoom = false;
    
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
      
        f.arbre.calculHauteur();
        dessinerArbre(draw, noeud);
        reinitFait();
        dessinerLien(draw, noeud);
        y=etage;   
    }
    
    private void dessinerArbre(Graphics2D draw, Noeud n) {
        Iterator it;
        
        x=this.getWidth()/(f.arbre.hauteur[hauteur]+1);
        fait[hauteur]++;
        int yInter = y;
        x=x*fait[hauteur];
        if(n.deplace){
            x=n.getX();
            y=n.getY();
        }

        n.panel.setBounds(x-(taille/2), y, taille, taille);

        String lala = n.nom;
        if(n.propriete[1]==1){
            lala = "["+lala +"]";
        }
        if (n.propriete[0] == 1) {
            lala =  lala + "*";
        }
        draw.drawString(lala, x-(taille/2), y+taille+15);

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
        while(it.hasNext()){
            y+=etage;
            hauteur++;
            dessinerArbre(draw,(Noeud)it.next());
        }
        hauteur--;
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
    
    public void reinitFait(){
        for(int i=0; i<fait.length; i++){
            fait[i]=0;
        }
        hauteur=0;
    }
    
    public void afficher(){
            System.out.println("hauteur 0: "+f.arbre.hauteur[0]);
            System.out.println("hauteur 1: "+f.arbre.hauteur[1]);
    }
}
