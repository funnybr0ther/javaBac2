public class Cons {
    // the item inside this list node
    public int v;
    // The next element, null if nothing
    public Cons next;
    // creates a new Cons that applies function f on all elements
    public Cons map(F f) {
        Cons n = this;
        Cons cons = new Cons(v,null);
        cons.next = n.next;
        Cons kans = cons;
        while(cons!=null){

            cons.v = f.apply(cons.v);
            cons = cons.next;
        }
        return kans;
    }
    // creates a new Cons with all elements that matches predicate p
    public Cons filter(P p) {
        Cons n = this.next;
        Cons cons = null;
        Cons kans = null;
        if(p.filter(this.v)){
            cons = new Cons(v,null);
            kans = cons;
        }

        while(n!=null){
        if (p.filter(n.v)){
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

    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }
}