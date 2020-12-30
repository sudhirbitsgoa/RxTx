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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        // new ListAvailablePorts().list();
        new SerialData().getInputStream();

        new SerialData().getOutputStream();
        // connects to the port which name (e.g. COM1) is in the first argument  
        // new RS232Example().connect("COM1");  
          
        // send HELO message through serial port using protocol implementation  
        // CommPortSender.send(new ProtocolImpl().getMessage("HELO"));
    }
    
}
