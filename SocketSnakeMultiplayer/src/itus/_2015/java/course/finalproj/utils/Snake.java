package itus._2015.java.course.finalproj.utils;

import java.util.HashMap;
import java.util.LinkedList;

public class Snake {
    public Direction direction;
    LinkedList<Point> points; // last element is head
    public Point head;
    public int id;
    public int score;
    
    enum Direction {
       East, West, South, North
    }
    
    public Snake() {}
    
    public Snake(Point start, int size, int id)
    {
        this.id = id;
        this.points = new LinkedList<>();
        
        for (int i=0; i< size; i++)
        {
            Point tmp = new Point(start.x + 25*i, start.y);
            points.add(tmp);
        }
        
        // set default direction
        direction = Direction.East;
        // set head, head equal last element of List<Point>
        head = points.getLast();
        // initial Score
        score = 0;
    }
    
    synchronized public void grow() {
		points.addFirst(null);// will be immediately removed
		move();
	}

	synchronized public boolean isInCollisionWithPoint(Point a) {
		if (a.equals(head) && a!=head)
			return true;
		return false;
	}

	synchronized public boolean isInCollisionWithSnake(Snake a) {
		for (Point b : a.points)
			if (isInCollisionWithPoint(b))
				return true;
		return false;
	}

	synchronized public Snake isInCollision(HashMap<Integer,Snake> a) {
		for (Snake b : a.values())
			if (isInCollisionWithSnake(b))
				return b;
		return null;
	}

    
    synchronized byte direction() {
            switch (this.direction) {
            case West:
                    return (byte) 0;
            case North:
                    return (byte) 1;
            case East:
                    return (byte) 2;
            case South:
                    return (byte) 3;

            default:
                    break;
            }
            return (byte) -1;
	}

    synchronized public void direction(byte i) {
        if (direction() % 2 != i % 2) {
                switch (i) {
                case 0:
                        this.direction = Direction.West;
                        break;
                case 1:
                        this.direction = Direction.North;
                        break;
                case 2:
                        this.direction = Direction.East;
                        break;
                case 3:
                        this.direction = Direction.South;
                        break;

                default:
                        break;
                }
        }
    }
        
    synchronized public void move() {
            points.removeFirst();
            int x = head.x;
            int y = head.y;

            switch (this.direction) {
            case North:
                    y-=25;
                    break;
            case South:
                    y+=25;
                    break;
            case East:
                    x+=25;
                    break;
            case West:
                    x-=25;
                    break;
            default:
                    break;
            }
            Point newHead = new Point(x, y);
            points.addLast(newHead);
            head = newHead;
    }
    
    @Override
    public String toString() {
		String s = "Snake " + id + " [";
		for (Point p : points) {
			s += p.toString();
			if (!p.equals(head))
				s += ",";
		}
		s += "] goes " + direction;
		return s;
	}
    
    
    public static void main(String[] args) {
        System.out.println("Creating a snake");
		Snake s = new Snake(new Point(10, 10), 5, (byte) 1);
		System.out.println(s);
		System.out.println();
		System.out.println("Testing directions and move()");
		s.direction((byte) 3);
		s.move();
		System.out.println(s);
    }
        
}
