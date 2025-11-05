import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Labprog10 {
    public static void main(String[] args) {
        new Thread(() -> runServer()).start();

        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        runClient();
    }

    public static void runServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started... waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            while (true) {
                String msg = in.readLine();
                if (msg == null || msg.equalsIgnoreCase("exit")) break;
                System.out.println("Client: " + msg);

                System.out.print("Server: ");
                String reply = sc.nextLine();
                out.println(reply);
                if (reply.equalsIgnoreCase("exit")) break;
            }

            sc.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }

    public static void runClient() {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Client connected to server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Client: ");
                String msg = sc.nextLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("exit")) break;

                String reply = in.readLine();
                if (reply == null || reply.equalsIgnoreCase("exit")) break;
                System.out.println("Server: " + reply);
            }

            sc.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
