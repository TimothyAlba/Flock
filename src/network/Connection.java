/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.net.InetAddress;
/**
 *
 * @author up6071fd
 */
public class Connection {
    
    private InetAddress ip;
    private int port;
    private int sequence;
    
    protected Connection(){
        //  Blocked Constructor
    }
    
    public Connection(InetAddress ip, int port, int sequence){
        this.ip = ip;
        this.port = port;
        this.sequence = sequence;
    }
    
    public void incrementSequence(){
        if(sequence == Integer.MAX_VALUE)
            sequence = 0;
        else
            sequence++;
    }
    
    public boolean checkSequence(int sequence){
        return this.sequence == sequence;
    }
    
    public boolean checkConnection(InetAddress sourceIP, int sourcePort){
        return sourceIP == ip && sourcePort == port;
    }
}
