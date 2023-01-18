import models.Client;

import java.io.IOException;

public class Main {
    public static void main(String[] args){


        Client client = new Client();

        try {
            client.startConnection("127.0.0.1", 6666);
            System.out.println(client.sendMessage("Hello"));
            System.out.println(client.sendMessage(" "));
            System.out.println(client.sendMessage("World"));
            System.out.println(client.sendMessage("!"));
        } catch (IOException e) {
            System.out.println("Connection error");
        }

        try {
            System.out.println(client.sendMessage("\nSecond"));
            System.out.println(client.sendMessage("test"));
            Thread.sleep(100);
            System.out.println(client.sendMessage("123"));
            System.out.println(client.sendMessage("!"));
        } catch (IOException | InterruptedException e) {
            System.out.println("Connection error");
        }



    }
}
