package util;

public class SimpleQueue <T> extends SimpleLinkedList<T> {

    public void add(T value) {
        this.addLast(value);
    }

    public T remove() throws Exception {
        T result = this.element();
        this.removeFirst();
        return result;
    }

    public T element() throws Exception {
        if (this.empty()) {
            throw new Exception("SimpleQueue is empty");
        }
        return this.getFirst();
    }

    public int count() {
        return this.size();
    }

    public boolean empty() {
        return this.count() == 0;
    }
}