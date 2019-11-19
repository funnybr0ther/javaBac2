public class Div extends Node implements Visitable {
    public Div(Visitable left, Visitable right) {
        super(left, right);
    }

    @Override
    public int accept(Visitor visitor) {
        try{
            return getLeft().accept(visitor)/getRight().accept(visitor);
        }
        catch(Exception e){
            throw new IllegalArgumentException();
        }

    }
}
