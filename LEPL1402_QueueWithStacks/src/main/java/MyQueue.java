import java.util.Stack;

public class MyQueue<E> {

    Stack<E> s1;
    Stack<E> s2;

    private E front;

    /*
     * Constructor
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        this.front = null;
    }

    public void enqueue(E elem) {
        s1.push(elem);
    }

    public E dequeue() {
      return s1.remove(0);
    }

    public E peek() {
      return s1.get(0);
    }

    public boolean empty() {
      return s1.empty();
    }

}
