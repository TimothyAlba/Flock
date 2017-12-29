/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

/**
 *
 * @author up6071fd
 */
public interface NetworkAdapter {
    
    public static final int MESSAGE = 0;
    public static final int CONNECT = 1;
    public static final int DISCONNECT = 2;
    
    public void sendTextMessage(String message);
    
    public void connect(String ipv4Address, int port);
    
    public void disconnect();
}
