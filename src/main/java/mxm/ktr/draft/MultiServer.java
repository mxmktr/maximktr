package mxm.ktr.draft;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by steve on 10/20/15.
 */
public class MultiServer {

    private static final int PORT = 9999;

    public static void main(String[] args) {

        boolean listening = true;
        ServerSocket serverSocket = null;
        MultiServerThread thread = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (listening){
                Socket socket = serverSocket.accept();
                String clientHost = socket.getInetAddress().getHostAddress();
                thread = new MultiServerThread(socket, clientHost);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Could not listen on port " + PORT);
            System.exit(-1);
        }
    }
}
