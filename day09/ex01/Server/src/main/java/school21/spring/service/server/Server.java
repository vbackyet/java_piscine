package school21.spring.service.server;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.LinkedList;




public class Server {

    public static final int PORT = 8080;
    public static ArrayList<MySpecialServer> serverList = new ArrayList<>(); 

    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server Started");
        try {
            while (true) {
                // Блокируется до возникновения нового соединения:
                Socket socket = server.accept();
                try {
                    serverList.add(new MySpecialServer(socket)); // добавить новое соединенние в список
                } catch (IOException e) {
                    // Если завершится неудачей, закрывается сокет,
                    // в противном случае, нить закроет его:
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}
