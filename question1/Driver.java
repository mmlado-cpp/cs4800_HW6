package question1;
public class Driver {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        User walter = new User("walter", server);
        User jesse = new User("jesse", server);
        User saul = new User("saul", server);

        server.registerUser(walter);
        server.registerUser(jesse);
        server.registerUser(saul);

        walter.sendMessage("jesse", "Hello jesse");
        jesse.sendMessage("walter", "Hi walter");
        saul.sendMessage("walter", "Hey walter");

        walter.undoLastMessage();  // Demonstrates undoing a message

        walter.blockUser("saul");  // walter blocks saul
        saul.sendMessage("walter", "walter, did you block me?");

        jesse.sendMessage("saul", "I think you should't talk to walter");
    }
}
