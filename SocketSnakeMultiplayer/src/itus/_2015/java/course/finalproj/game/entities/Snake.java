
package itus._2015.java.course.finalproj.game.entities;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    public boolean left=false, right=false, up=false, down=false;
    public List<BodyPart> bodies;
    
    public int size;
    
    public Snake()
    {
        bodies = new ArrayList<>();
    }
    
    public Snake(int size)
    {
        this.size = size;
    }
    
    public Snake(List<BodyPart> bodies)
    {
        this.bodies = bodies;
    }
}
