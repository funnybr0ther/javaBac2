import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class FList<A> implements Iterable<A> {
    FList t = this;
    public static <A> FList<A> nil() {
        return (Nil<A>) Nil.INSTANCE;
    }

    /**
     * Creates a new list with a prepended to this list
     */
    public final FList<A> cons(final A a) {
        return new Cons(a, this);
    }

    /**
     * @return the number of elements in the list
     */
    public abstract int length();

    /**
     * @return true if the list is empty, false otherwise
     */
    public abstract boolean isEmpty();

    /**
     * @return the head of the list.
     * Throws NoSuchElementException if the list is empty
     */
    public abstract A head();

    /**
     * @return the tail of the list (i.e. the sublist without the first element of this list)
     * Throws NoSuchElementException if the list is empty
     */
    public abstract FList<A> tail();

    /**
     * Returns a new list with the output of the function f applied to each element of this list
     */
    public abstract <B> FList<B> map(Function<A,B> f);

    /**
     * Creates a new list with only the element that fullfill the predicate f (i.e. f(elem) == true).
     */
    public abstract FList<A> filter(Predicate<A> f);


    public Iterator<A> iterator() {
        return new Iterator<A>() {
            FList elem = t;
            public boolean hasNext() {
                return (elem instanceof Cons);
            }

            public A next() {
                if (elem instanceof Cons){
                    A val = (A) ((Cons) elem).value;
                    elem = ((Cons) elem).next;
                    return val;
                }
                else{
                    throw new NoSuchElementException();
                }
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    private static final class Nil<A> extends FList<A> {
        public static final Nil<Object> INSTANCE = new Nil();

        @Override
        public int length() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public A head() {
            throw new NoSuchElementException();
        }

        @Override
        public FList<A> tail(){
            throw new NoSuchElementException();
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            return (FList<B>) INSTANCE;
        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            return (FList<A>) INSTANCE;
        }
    }

    private static final class Cons<A> extends FList<A> {
        FList next;
        A value;
        public Cons(A a, FList<A> as) {
            next = as;
            value = a;
        }

        @Override
        public int length() {
            return 1 + next.length();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public A head() {
            return this.value;
        }

        @Override
        public FList<A> tail() {
            return this.next;
        }

        @Override
        public <B> FList<B> map(Function<A, B> f) {
            return new FList.Cons<B>(f.apply(this.value),this.next.map(f));
        }

        @Override
        public FList<A> filter(Predicate<A> f) {
            if(f.test(value)){
                return new FList.Cons<A>(this.value,this.next.filter(f));
            }
            else{
                return this.next.filter(f);
            }
        }
    }

}