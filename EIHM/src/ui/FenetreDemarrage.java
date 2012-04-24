package ui;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetreDemarrage extends JDialog{

    Fenetre f;
    
    public FenetreDemarrage(Fenetre f) {
        this.f = f;
        setTitle("MiniTache");
        setSize(450, 180);
        setLayout(null);
        
        JLabel label = new JLabel();
        //label.setBorder(BorderFactory.createLineBorder(Color.green));
        label.setText("Bienvenue sur Mini Tache, le logiciel de gestion de tache");
        label.setBounds(10, 10, 350, 20);
        
        JLabel label2 = new JLabel();
        //label2.setBorder(BorderFactory.createLineBorder(Color.black));
        label2.setText("Vous pouvez :");
        label2.setBounds(10, 30, 350, 20);
        
        JButton ouvrir = new JButton("Ouvrir un projet");
        ouvrir.setBounds(10, 50, 130, 30);
        ouvrir.addActionListener(new EcouteurFenetreDemarrage(this, this.f));
        ouvrir.setActionCommand("ouvrir");
        
        JButton demo = new JButton("Démonstration");
        demo.setBounds(150,50, 130, 30);
        //demo.addActionListener(new EcouteurFenetreDemarrage(this, this.f));
        //demo.setActionCommand("demo");
        
        JButton aide = new JButton("Aide");
        aide.setBounds(290,50, 130, 30);
        aide.addActionListener(new EcouteurFenetreDemarrage(this, this.f));
        aide.setActionCommand("aide");
        
        
        JCheckBox checkBox = new JCheckBox();
        checkBox.setBorder(BorderFactory.createLineBorder(Color.red));
        checkBox.setText("Ne plus afficher cette fenêtre au démarrage");
        checkBox.setBounds(10, 100, 350, 20);
        
        ActionListener ecouteurChekBox = new EcouteurCheckBox();
        checkBox.addActionListener(ecouteurChekBox);

        
        add(label);
        add(label2);
        add(checkBox);
        add(ouvrir);
        add(demo);
        add(aide);
        
        //fenetre centré
        setLocationRelativeTo(null);
    }
    
}
