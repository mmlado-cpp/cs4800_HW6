package question1;
import java.util.ArrayList;
import java.util.List;

public class ChatHistory {
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Message getLastMessage() {
        if (messages.isEmpty()) {
            return null;
        }
        return messages.get(messages.size() - 1);
    }

    public Message undoLastMessage() {
        if (messages.isEmpty()) {
            return null;
        }

        return messages.remove(messages.size() - 1);
    }
}
