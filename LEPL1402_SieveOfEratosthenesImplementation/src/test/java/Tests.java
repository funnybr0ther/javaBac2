
import com.github.guillaumederval.javagrading.CustomGradingResult;
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradeFeedbacks;
import com.github.guillaumederval.javagrading.GradingRunner;
import com.github.guillaumederval.javagrading.TestStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.BitSet;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;


import static org.junit.Assert.*;

@RunWith(GradingRunner.class)
public class Tests{
    
    @Test
    @Grade(value=10 , custom = true, cpuTimeout=1000)
    public void testLow() throws CustomGradingResult{
            assertEquals(4, Sieve.numberOfPrime(10));
            assertEquals(25, Sieve.numberOfPrime(100));
            assertEquals(168, Sieve.numberOfPrime(1000));
    }


}