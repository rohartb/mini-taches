
package ui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

public class AireDeDessin extends JComponent {
    int height;
    int width;
    int x;
    int y;
    int xAncien=0, yAncien=0;
    int taille=40;
    int etage=70;
    int hauteur=0;
    int coeff=0;
    Noeud noeud;
    int xLiaison=0;
    int yLiaison=0;
    ArrayList<Noeud> liaisons;
    ArrayList<Point> points;
    Fenetre f;
    java.util.List<ElementMenu> dest = new ArrayList<ElementMenu>();
    private int[] fait=new int[50];
    Boolean menuOn = false;
    Boolean zoom = false;
    ArrayList<JLabel> label = new ArrayList<JLabel>();
    
    
    public AireDeDessin(Fenetre f) {
        this.f = f;
        noeud = f.arbre.root;
        y=etage;
        //this.setBorder(BorderFactory.createLineBorder(Color.pink));
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D draw = (Graphics2D) g;
        
        coeff=coeff/100;
        taille+=taille*coeff;
        y+=y*coeff;
        etage+=etage*coeff;
        
        height = this.getHeight();
        width = this.getWidth();
        draw.setColor(Color.WHITE);
        draw.fillRect(0, 0,(int)width,(int)height);
        draw.setPaint(Color.black);
        
        removeLabel();
        liaisons = new ArrayList<Noeud>();
        points = new ArrayList<Point>();
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
        x-=(coeff*x)/2;
        if(n.deplace){
            if(n.getX()<0){
                x=taille/2;
            }else if(n.getX()>this.getWidth()-(taille/2)){
                x=this.getWidth()-(taille/2);
            }else{
                x=n.getX();
            }
            if(n.getY()<0){
                y=0;
            }else if(n.getY()>this.getHeight()-(taille/2)){
                y=this.getHeight()-taille;
            }else{
                y=n.getY();
            }
            
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
            draw.drawRect(n.getX()-(taille/2)-1, n.getY()-1, taille+1, taille+1);
            draw.setColor(Color.black);
        }
        
        
        boolean trouve = false;
        Iterator li = liaisons.iterator();
        Iterator p = points.iterator();
        while(li.hasNext() && !trouve){
            Noeud test = (Noeud) li.next();
            Point po = (Point) p.next();
            if(test.hauteur==hauteur){
                Liaison(draw, (int)po.getX(), (int)po.getY(), n.getX(), n.getY(), test.liaison);
                liaisons.remove(test);
                points.remove(po);
                trouve=true;
            }
        }
        
        if(n.liaison!=0){
            liaisons.add(n);
            points.add(new Point(n.getX(),n.getY()));
        }
        
        this.add(n.panel);
        this.validate();
        
        it = n.fils.iterator();
        int h=etage*n.hauteur;
        while(it.hasNext()){
            y+=etage*n.hauteur;
            hauteur++;
            dessinerArbre(draw,(Noeud)it.next());
            y-=etage*n.hauteur;
        }
        hauteur--;


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
    
    public void removeLabel(){
        Iterator it = label.iterator();
        while(it.hasNext()){
            remove((JLabel)it.next());
        }
        label=new ArrayList<JLabel>();
    }

    private void Liaison(Graphics2D draw, int xLiaison, int yLiaison, int x, int y, int l) {
        draw.drawLine(xLiaison, yLiaison+taille/2, x, y+taille/2);
        String s="Image/priorite"+l+".png";
        JLabel lab = new JLabel(new ImageIcon(s));
        lab.setBounds(((x-xLiaison)/2-taille/4)+xLiaison, (((y+taille/2)-(yLiaison+taille/2))/2)+yLiaison, taille/2, taille);
        label.add(lab);
        add(lab);
    }
    
}
