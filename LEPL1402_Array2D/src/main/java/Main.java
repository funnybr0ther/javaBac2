import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        String s;
        String ptr = null;
        if (ptr.equals("EPL")) {
            System.out.println("SAME");
        }

    }
    static int[][] build_from(String s) {
        String[] separated = s.split("\n");
        int[][] matrix = new int[separated.length][];
        for (int i = 0; i < separated.length; i++) {
            String line = separated[i].trim();
            String[] stringArray = line.split(" ");
            int[] numberLine = new int[stringArray.length];
            for (int j = 0; j < stringArray.length; j++) {
                numberLine[j] = Integer.valueOf(stringArray[j]);
            }
            matrix[i] = numberLine;
        }
//        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }

    static int sum(int[][] array) {
        int sumation = 0;
        for (int[] i : array) {
            int subsum = 0;
            for (int j : i) {
                subsum += j;
            }
            sumation += subsum;
        }
        return sumation;
    }

    static int[][] transpose(int[][] matrix) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        int[][] newMatrix = new int[columns][lines];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < lines; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        System.out.println(Arrays.deepToString(newMatrix));
        return newMatrix;
    }

    static int[][] product(int[][] matrix1, int[][] matrix2) {
        int[][] prod = new int[matrix1.length][matrix2[0].length];
        int lines = prod.length;
        int columns = prod[0].length;
        int length = matrix2.length;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                int sumprod = 0;
                for (int l = 0; l < length; l++) {
                    sumprod += matrix1[i][l] * matrix2[l][j];
                }
                prod[i][j] = sumprod;
            }
        }
//        System.out.println(Arrays.deepToString(prod));
        return prod;
    }
}
