package question1;
import java.time.LocalDateTime;

public class Message {
    private String sender;
    private String recipient;
    private LocalDateTime timestamp;
    private String content;

    public Message(String sender, String recipient, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }
}
