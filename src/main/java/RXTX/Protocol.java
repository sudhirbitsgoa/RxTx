/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RXTX;

/**
 *
 * @author Volteo
 */
public interface Protocol {  
      
    // protocol manager handles each received byte  
    void onReceive(byte b);  
      
    // protocol manager handles broken stream  
    void onStreamClosed();  
}  
