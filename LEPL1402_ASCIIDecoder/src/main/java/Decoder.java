import java.util.ArrayList;

public class Decoder {

    /*
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * the 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["42", "72", "88"], ["98", "99", "111", "47", "55"]]
     * to your decode method, you should return : [ "*HX", "bco/7" ]
     *
     * You should NEVER return null or an array containing null
     */
    public static String [] decode(int[] forbidden, String[][] sentences) {
        if (forbidden != null) {
            ArrayList forbid = new ArrayList(forbidden.length);
            for (int i : forbidden) {
                forbid.add(i);
            }
            String[] translate = new String[sentences.length];
            int index = 0;
            for (String[] i : sentences) {
                String newstr = "";
                for (String j : i) {
                    int hexcode = Integer.parseInt(j);
                    if (forbid.contains(hexcode)) {
                        newstr += "";
                    } else {
                        newstr += (char) hexcode;
                    }
                }
                translate[index] = newstr;
                index++;
            }
            return translate;
        }
        else{
            String[] translate = new String[sentences.length];
            int index = 0;
            for (String[] i : sentences) {
                String newstr = "";
                for (String j : i) {
                    int hexcode = Integer.parseInt(j);
                    newstr += (char)hexcode;
                }
                translate[index] = newstr;
                index++;
            }
            return translate;
        }
    }
    public static void main(String[] args){
        int a = 300;
        byte b = (byte)a;
        System.out.println(b);
    }
}