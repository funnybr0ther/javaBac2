
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

    public abstract class FList<A> implements Iterable<A>{
        FList t = this;
        public final boolean isNotEmpty() {
            return this instanceof Cons;
        }

        public final boolean isEmpty() {
            return this instanceof Nil;
        }

        public final int length() {

        }

        public abstract A head();

        public abstract FList<A> tail();

        public static <A> FList<A> nil() {
            return (Nil<A>) Nil.INSTANCE;
        }

        public final FList<A> cons(final A a) {
            return new Cons(a, this);
        }
        public Iterator<A> iterator() {
            //CODE HIDDEN
        }

        public static final class Nil<A> extends FList<A> {
            private static  final Nil<Object> INSTANCE = new Nil();

            @Override
            public A head() {
                throw new NoSuchElementException();
            }

            @Override
            public FList<A> tail() {
                throw new NoSuchElementException();
            }



        }

        public static final class Cons<A> extends FList<A> {
            public Cons(A head,FList<A> tail) {
                this.head = head;
                this.tail = tail;
            }

            private A head;
            private FList<A> tail;

            @Override
            public A head() {
                return head;
            }

            @Override
            public FList<A> tail() {
                return tail;
            }

            //CODE HIDDEN
            
        }

    }

