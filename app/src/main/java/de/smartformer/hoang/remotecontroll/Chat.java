package de.smartformer.hoang.remotecontroll;

import android.util.Log;

import org.json.JSONObject;

import java.net.MalformedURLException;

import io.socket.IOCallback;
import io.socket.SocketIO;

public class Chat extends Thread {

    public static SocketIO socket;
    public static IOCallback callback;
    public static String chatUrl;

    public Chat(String chatUrl, IOCallback callback) {
        this.callback = callback;
        this.chatUrl = chatUrl;
    }

    public void run() {
        try {
            socket = new SocketIO(chatUrl, callback);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static boolean sendCommand(JSONObject command) {
        if (socket.isConnected()) {
            socket.emit("command", command);
            return true;
        } else {
            Log.i("Connection", "Socket is disconnected, try to reconnect");
            return false;
        }
    }
    public boolean connectController(String controllerName) {
        if (socket.isConnected()) {
            socket.emit("connectController", controllerName);
            return true;
        } else {
            Log.i("Connection", "Socket is disconnected, try to reconnect");
            return false;
        }
    }



    public void reconnectSocket() {
        try {
            socket = new SocketIO(chatUrl, callback);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}    
