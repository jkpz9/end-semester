package itus._2015.java.course.finalproj.game.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Apple {
    
    private int xCoor, yCoor, width, height;

    public Apple(int xCoor, int yCoor, int TileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.width = TileSize;
        this.height = TileSize;
    }
    
    public Apple() {}
    
    public void tick()
    {
        
    }
    
    public void draw(Graphics g)
    {
        g.setColor(new Color(255,87,34));
        g.fillRect(xCoor*width, yCoor*height, width, height);
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
    
}
