import java.util.List;

public class VisitableList extends Visitable {
    public VisitableList(Object[] elements) {
        this.elements=elements;
    }

    @Override
    void accept(Visitor visitor) {
        for(Object o:elements){
            visitor.visit(o);
        }
    }
}
