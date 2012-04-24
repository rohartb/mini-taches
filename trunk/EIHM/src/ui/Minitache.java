package ui;

import javax.swing.*;

public class Minitache {

    public static void main(String[] args) {
       Minitache m = new Minitache();
    }

    public Minitache() {
       Fenetre fenetre = new Fenetre("Mini tache");
       SwingUtilities.invokeLater(fenetre);
    }
}
