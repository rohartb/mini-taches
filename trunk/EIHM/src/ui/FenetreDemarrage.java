package ui;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetreDemarrage extends JDialog{

    Fenetre f;
    
    public FenetreDemarrage() {
        this.setTitle("MiniTache");
        this.setSize(400, 200);
        this.setLayout(null);
        
        JLabel label = new JLabel();
        label.setBorder(BorderFactory.createLineBorder(Color.green));
        label.setText("Bienvenue sur Mini Tache, le logiciel de gestion de tache");
        label.setBounds(10, 10, 350, 20);
        
        JLabel label2 = new JLabel();
        label2.setBorder(BorderFactory.createLineBorder(Color.black));
        label2.setText("Vous pouvez :");
        label2.setBounds(10, 30, 350, 20);
        
        JButton ouvrir = new JButton("Ouvrir");
        ouvrir.setBounds(10,50, 80, 20);  
        
        
        JCheckBox checkBox = new JCheckBox();
        checkBox.setBorder(BorderFactory.createLineBorder(Color.red));
        checkBox.setText("Ne plus afficher cette fenêtre au démarrage");
        checkBox.setBounds(10, 100, 350, 20);
        
        ActionListener ecouteurChekBox = new EcouteurCheckBox();
        checkBox.addActionListener(ecouteurChekBox);

        
        this.add(label);
        this.add(label2);
        this.add(checkBox);
        this.add(ouvrir);
        //fenetre centré
        this.setLocationRelativeTo(null);
    }
    
}
