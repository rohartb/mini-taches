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
    String type;
    int priorite;
    
    public Noeud(String t, int p){
        type=t;
        priorite=p;
    }
    
    public int getNbFils(){
        int size=0;
        for(Noeud n : fils){
            size++;
        }
        return size;
    }
    
    
    
    public void ajouterFils(Noeud n){
        fils.add(n);
    }
}
