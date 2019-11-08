
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class Tests {
    @Test
    public void testExample(){
        LinkedList l = new LinkedList(new int[]{1,6,2,54,3,64});
        Sorter.sort(l);
        assertTrue(l.isSorted());
    }
}
