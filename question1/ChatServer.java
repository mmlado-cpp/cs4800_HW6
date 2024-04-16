package question1;
import java.util.*;

public class ChatServer {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Set<String>> blockList = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getUsername(), user);
        blockList.put(user.getUsername(), new HashSet<>());
    }

    public void unregisterUser(User user) {
        users.remove(user.getUsername());
        blockList.remove(user.getUsername());
    }

    public void sendMessage(Message message) {
        if (blockList.get(message.getRecipient()).contains(message.getSender())) {
            System.out.println("Message blocked from " + message.getSender() + " to " + message.getRecipient());
            return;
        }
        if (users.containsKey(message.getRecipient())) {
            users.get(message.getRecipient()).receiveMessage(message);
            users.get(message.getSender()).getHistory().addMessage(message);
        }
    }

    public void undoMessage(User user) {
        Message lastMessage = user.getHistory().getLastMessage();
        if (lastMessage != null) {
            System.out.println("[" + user.getUsername() + "] Undo last message: " + lastMessage.getContent());
        } else {
            System.out.println("[" + user.getUsername() + "] No message to undo.");
        }
    }

    public void blockUser(String blocker, String blockee) {
        blockList.get(blocker).add(blockee);
    }
}
