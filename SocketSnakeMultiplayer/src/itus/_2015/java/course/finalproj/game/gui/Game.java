package itus._2015.java.course.finalproj.game.gui;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class Game extends JFrame {
    
    public Game()
    {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("Snake");
        super.setResizable(false);
        
        init();
    }
    
    public void init()
    {
        super.setLayout(new GridLayout(1,1,0,0));
        Screen s = new Screen();
        super.add(s);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Game();
    }
    
}
