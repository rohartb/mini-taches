package ui;

import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class EcouteurNoeud implements MouseListener,MouseMotionListener {
    Fenetre f;
    int taille = 42;
    int rayon = 64;
    java.util.List<ElementMenu> items = new ArrayList<ElementMenu>();
    Noeud noeud;
    JPanel pane;
    ItemListener ecouteur;
    
    
    public EcouteurNoeud(Fenetre aThis, Noeud n) {
        f=aThis;
        noeud = n;
        pane = noeud.panel;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        f.barreInfo.setInfo("modif");
        f.barreLaterale.bl.setPapa(noeud);
        f.barreLaterale.majBouton(noeud);
        
        f.barre.barrePropriete.nomTache.setEditable(true);
        f.barre.barrePropriete.listeCategorie.setEnabled(true);
        f.barre.barrePropriete.nomTache.setText(noeud.nom); 
        
        if(noeud.getNbFils() > 0){
            f.barre.barreOutil.augmenterEtage.setEnabled(true);
            f.barre.barreOutil.diminuerEtage.setEnabled(true);           
        }else{
            f.barre.barreOutil.augmenterEtage.setEnabled(false);
            f.barre.barreOutil.diminuerEtage.setEnabled(false);                
        }

        
        switch(noeud.type){
            case 0 :   
                // pour le root
                f.barre.barrePropriete.listeCategorie.select("Utilisateur");
                break;
            case 1 :
                f.barre.barrePropriete.listeCategorie.select("Utilisateur");
                break;
            case 2 :
                f.barre.barrePropriete.listeCategorie.select("Abstraction");
                break;
            case 3 :
                f.barre.barrePropriete.listeCategorie.select("Application");
                break;
            case 4 :
                f.barre.barrePropriete.listeCategorie.select("Interaction");
                break;
            default:
                break;
        }
        
        
        if(e.getButton() == 3){
            f.aire.destroyBulles();
            int xG=noeud.getX()-rayon-taille/2;
            int xD=noeud.getX()+rayon+taille/2;
            int yH=noeud.getY()+20-rayon-taille/2;
            int yB=noeud.getY()+20+rayon+taille/2;
            if(xG>0 && xD<f.aire.getWidth() &&
                    yH>0 && yB<f.aire.getHeight()){
                build(noeud.getX(), noeud.getY()+20);
            }else{
                f.barreInfo.setInfo("Menu non affichable");
            }
        }else if (e.getButton() == 1){
            f.aire.destroyBulles();
        }
        f.arbre.deselect(f.arbre.root);
        noeud.select = true;
        if(noeud.getPapa()!=null){
            f.menubar.couper.setEnabled(true);;
            f.barre.barreOutil.couper.setEnabled(true);
            f.barre.barreOutil.supprimer.setEnabled(true);
        }else{
            f.barre.barreOutil.couper.setEnabled(false);
            f.barre.barreOutil.supprimer.setEnabled(false);
            f.menubar.couper.setEnabled(false);            
        }
        f.barre.barreOutil.copier.setEnabled(true);
        f.menubar.copier.setEnabled(true);
        if(f.e.cop!=null){
            f.barre.barreOutil.coller.setEnabled(true);
            f.menubar.coller.setEnabled(true);
        }        
        
        f.aire.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        f.aire.destroyBulles();
        f.barreLaterale.bl.setPapa(noeud);
        f.arbre.deselect(f.arbre.root);
        noeud.select = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        f.barreInfo.setInfo("modif");
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    

    @Override
    public void mouseDragged(MouseEvent me) {
            f.barreInfo.setInfo("deplacement");
            f.aire.deplacer(me.getX(), me.getY(), noeud, pane);
            f.aire.destroyBulles();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    
    public void build(int xCentre, int yCentre){
        if(items.isEmpty()){
            items.add(new ElementMenu("propriété", new Color(153,204,255), new Color(102 ,153 ,204), 100,f));
            items.add(new ElementMenu("couper", new Color(153,204,255), new Color(102 ,153 ,204), 100,f));
            items.add(new ElementMenu("copier", new Color(153,204,255), new Color(102 ,153 ,204), 100,f));
            items.add(new ElementMenu("coller", new Color(153,204,255), new Color(102 ,153 ,204), 100,f));
            items.add(new ElementMenu("supprimer", new Color(153,204,255), new Color(102 ,153 ,204), 100,f));
            items.add(new ElementMenu("replacer", new Color(153,204,255), new Color(102 ,153 ,204), 100,f));
        }
        if(items!=null && items.size()>0){
            double angle=2*Math.PI/(items.size());
            for(int i=0; i<items.size(); i++){
                ElementMenu bulle = new ElementMenu(items.get(i).getNom(), items.get(i).getCouleurNormal(), items.get(i).getCouleurActif(), taille,f);
                bulle.setBounds((int)(xCentre-taille/2+rayon*Math.cos(i*angle)), (int)(yCentre-taille/2+rayon*Math.sin(i*angle)), taille+10, taille+10);
                f.aire.dest.add(bulle);
                f.aire.add(bulle);
            }
        }
    }
    
}
