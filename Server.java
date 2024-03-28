import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server đã khởi động và đang chờ kết nối...");

            Socket socket = serverSocket.accept();
            System.out.println("Client đã kết nối!");

            BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            String serverMessage;

            while (true) {
                clientMessage = clientInput.readLine();
                if (clientMessage != null) {
                    System.out.println("Client: " + clientMessage);
                }

                System.out.print("Nhập tin nhắn cho client: ");
                serverMessage = serverInput.readLine();
                serverOutput.println(serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
