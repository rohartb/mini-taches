package ui;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetreDemarrage extends JDialog{

    Fenetre f;
    
    public FenetreDemarrage(Fenetre f) {
        this.f = f;
        setTitle("MiniTache");
        setSize(435, 195);
        setLayout(null);
        
        JLabel label = new JLabel();
        //label.setBorder(BorderFactory.createLineBorder(Color.green));
        label.setText("Bienvenue sur Mini Tache, le logiciel de gestion de tache");
        label.setBounds(10, 10, 350, 20);
        
        JLabel label2 = new JLabel();
        //label2.setBorder(BorderFactory.createLineBorder(Color.black));
        label2.setText("Vous pouvez :");
        label2.setBounds(10, 30, 350, 20);
        
        
        JButton nouveau = new JButton("Nouveau projet");
        nouveau.setBounds(10, 50, 130, 30);
        nouveau.addActionListener(new EcouteurFenetreDemarrage(this, this.f));
        nouveau.setActionCommand("nouveau");
        
        JButton ouvrir = new JButton("Ouvrir un projet");
        ouvrir.setBounds(150, 50, 130, 30);
        ouvrir.addActionListener(new EcouteurFenetreDemarrage(this, this.f));
        ouvrir.setActionCommand("ouvrir");
        
        JButton astuce = new JButton("Astuces");
        astuce.setBounds(290,50, 130, 30);
        astuce.addActionListener(new EcouteurFenetreDemarrage(this, this.f));
        astuce.setActionCommand("aide");
                
        
        JCheckBox checkBox = new JCheckBox();
        //checkBox.setBorder(BorderFactory.createLineBorder(Color.red));
        checkBox.setText("Ne plus afficher cette fenêtre au démarrage");
        checkBox.setBounds(10, 100, 350, 20);
        
        JButton annuler = new JButton("Annuler");
        annuler.setBounds(150, 130, 130, 30);
        annuler.addActionListener(new EcouteurFenetreDemarrage(this, this.f));
        annuler.setActionCommand("annuler");
        
        JButton valider = new JButton("Valider");
        valider.setBounds(290, 130, 130, 30);
        valider.addActionListener(new EcouteurFenetreDemarrage(this, this.f));
        valider.setActionCommand("valider");
        
        
        ActionListener ecouteurChekBox = new EcouteurCheckBox();
        checkBox.addActionListener(ecouteurChekBox);
        
        this.f.setFocusable(false);

        
        add(label);
        add(label2);
        add(checkBox);
        add(nouveau);
        add(ouvrir);
        add(astuce);
        add(annuler);
        add(valider);
        
        //fenetre centré
        setLocationRelativeTo(null);
        setResizable(false);
    }

        
}
