package eihm;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    
    public Fenetre(){}
    
    public JFrame construireFenetre(){
        JFrame frame = new JFrame("Mini Tâche");
        //Container content = frame.getContentPane():
        
        
        frame.setSize(1000,800);
        frame.setVisible(true);
        return frame;
    }
    
    
}
