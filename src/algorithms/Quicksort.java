
package algorithms;

import util.Random;


public class Quicksort
{
    public static <T extends Comparable<? super T>>
    void qsort(T[] array)
    {
        qsort(array, 0, array.length - 1);
    }

    /*
     * Sort array between indices low and high, inclusive
     */
    private static <T extends Comparable<? super T>>
    void qsort(T[] array, int low, int high)
    {
        if (high <= low) {
            return;
        }

        int j = partition(array, low, high);

        qsort(array, low, j - 1);
        qsort(array, j + 1, high);
    }

    /*
     * http://en.wikipedia.org/wiki/Quicksort#Algorithm
     *
     * Partition array so that elements less than the pivot come before it,
     * and elements greater than the pivot come after it.
     *
     * Return index of pivot's final position
     */
    private static <T extends Comparable<? super T>>
    int partition(T[] array, int low, int high)
    {
        int pivot = Random.uniform(low, high);
        T v = array[pivot];

        // save pivot at array[high]
        swap(array, pivot, high);

        int j = low;
        for (int i = low; i < high; ++i) {
            if (array[i].compareTo(v) < 0) {
                swap(array, i, j++);
            }
        }

        // move pivot to final location
        swap(array, j, high);

        return j;
    }

    private static <T extends Comparable<? super T>>
    void swap(T[] array, int i, int j)
    {
        if (i < 0 || i >= array.length) {
            String s = String.format("Swap error: index `%d' out of bounds", i);
            throw new RuntimeException(s);
        }
        else if (j < 0 || j >= array.length) {
            String s = String.format("Swap error: index `%d' out of bounds", j);
            throw new RuntimeException(s);
        }

        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
