import java.util.Arrays;

public class StringUtils {


    /*
     * Split the input string 'str' w.r.t the character 'marker' in an array of String
     * for example split("test-test", '-') => {"test", "test"}
     * Must return null if there is no occurrence of 'marker' in 'str'
     */
    public static String [] split(String str, char marker){
        int i=0;
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            if (c == marker) {
                i++;
            }
        }
            //Process char
            if (i == 0) {
                return null;
            }
            String[] listing = new String[i+1];
            String temp = "";
            int index = 0;
            for (int l = 0; l < str.length(); l++) {
                char c = str.charAt(l);
                if(l==str.length()-1){
                    temp+=c;
                    listing[index]=temp;
                }
                else if (c == marker) {
                    listing[index] = temp;
                    index++;
                    temp = "";
                } else {
                    temp += c;
                }
            }
        return listing;
    }


    /*
     * Returns the index of the first occurrence of sub in str
     * or -1 if there is no occurrence of sub in str at all.
     * Be careful, we ask you to make CASE SENSITIVE comparison between str and sub.
     */
    public static int indexOf(String str, String sub){
        boolean verif;
        for (int j = 0; j < str.length()-sub.length()+1; j++){
            verif = true;
            for (int i=0; i<sub.length();i++){
                verif = (verif && (sub.charAt(i) == str.charAt((i+j))));
            }
            if (verif){
                return j;
            }
        }
        return -1;
    }


    public static String toLowerCase(String str){
        String newstr = "";
        int index = 0;
        boolean found;
        String alpha ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int j = 0; j < str.length(); j++){
            char c = str.charAt(j);
            found = false;
            for (int i = 0; i < alpha.length(); i++){
                char d = alpha.charAt(i);
                if (c==d){
                    index = i;
                    found = true;
                }
            }
            if (found){
                if (index>25){
                    System.out.println( index + " Over 26 at char " + c + " at index " + j );
                    System.out.println("alphabet index of " + index + " = " + alpha.charAt(index));
                    index-=26;
                    System.out.println("char");
                    newstr += alpha.charAt(index);
                }
                else{
                    newstr+=alpha.charAt(index);
                }
            }
            else{
                System.out.println("Non-alphabetical char");
                newstr+=c;
            }
        }
        return newstr;
    }


    /*
     * Returns true if the string 'str' is a palindrome (a string that reads the same from
     * left to right AND from right to left).
     */
    public static boolean palindrome(String str){
        boolean palin=true;
        int i=0;
        while(palin && i<str.length()/2 +1){
            palin = (str.charAt(i)==str.charAt(str.length() -1 -i));
            i++;
        }
        return palin;
    }

    public static void main(String[] args){
        System.out.println(indexOf("abcd","cd"));
    }

}
