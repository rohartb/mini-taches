/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;

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
    
    public Noeud(Noeud dad, String n, int t, int l, int p){
        papa=dad;
        nom=n;
        type=t;
        liaison=l;
        propriete=p;
    }
    
    public int getNbFils(){
        return fils.size();
    }
    
    
    
    public void ajouterFils(Noeud n){
        fils.add(n);
    }
    
    public void setX(int x){
        this.x=x;
    }
}
