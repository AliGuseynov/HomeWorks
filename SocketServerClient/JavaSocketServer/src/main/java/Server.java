import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();

        System.out.println("client connected");

        InputStreamReader inputStreamReadernew = new InputStreamReader(socket.getInputStream());

        BufferedReader bufferedReader = new BufferedReader(inputStreamReadernew);

        String str = bufferedReader.readLine();

        System.out.println("Client:" + str);
    }
}

