package ChatApp;

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatClient extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ChatClient() {

        setTitle("Client Side Chat Application");
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

        setVisible(true);

        connectToServer();
    }

    private void connectToServer() {

        try {

            socket = new Socket("localhost", 12345);

            out = new PrintWriter(socket.getOutputStream(), true);

            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            chatArea.append("Connected to Server\n");

            Thread receiveThread = new Thread(() -> {

                try {

                    String message;

                    while ((message = in.readLine()) != null) {

                        String msg = message;

                        SwingUtilities.invokeLater(() ->
                                chatArea.append("Server: " + msg + "\n"));
                    }

                } catch (IOException e) {

                    SwingUtilities.invokeLater(() ->
                            chatArea.append("Connection Closed.\n"));
                }

            });

            receiveThread.start();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cannot connect to Server!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    private void sendMessage() {

        String message = inputField.getText().trim();

        if (message.isEmpty())
            return;

        if (out != null) {

            out.println(message);
            chatArea.append("Karan Singh Kushwaha: " + message + "\n");

        }

        inputField.setText("");

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(ChatClient::new);

    }
}