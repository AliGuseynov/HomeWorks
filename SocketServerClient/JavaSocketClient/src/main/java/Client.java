import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8080);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("hi server:)");
        printWriter.flush();
    }
}
