/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author bastien
 */
public class Noeud {
    ArrayList<Noeud> fils = new ArrayList<Noeud>();
    private Noeud papa;
    String nom;
    int type;
    int liaison;
    int[] propriete;
    private int x;
    private int y;
    Boolean select=false;
    Boolean deplace=false;
    JPanel panel;
    ImageIcon image;
    
    public Noeud(Noeud dad, String n, int t, int l){
        papa=dad;
        nom=n;
        type=t;
        liaison=l;
        propriete= new int[3];
        propriete[0]=0;
        propriete[1]=0;
        propriete[2]=0;

        panel = new JPanel();
        
    }
    
    public int getNbFils(){
        return fils.size();
    }
    
    public void setPapa(Noeud p){
        papa = p;
    }
    
    public Noeud getPapa(){
        return papa; 
    }
    
    public void ajouterFils(Noeud n){
        fils.add(n);
    }
    
    public void ajouterFils(Noeud n, Fenetre f){
        fils.add(n);
        f.barre.barreOutil.augmenterEtage.setEnabled(true);
        f.barre.barreOutil.diminuerEtage.setEnabled(true);
    }
    
    public void setX(int x){
        this.x=x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public JLabel ajouterImage(int i){
        switch (i){
            case 1 :
                image = new ImageIcon("Image/user.png");
                break;
            case 2 :
                image = new ImageIcon("Image/abstract.png");
                break;
            case 3 : 
                image = new ImageIcon("Image/application.png");
                break;
            case 4 :
                image = new ImageIcon("Image/interaction.png");
                break;
            default:
                break;
        }
        
        JLabel label = new JLabel(image);
        return label;
    }
    
    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
}
