public class Kadane {

    public static void main(String[] args) {
        int[] sup = {-1,-3};
        System.out.println(maxSubarray(sup)[0]);
    }
    public static int[] maxSubarray(int[] a){
        int best_sum=0;
        int best_start=0;
        int best_end=0;
        int current_sum=0;
        int current_start=0;
        for (int i=0;i<a.length;i++){
            if (current_sum<=0){
                current_start=i;
                current_sum=a[i];
            }
            else {current_sum=Math.max(a[i],current_sum+a[i]);}
            if (current_sum>best_sum){
                best_sum=current_sum;
                best_start=current_start;
                best_end=a[i];
            }
        }
        int[] hey = {best_sum,best_start,best_end};
        return hey;

    }
}
