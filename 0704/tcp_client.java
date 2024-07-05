import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class tcp_client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = "안녕하세요, TCP 서버!";
            out.println(message);

            String response = in.readLine();
            System.out.println("TCP 서버로부터 받은 메시지: " + response);
        } catch (UnknownHostException e) {
            System.err.println("알 수 없는 호스트: " + hostname);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}

