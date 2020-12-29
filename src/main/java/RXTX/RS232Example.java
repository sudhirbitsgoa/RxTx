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
import gnu.io.SerialPort;  
   
public class RS232Example {  
     
    public void connect(String portName) throws Exception {  
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);  
   
        if (portIdentifier.isCurrentlyOwned()) {  
            System.out.println("Port in use!");  
        } else {  
            // points who owns the port and connection timeout  
            SerialPort serialPort = (SerialPort) portIdentifier.open("RS232Example", 2000);  
              
            // setup connection parameters  
            serialPort.setSerialPortParams(  
                38400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);  
   
            // setup serial port writer  
            CommPortSender.setWriterStream(serialPort.getOutputStream());  
              
            // setup serial port reader  
            new CommPortReceiver(serialPort.getInputStream()).start();  
        }  
    }  
}  
