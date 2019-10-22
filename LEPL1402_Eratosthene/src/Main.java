import java.util.BitSet;

public class Main {
    public static void main(String[] args){
        BitSet bits = new BitSet(10);
        bits.flip(0,4);
        System.out.println(bits.get(4));
    }
}
