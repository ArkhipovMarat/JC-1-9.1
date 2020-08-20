import java.io.*;
import java.net.Socket;

public class Client {
    public static final int PORT = 8080;
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        clientSocket = new Socket("localhost", PORT);
        reader = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        System.out.println("Сообщение для сервера: ");
        String clientWord = reader.readLine();

        out.write(clientWord + "\n");
        out.flush();

        String serverWord = in.readLine();
        System.out.println("Ответ с сервера: " + serverWord);

        clientSocket.close();
        reader.close();
        in.close();
        out.close();
    }
}
