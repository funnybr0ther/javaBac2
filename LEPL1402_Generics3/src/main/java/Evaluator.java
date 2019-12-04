import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Evaluator {

    public BiFunction<Boolean, Boolean, Boolean> xor_gate() {
        return (a,b)-> !(a==b);
    }

    public BiFunction<Boolean, Boolean, Boolean> or_gate() {
        return (a,b) -> (a||b);
    }

    public BiFunction<Boolean, Boolean, Boolean> and_gate() {
        return (a,b) -> (a&&b);
    }

    public Function<Boolean, Boolean> not_gate() {
        return (a) -> (!a);
    }

    // Should return a map with the results stored in map ( use HashMap )
    // Keys are "SUM", "CarryOut"
    // TODO WARNING : USE HERE ONLY the previously defined method to compute result (as inginious will prevent you to cheat to directly invoke logical operators)
    public Map<String, Boolean> evaluate_circuit(Boolean a, Boolean b, Boolean carry_in) {
        HashMap map = new HashMap();
        Boolean n1 = xor_gate().apply(a,b);
        Boolean sum = xor_gate().apply(n1,carry_in);
        Boolean bottom = and_gate().apply(a,b);
        Boolean mid = and_gate().apply(n1,carry_in);
        Boolean carryOut = or_gate().apply(mid,bottom);

        map.put("SUM",sum);
        map.put("CarryOut",carryOut);
        return map;
    }

}