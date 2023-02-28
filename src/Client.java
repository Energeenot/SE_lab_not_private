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
            boolean x = true;
            String word;
            while(x){
                System.out.println("Введите слово: ");
                word = reader.readLine();
                if((username.equals("admin")) && (word.equals("exit"))){
                    out.write(word+"\n");
                    System.out.println("Пока " + username);
                    out.flush();
                    out.close();
                    in.close();
                    clientSocket.close();
                    break;
                }
                else if(word.equals("bye")){
                    out.write("bye\n");
                    out.flush();
                    System.out.println("Клиент был закрыт...");
                    x = false;
                }
                else{
                    out.write(word + "\n");
                    out.flush();
                    serverWord = in.readLine();
                    System.out.println(serverWord);
                }
            }
            clientSocket.close();
            in.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}