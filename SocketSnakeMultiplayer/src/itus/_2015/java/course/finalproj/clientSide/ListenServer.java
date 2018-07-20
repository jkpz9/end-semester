package itus._2015.java.course.finalproj.clientSide;

import itus._2015.java.course.finalproj.common.Message;
import itus._2015.java.course.finalproj.common.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListenServer extends Thread {
    
    Socket socket;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    InputStream inputStream;
    ObjectInputStream objectInputStream;
    
    public User user;
    
    public inReceiveMessage receive;
    
    public ListenServer(Socket socket) throws IOException
    {
        this.socket = socket;
        outputStream = socket.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
        inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);
    }
    
    
    @Override
    public void run()
    {
        do {
            try {
                Object o = objectInputStream.readObject();
                if (o != null && receive != null)
                {
                    receive.ReceiveMessage((Message)o);
                }
            } catch (IOException ex) {
                Logger.getLogger(ListenServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListenServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } while (true);
        
    }
    
    public void SendMessage(int ty, Object obj) throws IOException
    {
        Message msg = new Message(ty, obj);
        SendMessage(msg);
    }

    private void SendMessage(Message msg) throws IOException {
        objectOutputStream.reset();
        objectOutputStream.writeObject(msg);
    }
}
