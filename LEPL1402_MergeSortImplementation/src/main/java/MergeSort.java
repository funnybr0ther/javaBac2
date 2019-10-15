import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    /**
     * Merge the array from lo to hi
     */

    public static void merge(int[] a,int[] aux, int lo, int mid, int hi)
    {   int[] temp = new int[a.length];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
            // Copy a[lo..hi] to aux[lo..hi].
            temp[k] = a[k];
        for (int k
             = lo; k <= hi; k++) // Merge
        if
        (i > mid)
            a[k] =
                    temp[j++];
        else if
        (j > hi )
            a[k] =
                    temp[i++];
        else if
        (temp[j]<=temp[i]) a[k] =
                    temp[j++];
        else
            a[k] =
                    temp[i++];
    }


    /**
     * Split the array and call merge
     */
    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a,0,a.length-1);
    }

    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[150 ];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an arra
        }
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] a, int lo, int hi){
        if (hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        int[] random = new int[4];
        merge(a,random,lo,mid,hi);
    }
}
