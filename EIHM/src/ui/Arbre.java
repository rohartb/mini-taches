/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Iterator;

/**
 *
 * @author bastien
 */
public class Arbre { 
    public Noeud root;
    static int i=0;
    public int[] hauteur=new int[50];
    private int h=0;

    public Arbre(Noeud r){
        root=r;
        //hauteur
    }

    public Arbre(){
        root= new Noeud(null, "Root", 0, 0);
    }

 
    public void supprimerArbre(Noeud n){
        if(n.fils.isEmpty()){
            if(n.getPapa()!=null){
                n.nom=null;
                n.getPapa().fils.remove(n);
            } else {
                root = null;
            }
        } else {
            while(i<n.getNbFils()){
                supprimerArbre(n.fils.get(i));
                i++;
            }
            i=0;
            n.fils.clear();
            supprimerArbre(n);
        }
    }
    
    public void deselect(Noeud n){
        Iterator it = n.fils.iterator();
        n.select=false;
        while(it.hasNext()){
            deselect((Noeud) it.next());
        }
    }
    
    public void calculHauteur(){
        Noeud n = root;
        for(int i=0; i<hauteur.length;i++){
            hauteur[i]=0;
        }
        calcul(n);
        h=0;
    }
    
    private void calcul(Noeud n){
        Iterator it = n.fils.iterator();
        hauteur[h]++;
        while(it.hasNext()){
            h++;
            calcul((Noeud) it.next());
        }
        h--;
    }
}
