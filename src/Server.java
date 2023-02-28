import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
    static Socket clientSocket;
    static BufferedReader in;
    static BufferedWriter out;
    static String username;

    public static void main(String[] args){
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
                if(word.equals("bye")){
                    System.out.println("Пока " + username);
                    in.close();
                    out.flush();
                    out.close();
                    clientSocket.close();
                }
                else{
                    while(!word.equals("bye")){
                        if((word.equals("exit")) && (username.equals("admin"))){
                            out.flush();
                            in.close();
                            out.close();
                            System.out.println("Пока " + username);
                            clientSocket.close();
                            System.out.println("Сервер закрыт");
                            serverSocket.close();
                            System.exit(0);
                        }
                        else{
                            System.out.println("Получено сообщение: " + word);
                            out.write(j + " " + word + "\n");
                            out.flush();
                            j++;
                            word = in.readLine();
                        }
                    }
                    System.out.println("Пока " + username);
                    in.close();
                    out.flush();
                    out.close();
                    clientSocket.close();

                }
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }
}