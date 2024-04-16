package question2;

import java.util.Iterator;

public interface IterableByUser {
    Iterator<Message> iterator(User userToSearchWith);
}

