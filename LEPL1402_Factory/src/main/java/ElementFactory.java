
public class ElementFactory extends Factory{
    private static final ElementFactory eF = new ElementFactory();
    private ElementFactory(){}
    public static ElementFactory getInstance(){
        return eF;
    }
    @Override
    public LevelComponent getElement(char c) {
        return Level.getElement(c);
    }
}
