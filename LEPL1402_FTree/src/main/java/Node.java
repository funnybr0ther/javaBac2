public class Node<A> extends FTree<A> {

    public Node(final A a, FTree<A> left,  FTree<A> right){
        this.value = a;
        this.left = left;
        this.right = right;
    }

    @Override
    public A value() {
        return value;
    }

    @Override
    public FTree<A> left() {
        return left;
    }

    @Override
    public FTree<A> right() {
        return right;
    }
    //TODO by student

}
