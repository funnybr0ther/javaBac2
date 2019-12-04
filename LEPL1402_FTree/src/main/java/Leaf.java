
public class Leaf<A> extends FTree<A> {
    public Leaf(A a){
        value = a;
    }

    @Override
    public A value() {
        return value;
    }

    @Override
    public FTree<A> left() {
        return null;
    }

    @Override
    public FTree<A> right() {
        return null;
    }
    //TODO by student
}
