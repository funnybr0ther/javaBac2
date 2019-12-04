import java.util.function.Function;

public abstract class FTree<A> {
    A value;
    FTree<A> left;
    FTree<A> right;
    public final int depth() {
        FTree<A> left = left();
        FTree<A> right = right();
        int leftValue;
        int rightValue;
        if(left==null){
             leftValue = -1;
        }
        else{
             leftValue = left().depth();
        }
        if(right==null){
             rightValue = -1;
        }
        else{
             rightValue = right().depth();
        }
        if(rightValue<leftValue){
            return 1+leftValue;
        }
        else{
            return 1+rightValue;
        }
    }

    public abstract A value();
    public abstract FTree<A> left();
    public abstract FTree<A> right();

    public final <B> FTree<B> map(Function<A,B> f) {
        if (this instanceof Leaf){
            return new Leaf<>(f.apply(value()));
        }
        else{
            return new Node<>(f.apply(value()),left().map(f),right().map(f));
        }
    }

}
