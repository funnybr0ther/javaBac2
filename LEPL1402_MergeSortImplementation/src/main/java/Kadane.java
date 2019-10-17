public class Kadane {

    public static void main(String[] args) {
        int[] sup = {1,-1,2,3,-4,6};
        System.out.println(maxSubarray(sup)[0]);
    }
    public static int[] maxSubarray(int[] a){
        int best_sum=a[0];
        int best_start=0;
        int best_end=0;
        int current_sum=a[0];
        int current_start=0;
        for (int i=1;i<a.length;i++){
           if (current_sum<=0){
               current_start=i;
               current_sum=a[i];
           }
           else{
               current_sum+=a[i];
           }
           if (current_sum>best_sum){
               best_sum=current_sum;
               best_start=current_start;
               best_end=i;
            }
        }
        int[] result = {best_sum,best_start,best_end};
        return result;
    }
}
