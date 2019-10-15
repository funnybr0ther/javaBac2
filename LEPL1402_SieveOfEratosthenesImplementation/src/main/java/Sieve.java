import java.util.BitSet;
import java.util.Random;
public class Sieve{
    
    public static int numberOfPrime(int n){
        BitSet A = new BitSet(n);
        A.flip(2,n);
        int a;

        for (int i=2;i<=Math.pow(n,0.5);i++){
            if (A.get(i)){
                a=0;
                while (i*i + a*i<=n){
                    A.set(i*i+a*i,false);
                    a+=1;
                }
            }
        }
        return A.cardinality();
    }
    public static void main(String[] args){
        Random random = new Random();
        random.ints
    }
}