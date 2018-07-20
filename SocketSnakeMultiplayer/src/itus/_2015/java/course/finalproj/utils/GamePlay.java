package itus._2015.java.course.finalproj.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener, ActionListener{
//    private Timer timer;
//    private int delay = 100;
    Snake snake = new Snake(new Point(50,100), 5,1);
    private Random random =  new Random();
    Point p = new Point(25+random.nextInt(34),75+random.nextInt(23)); 
    
    public GamePlay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
//        timer = new Timer(delay, this);
//        timer.start();
    }

    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;

    private Timer timer;
    private int delay = 100;

    private ImageIcon titleImage;
    private ImageIcon snakeImage;
    private ImageIcon enemyImage;
    
    
   public void paint(Graphics g)
	{
		
		// draw title image border
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		// draw the title image
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		// draw border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		// draw background for the gameplay
		g.setColor(Color.black);
		g.fillRect(25,75 , 850, 575);
		
		
		// draw score
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Length: " + snake.points.size(), 780, 50);
		
		
		// draw length
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Scores: " + snake.score, 780, 30);
		
		
		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snake.head.x, snake.head.y);
		
		
		for (int a=0; a<snake.points.size(); a++)
		{
			if (a==snake.points.size()-1 && snake.direction == Snake.Direction.East)
			{
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snake.head.x, snake.head.y);
			}
			
			if (a==snake.points.size()-1 && snake.direction == Snake.Direction.West)
			{
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g,snake.head.x, snake.head.y);
			}
			
			if (a==snake.points.size()-1 && snake.direction == Snake.Direction.South)
			{
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snake.head.x, snake.head.y);
			}
			
			if (a==snake.points.size()-1 && snake.direction == Snake.Direction.North)
			{
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snake.head.x, snake.head.y);
			}
			
			if (a!= 0)
			{
				snakeImage = new ImageIcon("snakeimage.png");
				snakeImage.paintIcon(this, g,snake.points.get(a).x, snake.points.get(a).y );
			}
		}
		
		
		enemyImage = new ImageIcon("enemy.png");
		
                if (snake.isInCollisionWithPoint(p))
                {
                    snake.score++;
                    snake.grow();
                    p = new Point(25+random.nextInt(34),75+random.nextInt(23)); 
                }
		
		enemyImage.paintIcon(this, g, p.x, p.y);
		
                for (int i=0;i<snake.points.size()-1;i++)
                {
                    if (snake.isInCollisionWithPoint(snake.points.get(i)))
                    {
//                        right = false;
//				left = false;
//				up = false;
//				down = false;
//				
                        g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("GAME OVER", 300, 300);
				
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Press Space button to restart game", 350, 340);
                    }
                }
		
		g.dispose();
	}
    
   @Override
	public void actionPerformed(ActionEvent act) {
            snake.move();
            repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
                    snake = new Snake(new Point(50,100), 3,1);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
                    snake.direction((byte)2);
            	
		}
		
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
                      snake.direction((byte)0);	
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
                      snake.direction((byte)1);
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
                    snake.direction((byte)3);
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
