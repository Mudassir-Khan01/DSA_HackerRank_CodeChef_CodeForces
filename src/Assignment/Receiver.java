package Assignment;

import java.net.*;
public class Receiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9876);
        int expectedSeqNum = 0;
        while (true) {
            DatagramPacket packet = new DatagramPacket(new byte[1], 1);
            socket.receive(packet);
            int seqNum = packet.getData()[0];
            if (seqNum == expectedSeqNum) {
                System.out.println("Received: " + seqNum);
                DatagramPacket ackPacket = new DatagramPacket(new byte[] { (byte) seqNum }, 1, packet.getAddress(), packet.getPort());
                socket.send(ackPacket);
                expectedSeqNum++;
            }
        }
    }
}
