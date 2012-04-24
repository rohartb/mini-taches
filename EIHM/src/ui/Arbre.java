/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author bastien
 */
public class Arbre { 
    public Noeud root;
    static int i=0;

    public Arbre(Noeud r){
        root=r;
    }

    public Arbre(){
        root= new Noeud(null, "Root", 0, 0, 0);
    }

 
    public void supprimerArbre(Noeud n){
        if(n.fils.isEmpty()){
            if(n.papa!=null){
                n.nom=null;
                n.papa=null;
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
}
