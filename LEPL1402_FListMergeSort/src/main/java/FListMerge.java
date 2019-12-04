import java.util.NoSuchElementException;

public class FListMerge {
public FList<Integer> sort(FList<Integer> fList) {
    if (fList.length() != 1) {
        return fList;
    }
    FList<Integer> firstHalf = new FList.Nil<Integer>();
    FList<Integer> secondHalf = new FList.Nil<Integer>();
    FList<Integer> current = fList;
    FList<Integer> sorted = FList.nil();
    for (int i = 0; i < fList.length() / 2; i++) {
        firstHalf = firstHalf.cons(current.head());
        current = current.tail();
    }
    FList<Integer> firstHalfMerge = sort(rev(firstHalf));
    FList<Integer> secondHalfMerge = sort(secondHalf);
    while(firstHalfMerge.isNotEmpty()||secondHalf.isNotEmpty()){
        if(firstHalfMerge.isEmpty()||(!secondHalfMerge.isEmpty() && firstHalfMerge.head()<secondHalfMerge.head())){
            sorted.cons(secondHalfMerge.head());
            secondHalfMerge= secondHalfMerge.tail();
        }
        else{
            sorted.cons(firstHalfMerge.head());
            firstHalfMerge=firstHalfMerge.tail();
        }
    }
    return rev(sorted);
}
public FList<Integer> rev(FList<Integer> fList){
    FList<Integer> reversed = new FList.Nil<>();
    for(int i=0;i<fList.length();i++){
        reversed.cons(fList.head());
        fList=fList.tail();
    }
    return reversed;
}

}

