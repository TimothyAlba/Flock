/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author up6071fd
 */
public abstract class NetworkAdapter {
    
    public static final int MESSAGE = 0;
    public static final int CONNECT = 1;
    public static final int DISCONNECT = 2;
    
    //  Type Details: MESSAGE
    public static final int CHAT_ROOM_NUMBER_OFFSET = 0;
    public static final int CHAT_ROOM_NUMBER_LENGTH = 1;
    public static final int CHAT_ROOM_MESSAGE_OFFSET = CHAT_ROOM_NUMBER_OFFSET +
            CHAT_ROOM_NUMBER_LENGTH;
    
    //  Type Details: CONNECT
    public static final int PEER_PORT_OFFSET = 0;
    public static final int PEER_PORT_LENGTH = 2;
    public static final int PEER_IP_OFFSET = PEER_PORT_OFFSET + PEER_PORT_LENGTH;
    public static final int PEER_IP_LENGTH = 4;
    
    private ArrayList<byte []> payloadQueue;
    private final Object queueLock;
    
    public NetworkAdapter(){
        payloadQueue = new ArrayList<>();
        queueLock = new Object();
    }
    
    public abstract void sendTextMessage(String message);
    
    public abstract void connect(String ipv4Address, int port);
    
    public abstract void disconnect();
    
    public boolean enqueueNewData(int type, byte [] data){
        switch(type){
            case MESSAGE:{
                data = appendType(type, data);
                synchronized(queueLock){
                    payloadQueue.add(data);
                }
                return true;
            }
            case CONNECT:{
                data = appendType(type, data);
                synchronized(queueLock){
                    payloadQueue.add(data);
                }
                return true;
            }
            case DISCONNECT:{
                data = appendType(type, data);
                synchronized(queueLock){
                    payloadQueue.add(data);
                }
                return true;
            }
        }
        return false;
    }
    
    public byte [] dequeueData(){
        if(payloadQueue.isEmpty())
            return null;
        return payloadQueue.remove(0);
    }
    
    private byte [] appendType(int type, byte [] data){
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = (byte)type;
        return data;
    }
}
