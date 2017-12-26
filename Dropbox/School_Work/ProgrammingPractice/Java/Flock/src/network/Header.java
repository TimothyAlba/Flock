/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author up6071fd
 */
public class Header extends FlockProtocol{
    
    private static Header instance = null;
    
    protected Header(){
        //  Blocked Constructor
    }
    
    public static Header getInstance(){
        if(instance == null)
            instance = new Header();
        return instance;
    }
    
    public void process(byte [] packet){
         
    }
}
