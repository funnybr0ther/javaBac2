import java.util.LinkedList;

public class MyStack<E> {


    private LinkedList<E> queue;

    /*
     * Constructor
     */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /*
    * push an element at top (remember, a stack is "Last In First Out")
    */
    public void push(E elem) {
        queue.add(elem);
    }

    /*
    * Return the top of the stack AND remove the retrieved element
    */
    public E pop() {
        return queue.remove(queue.size()-1);
    }

    /*
    * Return the top element of the stack, without removing it
    */
    public E peek() {
        if (queue.size()==1){
            return queue.peek();
        }
        E prev = queue.remove(queue.size()-1);
        queue.add(queue.size()-1,prev);
        return prev;
    }

    /*
    * Tells if the stack is empty or not
    */
    public boolean empty() {
     return queue.size()==0;
    }

    public static void main(String[] args) {
        MyStack a = new MyStack<>();
        a.push(4);
        System.out.println(a.peek());
        System.out.println(a.empty());
    }

}
