public class BoundedBuffer {
    private Integer[] data;
    private int putPointer, takePointer, size;

    public BoundedBuffer(int capacity){
        this.data = new Integer[capacity];
        this.putPointer = 0;
        this.takePointer = 0;
        this.size = 0;
    }

    /*
     * Mechanics of putting x on the buffer.
     * x is added at the end of the buffer.
     */
    private void doPut(Integer x){
        data[putPointer++] = x;
        if(putPointer>=data.length){
            putPointer=0;
        }
        size++;
        notify();
    }

    /*
     * Mechanics of getting the first element of the buffer
     */
    private Integer doTake(){
        Integer integer = data[takePointer++];
        data[takePointer-1] = null;
        if(takePointer>=data.length){
            takePointer=0;
        }
        size--;
        notify();
        return integer;
    }

    private boolean isFull(){
        return this.data.length == this.size;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    /*
     * put x on the buffer if the buffer is not full
     * if the buffer is full, the thread waits until a place is free
     */
    public synchronized void put(Integer x) throws InterruptedException{
        while(this.isFull()){
            wait();
        }
        doPut(x);

    }

    /*
     * Get the first element of the buffer
     * if the buffer is empty, the thread waits until an element arrives
     */
    public synchronized Integer take() throws InterruptedException{
        while(this.isEmpty()){
            wait();
        }
        return doTake();
    }

    /*
     * put x on the buffer if the buffer is not full
     * if the buffer is full, the thread waits ms milliseconds until a place is free
     * if the delay is exceeded, don't put x on the buffer
     * return true if x was added on the buffer, or false
     * return false if an exception occurs
     */
    public synchronized boolean offer(Integer x, long ms){
        while(this.isFull()){
            try {
                this.wait(ms);
                if(this.size==this.data.length){
                    return false;
                }
            }
            catch (InterruptedException e){
                return false;
            }
        }
        doPut(x);
        return true;
    }

    /*
     * get the first element of the buffer
     * if the buffer is empty, the thread waits ms milliseconds until an element arrives
     * if the delay is exceeded or an exception occurs return null
     */
    public synchronized Integer poll(long ms){
        while(this.isEmpty()){
            try{
                this.wait(ms);
                if(this.size==0){
                    return null;
                }
            }
            catch (InterruptedException e){
                return null;
            }
        }
        return doTake();
    }



}
