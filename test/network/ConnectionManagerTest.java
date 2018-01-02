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
 * @author Tim
 */
public class ConnectionManagerTest {
    
    public ConnectionManager connManager;
    public InetAddress goodIP;
    public int goodPort;
    public int goodSequence;
    public InetAddress badIP;
    public int badPort;
    
    public ConnectionManagerTest() {
        connManager = new ConnectionManager();
        
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
        goodPort = (int)(Math.random() * 5000);
        badPort = (int)(Math.random() * 5000);
        goodSequence = (int)(Math.random() * Integer.MAX_VALUE);
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
    
    @Test
    public void testConnectionManager(){
        if(connManager.removeConnection(badIP, badPort)){
            createErrorLog();
            fail("Removing a connection from newly instantiated "
                    + "ConnectionManager suceeded, should fail.");
        }
        if(!connManager.addConnection(goodIP, goodPort, goodSequence)){
            createErrorLog();
            fail("Adding a connection to newly instantiated "
                    + "ConnectionManager failed, should suceed.");
        }
        if(connManager.addConnection(goodIP, goodPort, goodSequence)){
            createErrorLog();
            fail("Duplicate Peer was added to ConnectionManager, "
                    + "no duplicates should be added.");
        }
        if(connManager.removeConnection(badIP, badPort)){
            createErrorLog();
            fail("A Peer was removed that shouldn't have existed "
                    + "in ConnectionManager.");
        }
        if(!connManager.removeConnection(goodIP, goodPort)){
            createErrorLog();
            fail("Failed to remove a Peer that should exists in "
                    + "ConnectionManager.");
        }
    }
    
    private void createErrorLog(){
        System.out.println(String.format("%n======================="
                + "%n==     Test Data     =="
                + "%n======================="
                + "%nGood --> IP: %-15s   Port: %-5d   Sequence: %d"
                + "%nBad  --> IP: %-15s   Port: %-5d",
                goodIP.getHostAddress(), goodPort, goodSequence,
                badIP.getHostAddress(), badPort));
    }
}
