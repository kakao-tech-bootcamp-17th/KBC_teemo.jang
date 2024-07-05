import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udp_server {
    //UDP Server
    public static void main(String[] args) {
        int port = 12345;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("UDP 서버가 포트 " + port + "에서 시작되었습니다.");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("클라이언트로부터 받은 메시지: " + message);

                String response = "서버에서 받은 메시지: " + message;
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
