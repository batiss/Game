

package SCR_Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server esperando cenecção...");
            while (true) {
                Socket client = server.accept();
                Thread thread = new Thread(new AdventureText(client));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("CONNECTION ERROR" + e);
        }
    }
}
