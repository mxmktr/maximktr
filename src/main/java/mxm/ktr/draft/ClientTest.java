package mxm.ktr.draft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {

    private static final String HOST = "127.0.0.1";
//    private static final String HOST = "10.30.0.4";
    private static final int PORT = 9999;

    public static void main(String[] args) {

        Socket server = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            InetAddress inetAddress = InetAddress.getByName(HOST);
            server = new Socket(inetAddress, PORT);
            while (true) {
                System.out.println("Input information for server...(bye or exit for exit:))");
                String mesToServer = new BufferedReader(new InputStreamReader(System.in)).readLine();

                out = new PrintWriter(server.getOutputStream(), true);
                out.println(mesToServer);
//                out.flush();

                in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                String mesFromServer = in.readLine();
                if (mesFromServer == null)
                    break;
                System.out.println(":::Server: " + mesFromServer);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
