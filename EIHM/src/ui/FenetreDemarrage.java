package ui;
import java.awt.BorderLayout;
import java.awt.Color;
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
        
        JCheckBox checkBox = new JCheckBox();
        checkBox.setBorder(BorderFactory.createLineBorder(Color.red));
        checkBox.setText("Ne plus afficher cette fenêtre au démarrage");
        checkBox.setBounds(10, 100, 350, 20);

        
        this.add(label);
        this.add(checkBox);
        //fenetre centré
        this.setLocationRelativeTo(null);
    }
    
}
