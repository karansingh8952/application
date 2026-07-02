


# 💬 Java Client-Server Chat Application

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![Socket](https://img.shields.io/badge/Networking-TCP%20Sockets-green)
![License](https://img.shields.io/badge/License-MIT-red)

A simple **Java Client-Server Chat Application** built using **Java Swing** and **Socket Programming**. The application allows real-time communication between a server and a client over a TCP connection.

---

## 📖 Project Overview

This project demonstrates the fundamentals of **Java Networking** using TCP sockets. It consists of two desktop applications:

- **ChatServer** – Starts the server and waits for a client connection.
- **ChatClient** – Connects to the server and exchanges messages.

The graphical user interface is created using **Java Swing**, and networking is implemented using Java's **Socket** and **ServerSocket** classes.

---

## 🚀 Features

- Real-time chat
- Java Swing GUI
- TCP Socket Programming
- Simple and clean interface
- Multi-threaded message receiving
- Automatic connection handling
- Beginner-friendly project
- Easy to modify and extend

---

## 🛠 Technologies Used

- Java
- Java Swing
- Socket Programming
- TCP/IP
- BufferedReader
- PrintWriter
- Multithreading

---

## 📂 Project Structure

```
ChatApplication/
│
├── ChatApp/
│   ├── ChatServer.java
│   └── ChatClient.java
│
├── screenshots/
│   ├── server.png
│   ├── client.png
│   ├── chatting.png
│   └── architecture.png
│
├── README.md
└── LICENSE
```

---

## ⚙️ How It Works

1. Start the server.
2. The server waits for a client.
3. Start the client.
4. The client connects to the server.
5. Both users can send and receive messages.
6. Closing either application closes the connection.

---

## 🏗 Architecture

```
        +---------------------+
        |     Chat Server     |
        |---------------------|
        |  ServerSocket       |
        |  Socket             |
        |  BufferedReader     |
        |  PrintWriter        |
        +----------+----------+
                   |
             TCP Connection
                   |
        +----------+----------+
        |      Chat Client    |
        |---------------------|
        |  Socket             |
        |  BufferedReader     |
        |  PrintWriter        |
        +---------------------+
```

---

## ▶️ Installation

### Clone Repository

```bash
git clone https://github.com/karansingh8952/application/tree/main/ChatApplication
```

---

## Open Project

Open the project using:

- IntelliJ IDEA
- Eclipse
- NetBeans
- VS Code

---

## Compile

```bash
javac ChatApp/*.java
```

---

## Run Server

```bash
java ChatApp.ChatServer
```

---

## Run Client

```bash
java ChatApp.ChatClient
```

---

## 🖼 Screenshots

### Server
<img width="617" height="507" alt="server png" src="https://github.com/user-attachments/assets/0466bcf2-d1d5-4df8-b711-302ed1f4d6a3" />


### Client
<img width="623" height="507" alt="client png" src="https://github.com/user-attachments/assets/9c7cda55-a43a-4533-8513-f896e2200aa0" />


### Architecture Real Image
<img width="1358" height="905" alt="kirannn png" src="https://github.com/user-attachments/assets/b7eec763-ce19-4daa-97f0-a3efde88dda7" />

## 📚 Java Concepts Used

- Swing GUI
- JFrame
- JTextArea
- JTextField
- JScrollPane
- Socket
- ServerSocket
- BufferedReader
- PrintWriter
- InputStreamReader
- Exception Handling
- Multithreading
- Event Handling

---

## 🔄 Working Flow

```
Server Starts
      │
      ▼
Waiting for Client
      │
      ▼
Client Connects
      │
      ▼
Socket Connection Created
      │
      ▼
Input & Output Streams Created
      │
      ▼
Messages Sent & Received
      │
      ▼
Connection Closed
```

---


## 👨‍💻 Author

**Karan Singh Kushwaha**

**B.Tech – Information Technology**

Arya College of Engineering & IT, Kukas

---

## ⭐ Support

If you found this project helpful, please ⭐ the repository and share it with others.
