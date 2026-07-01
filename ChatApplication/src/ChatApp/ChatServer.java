package ChatApp;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatServer extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;

    private PrintWriter out;
    private BufferedReader in;
    private ServerSocket serverSocket;
    private Socket socket;

    public ChatServer() {

        setTitle("Server Side Chat Application");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        inputField = new JTextField();
        add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(e -> sendMessage());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeConnection();
            }
        });

        setVisible(true);

        // Start server in background
        new Thread(this::startServer).start();
    }

    private void startServer() {

        try {

            serverSocket = new ServerSocket(12345);

            SwingUtilities.invokeLater(() ->
                    chatArea.append("Server started...\nWaiting for client...\n"));

            socket = serverSocket.accept();

            SwingUtilities.invokeLater(() ->
                    chatArea.append("Client Connected.\n"));

            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);

            String message;

            while ((message = in.readLine()) != null) {

                String msg = message;

                SwingUtilities.invokeLater(() ->
                        chatArea.append("Client: " + msg + "\n"));
            }

        } catch (IOException e) {

            SwingUtilities.invokeLater(() ->
                    chatArea.append("Server Error: " + e.getMessage() + "\n"));

        }
    }

    private void sendMessage() {

        String message = inputField.getText().trim();

        if (message.isEmpty())
            return;

        if (out != null) {

            out.println(message);
            chatArea.append("Server: " + message + "\n");

        } else {

            chatArea.append("No client connected.\n");

        }

        inputField.setText("");
    }

    private void closeConnection() {

        try {

            if (out != null)
                out.close();

            if (in != null)
                in.close();

            if (socket != null)
                socket.close();

            if (serverSocket != null)
                serverSocket.close();

        } catch (IOException e) {

            System.err.println(e.getMessage());

        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(ChatServer::new);

    }
}