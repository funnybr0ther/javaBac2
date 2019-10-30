import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object [] list;
    private int size;


    public MyArrayList(int initSize){
        if(initSize<0){
            throw new IndexOutOfBoundsException("Not gut");
        }
       list = new Object[initSize];
       size=0;
    }


    /*
     * Checks if 'list' needs to be resized then add the element at the end
     * of the list.
     */
    public void enqueue(Item item){
       if (size==list.length){
           Object[] tempList = new Object[size+1];
           for (int i=0;i<size;i++){
               tempList[i]=list[i];
           }
           tempList[size]=item;
           list = tempList;
           size++;
       }
       else{
           list[size]=item;
           size++;
       }
    }


    /*
     * Removes the element at the specified position in this list.
     * Returns the element that was removed from the list. You dont need to
     * resize when removing an element.
     */
    public Item remove(int index){
        if(index>size-1){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Object[] newL = new Object[list.length];
        Item it = (Item) list[index];
        int i=0;
        int j=0;
        while(j<list.length){
            if(j==index){
                j++;
                newL[i]=list[j];
            }
            else{
                newL[i]=list[j];
            }
            i++;j++;
        }
        size--;
        list = newL;
        return it;

    }


    public int size(){
        return this.size;
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {
        int length = size;
        int index=0;

        @Override
        public boolean hasNext() {
            return (index<size);
        }

        @Override
        public Item next() {
            if(length!=size){
                throw new ConcurrentModificationException("That won't do it, mate");
            }
            return (Item) list[index++];
        }
    }

}