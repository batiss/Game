
package SRC_Game;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("", 1234);
            Scanner in = new Scanner(client.getInputStream());
            Scanner inUser = new Scanner(System.in);
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            System.out.println(in.nextLine());

            while (true) {
                System.out.println("Escolha: ");
                out.println(inUser.nextLine());
                System.out.println(in.nextLine());
            }
        } catch (IOException e) {
             System.out.println("CONNECTION ERROR" + e);
        }
    }
}