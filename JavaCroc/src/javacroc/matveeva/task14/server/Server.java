package javacroc.matveeva.task14.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 5555;
    private static final List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    synchronized static void broadcastMessage(String message, ClientHandler sender) {
        Iterator<ClientHandler> iterator = clients.iterator();
        while (iterator.hasNext()) {
            ClientHandler client = iterator.next();
            if (client != sender) {
                client.sendMessage(message);
            } else if (!client.isClientConnected()) {
                iterator.remove(); // Удаляем отключенного клиента из списка
            }
        }
    }
}
