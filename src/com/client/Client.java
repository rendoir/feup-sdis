package com.client;

import java.io.IOException;
import java.net.*;

public class Client {
    static int PORT = 5000;

    private InetAddress address;
    private byte[] dataBuffer;

    private DatagramSocket socket;
    private DatagramPacket packet;

    public Client(String hostname, String data) throws IOException {
        this.setHostname(hostname);
        this.setData(data);
        try{
            socket = new DatagramSocket(PORT, address);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.createPackage();
        socket.send(packet);
    }

    private void setHostname(String hostname){
        try {
            address = InetAddress.getByName(hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private void setData(String data) {
        dataBuffer = data.getBytes();
    }

    private void createPackage(){
        this.packet = new DatagramPacket(dataBuffer, dataBuffer.length, address, PORT);
    }
}
