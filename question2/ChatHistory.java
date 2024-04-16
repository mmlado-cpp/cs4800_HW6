package question2;

import java.util.*;

public class ChatHistory implements IterableByUser {
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

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return new SearchMessagesByUser(messages, userToSearchWith);
    }
}

