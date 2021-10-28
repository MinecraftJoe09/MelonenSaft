package eu.melonensaft.minecraftjoe09.melonensaft.server;

import eu.melonensaft.minecraftjoe09.melonensaft.clients.Client;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.Utils;

import java.io.IOException;
import java.net.Socket;

public class WaitForConnection extends Thread {

    public void run() {
        while (!Server.getServer().isClosed()) {
            try {
                Socket socket = Server.getServer().accept();
                Client client = new Client(socket);
                Utils.linkedList.add(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
