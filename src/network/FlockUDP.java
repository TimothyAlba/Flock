/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import chat.NetworkAdapter;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.net.DatagramSocket;
import java.net.UnknownHostException;
/**
 *
 * @author up6071fd
 */
public class FlockUDP implements NetworkAdapter, Runnable{
    
    
    private final ConnectionManager connections;
    private ArrayList<DatagramPacket> sendQueue;
    
    public FlockUDP(){
        connections = new ConnectionManager();
        sendQueue = new ArrayList<>();
    }
    
    @Override
    public void sendTextMessage(String message){
        
    }
    
    @Override
    public void connect(String ipv4Address, int port){
        
    }
    
    @Override
    public void disconnect(){
        
    }
    
    @Override
    public void run(){
        
    }
}
