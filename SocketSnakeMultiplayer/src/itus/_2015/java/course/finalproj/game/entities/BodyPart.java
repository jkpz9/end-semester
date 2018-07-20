package itus._2015.java.course.finalproj.game.entities;

import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {
    private int xCoor, yCoor, width, height;

    public BodyPart(int xCoor, int yCoor, int TileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.width = TileSize;
        this.height = TileSize;
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }
    
    public String toString()
    {
        return "["+xCoor+","+yCoor+"]";
    }
    
    public void draw(Graphics g, Color color)
    {
        g.setColor(Color.BLACK);
        g.fillRect(xCoor*width, yCoor*height, width, height);
        g.setColor(new Color(0,204,102));
         g.fillRect(xCoor*width+2, yCoor*height+2, width-4, height-4);
    }
            
}
