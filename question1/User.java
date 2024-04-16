package question1;
public class User {
    private String username;
    private ChatServer server;
    private ChatHistory history = new ChatHistory();

    public User(String username, ChatServer server) {
        this.username = username;
        this.server = server;
    }

    public void sendMessage(String recipient, String content) {
        server.sendMessage(new Message(username, recipient, content));
    }

    public void receiveMessage(Message message) {
        System.out.println("[" + username + "] Recieved msg from " + message.getSender() + ": " + message.getContent());
    }

    public void undoLastMessage() {
        server.undoMessage(this);
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
