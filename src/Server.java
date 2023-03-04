import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
    static Socket clientSocket;
    static BufferedReader in;
    static BufferedWriter out;
    static String username;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j = 0;
        String word;
        try{
            ServerSocket serverSocket = new ServerSocket(4004);
            System.out.println("Запустили сервер");
            while(true){
                j = 1;
                clientSocket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                username = in.readLine();
                System.out.println("К нам пришел " + username);
                out.write("Привет, " + username + "\n");
                out.flush();

                word = in.readLine();
                int x = Integer.parseInt(word);
                System.out.println("Мы считали х = " + x);
                out.write("x = " + x + "\n");
                out.flush();

                word = in.readLine();
                int y = Integer.parseInt(word);
                System.out.println("Мы считали y = " + y);
                out.write("y = " + y + "\n");
                out.flush();
                double z = ((3*Math.pow(Math.cos(x - Math.PI/6),2.0))/0.5 + Math.sin(y)*Math.sin(y));
                System.out.println("Ответ = " + z);
                out.write("Ответ = " + z + "\n");
                out.flush();

                System.out.println("Пока " + username);
                in.close();
                out.close();
                clientSocket.close();

            }
        } catch (IOException e){
            System.err.println(e);
        }
    }
}