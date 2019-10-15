
public class Search {

    /**
     *
     * @param tab
     * @return
     */
    public static int search(int[] tab, int elem){
       int low = 0;
       int high = tab.length-1;
       while(low <= high){
           int mid = (high + low)/2;
           if (tab[mid]>elem){
               high=mid-1;
           }
           else if (tab[mid]<elem){
               low=mid+1;
           }
           else{
               return mid;
           }
       }
       return -1;
    }
}
