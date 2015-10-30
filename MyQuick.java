/**
 */
public class MyQuick {

    public static int mycount=0;

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        mycount += hi - lo ;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        assert isSorted(a, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(int[] a, int lo, int hi) {
        int i = lo + 1;


        // Programming Assignment 2 Question 2 -- last element as pivot
        //exch(a,lo,hi); //pivot #choose the last element as pivot

        // Programming Assignment 2 Question 3 -- median of 3 as pivot
        int mid = (hi +lo) /2;
        int mina = Math.min(a[mid],Math.min(a[lo],a[hi]));
        int maxa = Math.max(a[mid],Math.max(a[lo],a[hi]));
        if ( a[mid] > mina && a[mid] < maxa)
            exch(a,lo,mid);
        if ( a[hi] > mina && a[hi] < maxa)
            exch(a,lo,hi);

        int v = a[lo]; //pivot #choose the first element as pivot

        for (int j = lo+1 ; j<=hi ; j++){
            if (less(a[j], v)){
                exch(a,j,i++);
            }
        }

        // put partitioning item v at a[i-1]
        exch(a, lo, i-1);

        // now, a[lo .. i-2] <= a[i-1] <= a[i .. hi]
        return i-1;
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(int v, int w) {
        return (v-w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; quicksorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        MyQuick.sort(a,0,a.length-1);
        show(a);
        System.out.print("count=="+ Integer.toString(mycount));
    }

}
