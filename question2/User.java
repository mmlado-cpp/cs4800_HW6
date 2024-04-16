package question2;

import java.util.Iterator;

public class User implements IterableByUser {
    private String username;
    private ChatServer server;
    private ChatHistory history = new ChatHistory();

    public User(String username, ChatServer server) {
        this.username = username;
        this.server = server;
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return history.iterator(userToSearchWith);
    }

    public void sendMessage(String recipient, String content) {
        server.sendMessage(new Message(username, recipient, content));
    }

    public void receiveMessage(Message message) {
        history.addMessage(message);
        System.out.println("[" + username + "] Received msg from " + message.getSender() + ": " + message.getContent());
    }

    public void blockUser(String username) {
        server.blockUser(this.username, username);
    }

    public String getUsername() {
        return username;
    }

    public ChatHistory getHistory() {
        return history;
    }
}

