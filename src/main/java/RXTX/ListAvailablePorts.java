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
import gnu.io.CommPortIdentifier;  
   
import java.util.Enumeration;  
   
public class ListAvailablePorts {  
   
    public void list() {  
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();  
          
        while(ports.hasMoreElements())  
            System.out.println(((CommPortIdentifier)ports.nextElement()).getName());  
    }
}  
