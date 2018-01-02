/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author up6071fd
 */
public class PeerTest {
    
    public Peer conn;
    public InetAddress goodIP;
    public InetAddress badIP;
    public int port;
    public int sequence;
    
    public PeerTest() {
        byte [] ip = new byte [4];
        goodIP = null;
        badIP = null;
        
        while(goodIP == null || badIP == null){
            for(int i = 0; i < ip.length; i++){
                ip[i] = (byte)((int)(Math.random() * 255));
            }
            try{
                if(goodIP == null)
                    goodIP = InetAddress.getByAddress(ip);
                else
                    badIP = InetAddress.getByAddress(ip);
            }
            catch(UnknownHostException e){
                System.out.println(e);
            }
        }
        port = (int)(Math.random() * 5000);
        sequence = (int)(Math.random() * Integer.MAX_VALUE);
        
        
        conn = new Peer(goodIP, port, sequence);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testSequence(){
        if(!conn.checkSequence(sequence))
            fail("The sequence number check failed!");
    }
    
    @Test
    public void testConnection(){
        if(!conn.checkConnection(goodIP, port))
            fail("The connection information check failed!");
    }
}
