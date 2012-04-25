/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;

/**
 *
 * @author sophie
 */
public class Historique {
    private ArrayList<Noeud> annuler;
    private ArrayList<Noeud> retablir;
    Fenetre f;

    Historique(Fenetre f){
        annuler = new ArrayList<Noeud>();
        retablir = new ArrayList<Noeud>();
        this.f=f;
    }

   /* boolean annulerVide(){
        return annuler.isEmpty();
    }
    
    boolean refaireVide(){
        return retablir.isEmpty();
    }*/

    void viderRetablir(){
        retablir = new ArrayList<Noeud>();
    }
    
    void viderAnnuler(){
        annuler = new ArrayList<Noeud>();
    }

    void ajouterAnnuler(Noeud n){
        if(n!=null){
            if(annuler.size()==10){
                annuler.remove(0);
            }
            annuler.add(n);
            f.menubar.annuler.setEnabled(true);          
            f.barre.barreOutil.annuler.setEnabled(true);
        }

    }
    
    void ajouterRetablir(Noeud n){
        if(n!=null){
            retablir.add(n);
            f.menubar.retablir.setEnabled(true);
            f.barre.barreOutil.retablir.setEnabled(true);             

        }
    }

   /* int tailleAnnuler(){
        return annuler.size();
    }

    int tailleRetablir(){
        return retablir.size();
    }*/

    Noeud annuler() {
        if(!annuler.isEmpty()){
            Noeud res = annuler.remove(annuler.size()-1);
            if(annuler.isEmpty()){
                f.menubar.annuler.setEnabled(false); 
                f.barre.barreOutil.annuler.setEnabled(false);             

            }            
            return res;
        }else{
            return null;
        }
        
    }

    Noeud retablir() {
        if(!retablir.isEmpty()){
            Noeud res = retablir.remove(retablir.size()-1);
            if(retablir.isEmpty()){
                f.menubar.retablir.setEnabled(false);
                f.barre.barreOutil.retablir.setEnabled(false);             
            }
            return res;
        }else{
            return null;
        }
    }
   
}
