package ru.gb.jtwo.lone.online.lessonsix;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8181);
             Socket currentClient = serverSocket.accept()) {
            System.out.println("К нам подключился клиент!");
            DataInputStream in = new DataInputStream(currentClient.getInputStream());
            DataOutputStream out = new DataOutputStream(currentClient.getOutputStream());
            String b = in.readUTF();
            out.writeUTF("Echo: " + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}