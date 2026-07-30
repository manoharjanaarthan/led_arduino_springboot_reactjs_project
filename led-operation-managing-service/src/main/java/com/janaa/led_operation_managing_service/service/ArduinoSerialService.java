package com.janaa.led_operation_managing_service.service;

import com.fazecast.jSerialComm.SerialPort;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.OutputStream;

@Service
public class ArduinoSerialService {

    private SerialPort serialPort;

    @PostConstruct
    public void initialize() {
        serialPort = SerialPort.getCommPort("/dev/cu.usbserial-1130");
        serialPort.setBaudRate(9600);
        serialPort.openPort();
    }

    public void sendCommand(String command) {

        try {
            OutputStream outputStream = serialPort.getOutputStream();
            outputStream.write((command + "\n").getBytes());
            outputStream.flush();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}