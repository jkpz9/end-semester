package itus._2015.java.course.finalproj.utils;

public class Point {
    public int x;
    public int y;
    
    public Point() {}
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o)
    {
        Point that = (Point)o;
        return that.x == this.x && that.y == this.y;
    }
    
    @Override
    public String toString()
    {
            return "("+x+","+y+")";
    }
}
