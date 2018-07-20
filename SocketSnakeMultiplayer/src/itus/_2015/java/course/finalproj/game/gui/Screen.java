package itus._2015.java.course.finalproj.game.gui;

import itus._2015.java.course.finalproj.game.entities.Apple;
import itus._2015.java.course.finalproj.game.entities.BodyPart;
import itus._2015.java.course.finalproj.game.entities.Snake;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
    
    private Snake snake;
    private BodyPart b;
    private Apple apple;
    private List<Apple> apples;
    private Random random;
    
    private int ticks = 0;
    
    private int xCoor = 10, yCoor = 10;
    
    private int SIZE = 10;
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    
    private boolean running = false;
    
    private Thread thread;
    
    private Key key;
    
    public void paint(Graphics g)
    {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        g.setColor(new Color(84,110,122));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        // make background
        g.setColor(Color.BLACK);
        for(int i=0; i<WIDTH/10; i++)
            g.drawLine(i*10, 0, i*10, HEIGHT);
        
        for(int j=0; j<HEIGHT/10; j++)
            g.drawLine(0, j*10, WIDTH, j*10);
        
       // Display snake
       for(int i=0; i<snake.bodies.size(); i++)
       {
           snake.bodies.get(i).draw(g, Color.GREEN);
       }
       
       // Display Foods
       for (int k=0; k<apples.size(); k++)
       {
           apples.get(k).draw(g);
       }
    }
    
    public Screen()
    {
        super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        super.setFocusable(true);
        key = new Key();
        super.addKeyListener(key);
        snake = new Snake();
        //snake.down = true;
        apples = new ArrayList<>();
        random = new Random();
        start();
    }

    private void start() {
        running = true;
        thread = new Thread(this, "GAME LOOP");
        thread.start();
    }

    public void stop()
    {
        try {
            running = false;
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        while(running)
        {
            tick();
            super.repaint();
        }
    }

    private void tick() {
        
       if (snake.bodies.isEmpty())
       {
           b = new BodyPart(xCoor, yCoor, 10);
           snake.bodies.add(b);
       }
       
       if (apples.isEmpty())
       {
           apples.add(new Apple(random.nextInt(78),random.nextInt(78), 10));
       }
       
       for(int k=0; k<apples.size();k++)
       {
           if (xCoor == apples.get(k).getxCoor() && yCoor == apples.get(k).getyCoor())
           {
               SIZE++;
               apples.remove(k);
               k--;
           }
       }
       
       //These line cuz game thread die, dont know why
//        for(int z=0; z< snake.bodies.size(); z++)
//       {
//           if(xCoor == snake.bodies.get(z).getxCoor() && yCoor == snake.bodies.get(z).getyCoor())
//           {
//               int headIdx = snake.bodies.size()-1;
//               if( z != headIdx)
//               {
//                    stop();
//               }
//              
//           }
//       }
       
        /*
        if (xCoor < 0 || xCoor > 79 || yCoor <0 || yCoor > 79)
        {
            stop();
        }
        */
        if(xCoor < 0) xCoor = 79;
        if(xCoor > 79) xCoor = 0;
        if(yCoor < 0) yCoor = 79;
        if(yCoor > 79) yCoor = 0;
       
       ticks++;
       
       if (ticks > 250000) 
       {
           if (snake.right)
               xCoor++;
           if (snake.left)
               xCoor--;
           if (snake.down)
               yCoor++;
           if (snake.up)
               yCoor--;
           
           ticks = 0;
           
           b = new BodyPart(xCoor, yCoor, 10);
           snake.bodies.add(b);
           
           if (snake.bodies.size() > SIZE)
           {
               snake.bodies.remove(0);
           }
       }
       
    }
    
    private class Key implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT  && !snake.left)
            {
                snake.up = false;
                snake.down = false;
                snake.right = true;
            }
            
             if (e.getKeyCode() == KeyEvent.VK_LEFT  && !snake.right)
            {
                snake.up = false;
                snake.down = false;
                snake.left = true;
            }
             
              if (e.getKeyCode() == KeyEvent.VK_DOWN && !snake.up)
              {
                snake.right = false;
                snake.left = false;
                snake.down = true;
            }
              
            if (e.getKeyCode() == KeyEvent.VK_UP && !snake.down)
          {
            snake.right = false;
            snake.left = false;
            snake.up = true;
        }
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
    }
     
}
