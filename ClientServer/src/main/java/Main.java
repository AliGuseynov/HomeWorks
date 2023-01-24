import models.Client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){




//        send_requests();


        try {
            sendImage();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void send_requests(){
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

    private static void sendImage() throws IOException {
//
//        FileReader fr=new FileReader("files\\java.png");
//        BufferedWriter writer = new BufferedWriter(new FileWriter("files\\javaOut.png"));
//
//
//        BufferedReader br=new BufferedReader(fr);
//
//        String input = null;
//
//        int i;
//        while((i=br.read())!=-1){
//            writer.write((char)i);
//
//            input = input + (char)i;
////            System.out.print((char)i);
//        }
//        br.close();
//        writer.close();
//        fr.close();
//
//        System.out.println(input);

        FileInputStream fis = new FileInputStream("files\\java.png");
        BufferedWriter writer = new BufferedWriter(new FileWriter("files\\javaOut.png"));


        byte[] buffer = new byte[1024];

        int remaining = buffer.length;

        int blockNumber = 1;


        while (true) {
            int read = fis.read(buffer, buffer.length - remaining, remaining);
            if (read >= 0) {
                remaining -= read;
                if (remaining == 0) { // the buffer is full
                    System.out.println(buffer);
//                    writeBlock(blockNumber, buffer, buffer.length - remaining);
                    blockNumber++;
                    remaining = buffer.length;
                }
            }
            else {
                // the end of the file was reached. If some bytes are in the buffer
                // they are written to the last output file
                if (remaining < buffer.length) {
                    System.out.println(buffer);
//                    writeBlock(blockNumber, buffer, buffer.length - remaining);
                }
                break;
            }
        }

        fis.close();
    }




}
