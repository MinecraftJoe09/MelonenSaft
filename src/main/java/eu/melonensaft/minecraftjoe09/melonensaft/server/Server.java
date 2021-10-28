package eu.melonensaft.minecraftjoe09.melonensaft.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private static ServerSocket serverSocket = null;
    private static int port = 25565;

    public static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(getPort());
            setServer(serverSocket);
            Thread thread = new Thread(new WaitForConnection());
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        if (getServer() != null) {
            try {
                getServer().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ServerSocket getServer() {
        return serverSocket;
    }

    public static void setServer(ServerSocket server) {
        Server.serverSocket = server;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Server.port = port;
    }
}
