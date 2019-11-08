

public class Sorter {
    /**
    * Sorts a list in increasing order
    *
    * We expect this function to behave in O(n^2), where n is the size of the list. 
    * Precisely, we expect that you make at MOST n^2 calls to list.pop() and at 
    * MOST n^2 calls to list.swap(). 
    * 
    * You will obtain the full score for a test case if
    *
    * - The list is sorted (2/4 points per test case)
    * - The list is sorted AND you make less than n^2 calls to swap (1/4 points)
    * - The list is sorted AND you make less than n^2 calls to pop (1/4 points)
    *
    * @param list: a list of integers to be sorted.
    */
    public static void sort(LinkedList list) {
        // Here is a small loop with an invariant that you should try to respect
        // although it's not mandatory. Try to respect it, it will help you ;-)
        int[] a = {1,2,5,8};
        LinkedList newList = new LinkedList(a);
        for(int iter = 1; iter <= list.getSize(); iter++) {
            //invariant: the 'iter' biggest elements are at the end of the list and are sorted.
            //example, at iteration iter=3, the three lasts elements are the three biggest elements in the list, and
            //they are in the increasing order.
            for(int i=0;i<list.getSize()-iter;i++){
                if (list.getFirst()>list.getSecond()){
                    list.swap();
                }
                list.pop();
            }
            for(int j =0;j<iter;j++){
                list.pop();
            }
        }
        }

        // here, if you followed the invariant proposed above, the list should be sorted!
    }

