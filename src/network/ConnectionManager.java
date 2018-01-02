/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.ArrayList;
import java.net.InetAddress;
/**
 * This class manages the list of Peers currently connected to the instance of
 * FlockProtocol that instantiated ConnectionManager.
 * @author Timothy Lloyd
 */
class ConnectionManager {
    
    private ArrayList<Peer> connections;
    
    public ConnectionManager(){
        connections = new ArrayList<>();
    }
    
    /**
     * Adds a new Peer to ConnectionManager using the passed information,
     * ensuring the connection doesn't already exist.
     * @param ip The Peer's IPv4 address
     * @param port The Peer's port number
     * @param sequence The sequence number initiated by the peer
     * @return Returns true if the connection was added, otherwise returns false
     * if the connection already exists.
     */
    public boolean addConnection(InetAddress ip, int port, int sequence){
        if(findConnection(ip, port) == -1){
            connections.add(new Peer(ip, port, sequence));
            return true;
        }
        return false;
    }
    
    /**
     * Removes a Peer whose information matches the passed information.
     * @param ip The Peer's IPv4 address
     * @param port THe Peer's port number
     * @return Returns true if the Peer was removed, otherwise returns false if
     * the Peer doesn't exist.
     */
    public boolean removeConnection(InetAddress ip, int port){
        int connIndex = findConnection(ip, port);
        
        if(connIndex != -1){
            connections.remove(connIndex);
            return true;
        }
        return false;
    }
    
    /*
        Use this method to recursively find a Peer within the 'connections'
        ArrayList using a passed IP and port number. Returns the found Peer's
        index within 'connections' otherwise returns -1 if not found.
    */
    private int findConnection(InetAddress ip, int port){
        for(Peer conn : connections){
            if(conn.checkConnection(ip, port))
                return connections.indexOf(conn);
        }
        return -1;
    }
}
