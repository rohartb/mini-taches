
package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class AireDeDessin extends JComponent {
    int height;
    int width;

    public AireDeDessin() {
        this.setBorder(BorderFactory.createLineBorder(Color.pink));
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D draw = (Graphics2D) g;

        height = this.getHeight();
        width = this.getWidth();
        draw.setColor(Color.pink);
        draw.fillRect(0, 0,(int)width,(int)height);
        draw.setPaint(Color.black);
    }
}
