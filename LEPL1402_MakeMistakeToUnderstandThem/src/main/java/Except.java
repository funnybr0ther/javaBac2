
import java.util.ArrayList;
import java.util.List;

public class Except{
    
    
    public static void outof(){
        int[] hey = {1,2,3};
        System.out.println(hey[3]);
    }
    
    public static void concurr(){
        List<String> list = new ArrayList<>();

        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");

        for (String item : list) {
            list.remove(item);
        }
    }
    
    public static void nullpointer() {
        String x=null;
        System.out.println(x.split("",1));
    }
    
    
    
}