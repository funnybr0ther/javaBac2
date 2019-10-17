public class Fibonacci {


    public static int fiboRecursive(int index){
        if (index>1){
            return fiboRecursive(index-1) + fiboRecursive(index-2);
        }
        else{
            return index;
        }
    }


    public static int fiboIterative(int index){
        if (index<2){
            return index;
        }
        int prev1=0;
        int prev2=1;
        for (int i=0;i<index;i++){
            int temp=prev2;
            prev2=prev1;
            prev1=prev1+temp;

        }
        return prev1;
    }
    public static void bubbleSort(int[] array){
        int n = array.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(array[j-1]>array[j]){
                    //swap elements
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a= {1,4,2,3,7,5,6,98,7,6,5,4,7,5,6,79,6,4,8,96,58,7,1};
        bubbleSort(a);

    }
}
