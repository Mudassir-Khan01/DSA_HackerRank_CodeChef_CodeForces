package Assignment;

import java.net.*;
public class Sender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress receiverAddress = InetAddress.getByName("localhost");
        int receiverPort = 9876;
        int windowSize = 4;
        byte[] data = "Hello, Sliding Window!".getBytes();
        int base = 0;
        while (base < data.length) {
            for (int i = base; i < base + windowSize && i < data.length; i++) {
                DatagramPacket packet = new DatagramPacket(data, i, 1, receiverAddress, receiverPort);
                socket.send(packet);
            }
            DatagramPacket ackPacket = new DatagramPacket(new byte[1], 1);
            socket.receive(ackPacket);
            int ack = ackPacket.getData()[0];
            if (ack >= base) {
                base = ack + 1;
            }
        }
        socket.close();
    }
}