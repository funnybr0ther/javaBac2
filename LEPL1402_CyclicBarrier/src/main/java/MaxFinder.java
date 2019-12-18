import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MaxFinder {

    private final int nThreads,length,width,depth;
    private final int[][][] data;
    private final CyclicBarrier barrier;
    private int[] sums;
    private int max;

    /*
     * Worker constructor takes only one parameter int r, which is his associated row number
     * A worker is responsible of the calculation of the sum of each 2D-Array with row == r + nThread * round; with round >= 0
     *
     * Run should compute the sum of a 2D-array and store the result in sums[] then wait for the cyclic barrier to get the result
     * And restart computing nThreads further
     */
    class Worker implements Runnable {
        int r;
        int round = 0;
        public Worker(int r) {
            this.r = r;
        }

        @Override
        public void run() {
            while(round<data.length/nThreads){
                int sheet = r + nThreads * round;
                int sum = 0;
                for(int k = 0 ; k < width ; k++){
                    for(int j = 0 ; j < depth ; j++){
                        sum += data[sheet][k][j];
                    }
                }
                sums[r] = sum;
                round++;
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            }

        }
    }

    /*
     *
     * Initialize all the instance variable and start the right amount of Threads
     *
     */
    private MaxFinder(int[][][] matrix, int nThreads) throws InterruptedException{
        Thread[] threads = new Thread[nThreads];
        this.nThreads=nThreads;
        this.length=matrix.length;
        this.width=matrix[0].length;
        this.depth=matrix[0][0].length;
        data=matrix;
        int index = 0;
        max = Integer.MIN_VALUE;
        int[] sums = new int[nThreads];
        barrier=new CyclicBarrier(nThreads,()->{
            for (int i=0;i<nThreads;i++)
                max = Math.max(max,sums[i]);
        });
        for (Thread thread:threads) {
            Worker work = new Worker(index);
            thread=new Thread(()->work.run());
            thread.start();
            index++;
        }
        for (Thread thread : threads)
            thread.join();

    }
    /*
    * subSize is the length of the subarray
    * rowSize is the rowlength for all the array
    *
    */
    public static int getMaxSum(int[][][] matrix, int nThreads){
        try{
            MaxFinder mf = new MaxFinder(matrix, nThreads);
            return mf.max;
        }catch(InterruptedException e){
            return -1;
        }

    }
}
