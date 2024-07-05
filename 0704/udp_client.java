import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udp_client {
    //UDP Client
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "안녕하세요, UDP 서버!";
            byte[] buffer = message.getBytes();
            InetAddress address = InetAddress.getByName(hostname);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);

            byte[] responseBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("UDP 서버로부터 받은 메시지: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
