import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // the item inside this list node
    public E v;
    // The next element, null if nothing
    public Cons<E> next;
    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }

    public <R> Cons <R> map(Function <E,R> function) {
        Cons n = this;
        Cons cons = new Cons(v,null);
        cons.next = n.next;
        Cons kans = cons;
        while(cons!=null){

            cons.v = function.apply((E)cons.v);
            cons = cons.next;
        }
        return kans;
    }

    public Cons <E> filter(Predicate <E> predicate){
        Cons n = this.next;
        Cons cons = null;
        Cons kans = null;
        if(predicate.test(this.v)){
            cons = new Cons(v,null);
            kans = cons;
        }

        while(n!=null){
            if (predicate.test((E)n.v)){
                if(cons == null){
                    cons = new Cons(n.v,null);
                    kans = cons;
                }
                else{
                    cons.next = new Cons(n.v,null);
                    cons=cons.next;
                }
            }
            n = n.next;
        }
        return kans;
    }
}
