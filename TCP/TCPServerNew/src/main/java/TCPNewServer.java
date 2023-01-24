import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPNewServer {
    public static void main(String[] args) throws Throwable {
       messageClient();
    }
public static void  messageClient() throws IOException {
    ServerSocket outFirstServerSocket = new ServerSocket(6789);
    while (true) {
        System.out.println("yeni socket  ve ya musteri gozleyir");
        Socket connection = outFirstServerSocket.accept();
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String messageClient = reader.readLine();
        System.out.println("musterinin mesaji:"+messageClient);

    }
}
    private static void readasBytesPhoto() throws Throwable {
        ServerSocket outFirstServerSocket = new ServerSocket(6789);
        while (true) {
            System.out.println("musteri gozleyir......");
            Socket connection = outFirstServerSocket.accept();
            DataInputStream dataStream = new DataInputStream(connection.getInputStream());
            byte[] arr=readmessage(dataStream);
            System.out.println("message length2="+arr.length);
            FileUtility.writebyte("C:\\Users\\nihad\\Desktop\\niko.png",arr);
            connection.close();

        }
    }
    public static byte[] readmessage(DataInputStream din) throws Exception {
        int msglen = din.readInt();
        System.out.println("message lengt1=" + msglen);
        byte[] msg = new byte[msglen];
        din.readFully(msg);
        return msg;
    }
    private static void writeResponse(OutputStream ous, String s) throws Throwable {
        String response = "HTTP/1.1 200 OK\r\n"
                + "Server: YarServer/2009-09-09\r\n"
                + "Content-Type: text/html\r\n"
                + "Content-Length:" + s.length() + "\r\n"
                + "Connection:close\r\n\r\n";
        String result = response + s;
        ous.write(result.getBytes());
        ous.flush();

    }

    public static String readReguest(InputStream sin) throws Exception {
        InputStreamReader ist = new InputStreamReader(sin);
        BufferedReader reader = new BufferedReader(ist);
        String msg = "";
        while (true) {
            String s = reader.readLine();
            if (s == null || s.trim().length() == 0) {
                break;
            } else {
                msg = msg + s + "\r\n";
            }
            System.out.println("Server request:" + s);
            System.out.println();
        }
        return msg;
    }


}
