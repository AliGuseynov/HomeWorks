

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args)throws Exception  {

messageClient();

    }
public static void messageClient() throws IOException {
    Socket socket= new Socket("localhost",6789);
    OutputStream outputstream =socket.getOutputStream();
    DataOutputStream dataOutputStream=new DataOutputStream(outputstream);
    Scanner scanner=new Scanner(System.in);
    String clientMessage=scanner.nextLine();
    outputstream.write(clientMessage.getBytes());
    socket.close();
}
    public static void photoAsByte() throws IOException {
        Socket socket= new Socket("localhost",6789);
        OutputStream outputstream =socket.getOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(outputstream);
        byte[] bytes=FileUtility.readbytes("C:\\Users\\nihad\\Documents\\CvSekil.png");
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        socket.close();
    }
}
