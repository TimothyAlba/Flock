/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import chat.NetworkAdapter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.UnknownHostException;
/**
 *
 * @author up6071fd
 */
public class FlockProtocol implements NetworkAdapter{
    
    //  Header field information that includes field length and relative-offset
    //  with regards to other header fields.
    private static final int TYPE_OFFSET = 0;
    private static final int TYPE_LENGTH = 1;
    private static final int FLAG_OFFSET = TYPE_OFFSET + TYPE_LENGTH;
    private static final int FLAG_LENGTH = 1;
    private static final int SEQ_OFFSET = FLAG_OFFSET + FLAG_LENGTH;
    private static final int SEQ_LENGTH = 1;
    private static final int ACK_OFFSET = SEQ_OFFSET + SEQ_LENGTH;
    private static final int ACK_LENGTH = 1;
    private static final int CRC_OFFSET = ACK_OFFSET + ACK_LENGTH;
    private static final int CRC_LENGTH = 4;
    
    private static final int HLEN = TYPE_LENGTH + FLAG_LENGTH + SEQ_LENGTH +
            ACK_LENGTH + CRC_LENGTH;
    private static final int PAYLOAD_MAX_SIZE = 4096 - HLEN;
    
    
    
    public FlockProtocol(){
        
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
}
