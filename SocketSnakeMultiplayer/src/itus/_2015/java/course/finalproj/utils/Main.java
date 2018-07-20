package itus._2015.java.course.finalproj.utils;

import java.awt.Color;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        
        GamePlay game = new GamePlay();
        JFrame fr = new JFrame();

        fr.setBounds(10, 10, 905, 700);

        fr.setBackground(Color.DARK_GRAY);

        fr.add(game);

        fr.setResizable(false);

        fr.setLocationRelativeTo(null);

        fr.setVisible(true);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
