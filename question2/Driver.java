package question2;

import java.util.Iterator;

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
        saul.sendMessage("walter", "Hey walter, answer my calls");
        walter.sendMessage("saul", "I better call saul");
        saul.sendMessage("walter", "Hey walter, I think we broke bad");

        // Let's iterate over messages by Bob in Alice's history
        Iterator<Message> history = walter.iterator(saul);
        while (history.hasNext()) {
            Message msg = history.next();
            System.out.println("Iterated message from/to Bob: " + msg.getContent());
        }
    }
}
