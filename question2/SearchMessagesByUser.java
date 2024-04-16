package question2;
import java.util.*;

public class SearchMessagesByUser implements Iterator<Message> {
    private List<Message> messages;
    private User user;
    private int currentIndex = 0;

    public SearchMessagesByUser(List<Message> messages, User user) {
        this.messages = messages;
        this.user = user;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < messages.size()) {
            Message currentMessage = messages.get(currentIndex);
            if (currentMessage.getSender().equals(user.getUsername()) ||
                currentMessage.getRecipient().equals(user.getUsername())) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Message next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return messages.get(currentIndex++);
    }
}
