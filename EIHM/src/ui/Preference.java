package ui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

public class Preference extends JDialog {

    public Preference() {
        setTitle("Préférences");
        setSize(500, 410);
        setVisible(true);
        
        Image icone = Toolkit.getDefaultToolkit().getImage("Image/check.png");
        setIconImage(icone);
        
        JCheckBox box = new JCheckBox();
        box.setText("Afficher de nouveau la fenêtre de démarrage");       
        
        // On vérifie la valeur dans config.txt pour savoir si le text doit être cliquable ou pas
        String fichier = "config.txt";
        File config = new File(fichier);
        if (config.exists()) {
            //lecture du fichier texte	
            try {
                InputStream ips = new FileInputStream(fichier);
                InputStreamReader ipsr = new InputStreamReader(ips);
                BufferedReader br = new BufferedReader(ipsr);
                String valeurCheckBox;
                while ((valeurCheckBox = br.readLine()) != null) {
                    if (valeurCheckBox.equals("true")) {
                        box.setEnabled(true);
                    }else{
                        box.setEnabled(false);
                    }
                }
                br.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }else{
            box.setEnabled(false);
        }
        
        ActionListener ecouteurPref = new EcouteurPreference();
        box.addActionListener(ecouteurPref);
        
        JButton valider = new JButton("Valider");
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Preference.this.setVisible(false);
            }        
        });
        
        
        
        add(box, BorderLayout.NORTH);
        add(valider, BorderLayout.SOUTH);
        
        //fenetre centrer
        setLocationRelativeTo(null);
    }
    
    
}
