public class devoir {
    public static void main(String[] val) {
        int sumation = 0;
        for (String number:val){
            try {
                sumation += Integer.parseInt(number);
            }
            catch (NumberFormatException e) {
            }

        }
        System.out.println(sumation);

    }
}
