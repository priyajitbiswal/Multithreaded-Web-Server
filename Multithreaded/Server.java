import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {
    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try (BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true)) {
                String clientMessage = fromClient.readLine();
                System.out.println("Received from Client: " + clientMessage);
                toClient.println("Hello from server " + clientSocket.getInetAddress());
                toClient.close();
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(20000);
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket acceptedSocket = serverSocket.accept();

                // Create and start a new thread for each client
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
