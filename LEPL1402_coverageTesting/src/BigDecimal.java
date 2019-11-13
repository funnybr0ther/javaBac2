public class BigDecimal {
    /*
     * parse exponent
     */
    public static long parseExp(char[] in, int offset, int len){
        long exp = 0;
        offset++;
        char c = in[offset];
        len--;
        boolean negexp = (c == '-');
        // optional sign
        if (negexp || c == '+') { // ---
            offset++;
            c = in[offset];
            len--;
        }
        if (len <= 0) // no exponent digits ---
            return 4;
        // skip leading zeros in the exponent
        while (len > 10 && (c=='0' || (Character.digit(c, 10) == 0))) { //---
            offset++;
            c = in[offset];
            len--;
        }
        if (len > 10) // too many nonzero exponent digits ---
            return 4;
        // c now holds first digit of exponent
        for (;; len--) { // ---
            int v;
            if (c >= '0' && c <= '9') { //---
                v = c - '0';
            } else { // ---
                v = Character.digit(c, 10);
                if (v < 0) // not a digit // ---
                    System.out.println("Ya");
                    return 4;
            }
            exp = exp * 10 + v;
            if (len == 1) // ---
                break; // that was final character
            offset++;
            c = in[offset];
        }
        if (negexp) { // apply sign //---
            exp = -exp;
            System.out.println("yes");
        }
        return exp;
    }

    public static void main(String[] args) {
        // parameters for parseExp
        char[] in = new char[]{' ','-','1','4','6','7','1','0','4','5','6'};
        String in2S = "00014561231234564456565123";
        char[] in2 =  in2S.toCharArray();
        String in3S = "0+412A453000";
        char[] in3 = in3S.toCharArray();
        String in4S = "0+5";
        char[] in4 = in4S.toCharArray();
        // also possible to use .toCharArray from String class for that :
        // char[] in = myString.toCharArray();
        int offset =0;
        int len = 6;
        int offset2 = 0;
        int len2 = 20;
        int offset3 = 0;
        int len3=10;
        int offset4=0;
        int len4=1;
        // run the program with the given situation
        System.out.println(BigDecimal.parseExp(in, offset, len));
        try {
            BigDecimal.parseExp(in2, offset2, len2);
        }
        catch(Exception e){

        }
        try{
        BigDecimal.parseExp(in3,offset3,len3);
        BigDecimal.parseExp(in4,offset4,len4);
    }
    }
