package itus._2015.java.course.finalproj.common;

import itus._2015.java.course.finalproj.database.UserService;
import itus._2015.java.course.finalproj.serverSide.ClientHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    public String code;
    public int status;
    public static final int MAX_JOINER=4;
    public  int NUMBER_JOINER = 0;
    public List<ClientHandler> lstClientView = null;
    UserService dataFunc;

    public Room(String code) {
       this.code = code;
       status = -1;
       NUMBER_JOINER = 1;
       lstClientView = new ArrayList<ClientHandler>();
       dataFunc = new UserService();
    }
    
    
    public static String randomPIN()
    {
        return ""+((int)(Math.random()*9000)+1000);
    }
    
    
}
