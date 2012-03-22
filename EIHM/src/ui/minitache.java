package ui;

import javax.swing.*;

public class minitache {

    public static void main(String[] args) {
       minitache m = new minitache();
    }

    public minitache() {

       Fenetre fenetre = new Fenetre("Mini tache");
       SwingUtilities.invokeLater(fenetre);
    }
}
