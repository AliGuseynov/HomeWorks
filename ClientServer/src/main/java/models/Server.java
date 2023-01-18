package models;

import javax.sound.sampled.Port;
import java.net.*;
import java.io.*;

public class Server {



    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public static void main(String[] args) {
        Server server=new Server();
        try {
            server.startServer(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer(int port) throws IOException {


        serverSocket = new ServerSocket(port);

        System.out.println("Starting server...\n");



            clientSocket = serverSocket.accept();



        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        String inputLine;

        while ((inputLine = in.readLine()) != null) {

            out.println("Server message: " + inputLine);}
    }
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}
