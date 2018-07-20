package itus._2015.java.course.finalproj.common;

import java.io.Serializable;

public class User implements Serializable {
    private int Id;
    private String username;
    private String password;
    private int win;
    private int lose;
    private int score;

    public User() {}

    public User(int Id, String name, String pass, int win, int lose, int score) {
        this.Id = Id;
        this.username = name;
        this.password = pass;
        this.win = win;
        this.lose = lose;
        this.score = score;
    }

    public User(String name, String pass) {
        this.username = name;
        this.password = pass;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

   
    
}
