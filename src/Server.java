import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

    public static void main(String[] args){
        int counter = 0;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4004);
            serverSocket.setReuseAddress(true);
            System.out.println("Запустили сервер");
            while (true) {
                counter++;

                Socket clientSocket = serverSocket.accept();
                // Displaying that new client is connected
                // to server

                // create a new thread object
                ClientHandler clientSock = new ClientHandler(clientSocket, counter);

                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        static String username;
        private final Socket clientSocket;
        int counter;

        public ClientHandler(Socket socket, int counter) {
            this.clientSocket = socket;
            this.counter = counter;
        }

        public void run() {
            String countArray[] = new String[10];
            PrintWriter out = null;
            BufferedReader in = null;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line = "";
                int j = 0;
                while (line != null) {
                    j = 1;
                    line = in.readLine();
                    countArray[counter] = line;
                    System.out.println("К нам пришел " + line);
                    out.write("Привет, " + line + "\n");
                    out.flush();

                    String word = in.readLine();
                    if (word.equals("bye")) {
                        System.out.println("Пока " + countArray[counter]);
                        in.close();
                        out.flush();
                        out.close();
                        clientSocket.close();
                    } else {
                        while (!word.equals("bye")) {
                            if ((word.equals("exit")) && (countArray[counter].equals("admin"))) {
                                out.flush();
                                in.close();
                                out.close();
                                System.out.println("Пока " + countArray[counter]);
                                clientSocket.close();
                                System.out.println("Сервер закрыт");
//                                serverSocket.close();
                                System.exit(0);
                            } else {
                                System.out.println("Получено сообщение от " + countArray[counter] + ": " +  word);
                                out.write(j + " " + word + "\n");
                                out.flush();
                                j++;
                                word = in.readLine();
                            }
                        }
                        System.out.println("Пока " + countArray[counter]);
                        in.close();
                        out.flush();
                        out.close();
                        clientSocket.close();
                    }
                }
            }
            catch (IOException e) {

            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}