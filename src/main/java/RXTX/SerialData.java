/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RXTX;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Volteo
 */
public class SerialData {

    public void getOutputStream() {
        SerialPort comPort = SerialPort.getCommPorts()[0];
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        OutputStream out = comPort.getOutputStream();
        try {
            for (int j = 0; j < 1000; ++j) {
                String message = new String("Sudhir");
                out.write(message.getBytes());
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        comPort.closePort();
    }

    public void getInputStream() {
        SerialPort comPort = SerialPort.getCommPorts()[1];
        comPort.openPort();
        comPort.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                    return;
                }
                byte[] newData = new byte[comPort.bytesAvailable()];
                int numRead = comPort.readBytes(newData, newData.length);
                System.out.print("Received " + numRead + " bytes.");
                System.out.println("Data is" + newData.toString());
            }
        });
    }
}
