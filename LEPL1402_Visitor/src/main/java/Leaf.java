public class Leaf implements Visitable {
    int value;
    public Leaf(int value) {
        this.value= value;
    }

    // YOUR CODE HERE

    public int getValue() {
        return value;
    }

    @Override
    public int accept(Visitor visitor) {
        return value;
    }
}
