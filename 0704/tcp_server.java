import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp_server {
    // TCP Server
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP 서버가 포트 " + port + "에서 시작되었습니다.");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("클라이언트가 연결되었습니다: " + clientSocket.getInetAddress());

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    String message = in.readLine();
                    System.out.println("클라이언트로부터 받은 메시지: " + message);

                    out.println("서버에서 받은 메시지: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
