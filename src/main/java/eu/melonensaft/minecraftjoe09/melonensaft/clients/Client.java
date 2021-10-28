package eu.melonensaft.minecraftjoe09.melonensaft.clients;

import java.net.Socket;

public class Client {

    private Socket socket = null;
    private boolean isAuth = false;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }
}
