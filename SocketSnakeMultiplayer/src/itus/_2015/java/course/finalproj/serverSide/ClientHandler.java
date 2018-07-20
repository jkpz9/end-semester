package itus._2015.java.course.finalproj.serverSide;

import itus._2015.java.course.finalproj.common.Message;
import itus._2015.java.course.finalproj.common.Room;
import itus._2015.java.course.finalproj.common.User;
import itus._2015.java.course.finalproj.database.UserService;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.StringTokenizer ;

public class ClientHandler extends Thread {
    
    public Room room = null;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    
    public User user;
    
     Boolean execute = false;
    
   ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            
            execute = true;
        }
   
    void ReceiveMessage(Message msg) throws IOException
    {
        switch(msg.getType()) 
        {
            case 0:
                {
                    User temp = (User)msg.getObject();
                    UserService df = new UserService();
                    user = df.checkLogin(temp.getUsername(), temp.getPassword());
                    if(user != null)
                    {
                        for (ClientHandler cli : ServerFrame.lstClient) {
                            if (cli!=this && cli.user!=null && cli.user.getUsername().equalsIgnoreCase(user.getUsername()))
                            {
                                user = null;
                                break;
                            }
                        }
                        if (user!=null)
                        {
                              System.out.println("Server: Hello " + user.getUsername());
                              ServerFrame.users.add(user.getUsername());
                              System.out.println("add online " + user.getUsername());
                        }
                          
                    }
                    SendMessage(0, user);
                    break;
                }
                
            case 1:
            {       System.out.println((User)msg.getObject());
                    User temp = (User)msg.getObject();
                    UserService df = new UserService();
                    boolean succ;
                    succ = df.checkAva(df.getId(temp.getUsername()));
                    if (succ == true) {
                        SendMessage(1, temp.getUsername() + " is Available");
                        return;
                    }

                    succ = df.register(temp.getUsername(), temp.getPassword());
                    if (succ == true) {
                        SendMessage(1, "Register succesfull");
                    }
                    
                    break;
                }
            case 21: //Get all online users
                {
                List<String> users = new ArrayList<String>();
                for (int i=0; i<ServerFrame.lstClient.size(); i++)
                {
                    if (ServerFrame.lstClient.get(i).user != null)
                        users.add(ServerFrame.lstClient.get(i).user.getUsername());
                }
                    for (int i=0; i<ServerFrame.lstClient.size(); i++)
                    //ServerFrame.lstClient.get(i).SendMessage(21, ServerFrame.users);
                    ServerFrame.lstClient.get(i).SendMessage(21, users);
                    break;
                }
            
            // create room
            case 123: 
            {
                String code = Room.randomPIN();
                Room r = new Room(code);
                r.lstClientView.add(this);
                ServerFrame.lstRoom.add(r);
                List<String> users = new ArrayList<String>();
                users.add(this.user.getUsername());
                SendMessage(new Message(123, code));
                SendMessage(new Message(128, users));
                break;
            }
            
            
            // join room
            case 124: 
            {
                String[] tokens = ((String)msg.getObject()).split("#");
                String username = tokens[0];
                String code = tokens[1];
                Room r = null;
                for (int i=0; i< ServerFrame.lstRoom.size();i++)
                {
                    if(ServerFrame.lstRoom.get(i).code.equals(code))
                    {
                        r = ServerFrame.lstRoom.get(i);
                        System.out.println("ROOM DETECTED");
                    }
                }
                if (r == null)
                {
                    String notify = "CODE DOESNT MATCH ANY ROOM";
                    SendMessage(124, notify);
                    System.out.println("CODE DOESNT MATCH ANY ROOM");
                    break;
                }
                
                if (r.status != -1)
                {
                    String notify = "NOT ABLE TO JOINE DUE TO GAME IS PLAYING OR ENDED";
                    System.out.println("NOT ABLE TO JOINE DUE TO GAME IS PLAYING OR ENDED");
                    SendMessage(125, notify);
                    break;

                }
                
                for (int i=0; i<r.lstClientView.size();i++)
                {
                    if(r.lstClientView.get(i).user != null)
                    {
                        if (r.lstClientView.get(i) == this)
                        {
                            String notify = "ALREADY JOIN THIS ROOM";
                            System.out.println("ALREADY JOIN THIS ROOM");
                            SendMessage(126, notify);  
                            break;
                        }  
                    }
                }
               
                if(r.NUMBER_JOINER >= Room.MAX_JOINER)
                {
                    String notify = "ROOM IS FULL NOW";
                     System.out.println("ROOM IS FULL NOW");
                     SendMessage(127, notify);
                     break;
                }
                
                r.lstClientView.add(this);
                if(r.lstClientView.size() == Room.MAX_JOINER)
                {
                    r.status = 0;
                }
                SendMessage(new Message(123, code));
                System.out.println("ADDED " + username + " INTO ROOM " + code);
               // SendMessage(127, this.user.getUsername());
                List<String> users = new ArrayList<String>();
                for (int i=0; i<r.lstClientView.size(); i++)
                {
                   users.add(r.lstClientView.get(i).user.getUsername());
                }
                
                for (int i=0; i<r.lstClientView.size(); i++)
                {
                    System.out.println(users.toString());
                   r.lstClientView.get(i).SendMessage(128,users);
                }
                
                break;
                
            }
                
            case 147:
            {
                //StringTokenizer tokens = new StringTokenizer((String)msg.getObject(), "#");
                System.out.println((String)msg.getObject());
                String[] tokens = ((String)msg.getObject()).split("#");
//                String receiver = (String) tokens.nextToken();
//                String plainMsg = (String)tokens.nextToken();
                String receiver = tokens[0];
                String plainMsg = tokens[1];
                ClientHandler target = null;
                for (int i=0; i< ServerFrame.lstClient.size(); i++)
                {
                    if(ServerFrame.lstClient.get(i).user.getUsername().equalsIgnoreCase(receiver))
                    {
                        target = ServerFrame.lstClient.get(i);
                        break;
                    }
                }
                if (target == null) return;
                System.out.println("TARGET FOUND");
                target.SendMessage(new Message(147, user.getUsername() +"#"+plainMsg));
                break;
            }
        }
    }
    
    public void SendMessage(int ty, Object obj) throws IOException {
            Message temp = new Message(ty, obj);
            SendMessage(temp);
        }
    
     public void SendMessage(Message msg) throws IOException {
            outputStream.reset();
            outputStream.writeObject(msg);
        }
     
      public Boolean closeClient() throws Throwable
        {
            
            
            if (room!=null) // Thong bao thoat room
            {
                try {
                    room.lstClientView.remove(this);
                } catch (Exception e) {
                    
                }
                
                //room.clientExit(this);
            }
            
            ServerFrame.lstClient.remove(this);
            try {
                this.socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Client Exit");
            execute = false;
            
            
            return true;
        }
      
      @Override
        public void run() {
            
            while (execute) {
                
                try {
                    Object o = inputStream.readObject();
                    if (o != null) {
                        ReceiveMessage((Message)o);
                    }
                    //Guilai();
                } catch (IOException e) {
                    try {
                        closeClient();
                    } catch (Throwable ex) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    
}
