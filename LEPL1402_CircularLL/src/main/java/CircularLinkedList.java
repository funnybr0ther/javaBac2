import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.Consumer;


public class CircularLinkedList<Item> implements Iterable<Item> {

    private int n;          // size of the list
    private Node last;   // trailer of the list

    // helper linked list class
    private class Node {

        private Item item;
        private Node next;

        private Node(Item item) {
            this.item = item;
            this.next = null;
        }

    }

    public CircularLinkedList() {
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Node getLast() {
        return last;
    }

    public Item getItem(Node n) {
        return n.item;
    }


    /**
     * Append an item at the end of the list
     *
     * @param item the item to append
     */
    public void enqueue(Item item) {
        if (n == 0) {

            Node newNode = new Node(item);
            this.last = newNode;
            this.n += 1;

        }
        else if(n==1){
           Node newNode = new Node(item);
           newNode.next = this.last;
           this.last.next= newNode;
           this.last = newNode;
           this.n +=1;
        }
        else {
            Node newNode = new Node(item);
            newNode.next = this.last.next;
            this.last.next = newNode;
            this.last = newNode;
            this.n += 1;
        }

    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     */
    public Item remove(int index) {
    if(index>=n){
        throw new IndexOutOfBoundsException("No");
    }
    if(n==1){
        Item it = last.item;
        last=null;
        n--;
        return it;
    }
    Node previousNode=last;
    for (int i=0;i<index;i++){
        previousNode = previousNode.next;
    }
    if(previousNode.next==last){
        Item it=previousNode.next.item;
        previousNode.next=last.next;
        last=previousNode;
        n--;
        return it;
    }
    else if(previousNode.next==previousNode){
        System.out.println("Turbofuck");
        Item it=previousNode.item;
        last=null;
        n--;
        return it;

    }
    Item it = previousNode.next.item;
    previousNode.next=previousNode.next.next;
    n--;
    return it;

    }


    /**
     * Returns an iterator that iterates through the items in FIFO order.
     *
     * @return an iterator that iterates through the items in FIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * Implementation of an iterator that iterates through the items in FIFO order.
     */
    private class ListIterator implements Iterator<Item> {
        int size=n;
        int index=0;
        Node current=null;


        @Override
        public boolean hasNext() {
            return (this.index <= this.size-1);
        }

        public Item next() {
            if (n != size) {
                System.out.println(size);
                System.out.println(n);
                throw new ConcurrentModificationException("You fucked up");
            }
            if (current == null && n == 1) {
                index += 1;
                current = last;
                return current.item;
            } else if(index==0) {
                index += 1;
                Item it = last.next.item;
                current=last.next.next;
                return it;
            }
            index+=1;
            Item it = current.item;
            current=current.next;
            return it;
        }


    }
}