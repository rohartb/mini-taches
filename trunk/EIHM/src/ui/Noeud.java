/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author bastien
 */
public class Noeud {
    ArrayList<Noeud> fils = new ArrayList<Noeud>();
    Noeud papa;
    String nom;
    int type;
    int liaison;
    int propriete;
    int x;
    int y;
    Boolean bouge=false;
    JPanel panel;
    
    public Noeud(Noeud dad, String n, int t, int l, int p){
        papa=dad;
        nom=n;
        type=t;
        liaison=l;
        propriete=p;
        
        panel = new JPanel();
        
    }
    
    public int getNbFils(){
        return fils.size();
    }
    
    public Noeud getPapa(){
        return papa; 
    }
    
    public void ajouterFils(Noeud n){
        fils.add(n);
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
}
