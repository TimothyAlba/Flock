/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.ArrayList;
import java.net.InetAddress;
/**
 *
 * @author up6071fd
 */
public class ConnectionManager {
    
    private static ConnectionManager instance;
    private ArrayList<Connection> connections;
    
    protected ConnectionManager(){
        //  Blocked Constructor
    }
    
    public ConnectionManager getInstance(){
        if(instance == null)
            instance = new ConnectionManager();
        return instance;
    }
    
    public boolean addConnection(InetAddress ip, int port, int sequence){
        
    }
    
    public boolean removeConnection(InetAddress ip, int port){
        
    }
    
    private int 
}
