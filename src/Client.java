import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            clientSocket = new Socket("localhost", 4004);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            System.out.println("Как вас зовут? :");
            String username = reader.readLine();
            out.write(username + "\n");
            out.flush();
            String serverWord = in.readLine();
            System.out.println(serverWord);

            System.out.println("Введите х");
            String variable = reader.readLine();
            out.write(variable + "\n");
            out.flush();
            serverWord = in.readLine();
            System.out.println(serverWord);

            System.out.println("Введите y");
            variable = reader.readLine();
            out.write(variable + "\n");
            out.flush();
            serverWord = in.readLine();
            System.out.println(serverWord);
            System.out.println(in.readLine());

            in.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}