package javacroc.matveeva.task14.server;

import java.io.*;
import java.net.*;

class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public ClientHandler(Socket socket) throws IOException {

        this.clientSocket = socket;
        this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.writer = new PrintWriter(clientSocket.getOutputStream(), true);

    }

    @Override
    public void run() {
        try {
            String clientName = reader.readLine();
            while (true) {
                String clientMessage = reader.readLine();
                if (clientMessage == null) {
                    break;
                }
                System.out.println(clientName + ": " + clientMessage);
                Server.broadcastMessage(clientName + ": " + clientMessage, this);
            }
        } catch (IOException e) {
            System.err.println("Client disconnected: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public boolean isClientConnected() {
        return !clientSocket.isClosed();
    }

    public void sendMessage(String message) {
        writer.println(message);
    }
}
