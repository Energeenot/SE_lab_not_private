import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 4004);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            System.out.println("Как вас зовут? :");
            String username = reader.readLine();
            out.write(username + "\n");
            out.flush();
            String serverWord = in.readLine();
            System.out.println(serverWord);
            String word;
            while(true){
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
                    break;
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