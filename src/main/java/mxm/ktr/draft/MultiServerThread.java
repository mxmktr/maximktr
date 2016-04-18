package mxm.ktr.draft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiServerThread extends Thread{

    private Socket client;
    private String clientHost;

    public MultiServerThread(Socket socket, String clientHost){
        client = socket;
        this.clientHost = clientHost;
    }

    @Override
    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            while (true) {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String mesFromClient = in.readLine();

                if (mesFromClient.equalsIgnoreCase("bye") || mesFromClient.equalsIgnoreCase("exit")){
                    System.out.println("::: " + clientHost + ": " + mesFromClient);
                    break;
                }
                System.out.println("::: " + clientHost + ": " + mesFromClient);

                System.out.println("Input information for " + clientHost + "...");
                String mesToClient = new BufferedReader(new InputStreamReader(System.in)).readLine();

                out = new PrintWriter(client.getOutputStream(), true);
                out.println(mesToClient);
//                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
