package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;

class EcouteurCheckBox implements ActionListener {
    
    //JCheckBox checkBox;

    public EcouteurCheckBox() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox checkBox = (JCheckBox)e.getSource();
        try {
            sauver(checkBox.isSelected());
            //System.out.println(checkBox.isSelected());
        } catch (IOException ex) {
            Logger.getLogger(EcouteurCheckBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
      public void sauver(boolean checkBox) throws IOException{
		try {
			File config = new File("config.txt");                        
			if(!config.exists())
                            config.createNewFile();
			config.setWritable(true);                        

			FileOutputStream o = new FileOutputStream(config);
			PrintStream ps = new PrintStream(config);
			ps.print(checkBox);
			config.setReadOnly();
		} catch (FileNotFoundException ex) {}
	}
}
