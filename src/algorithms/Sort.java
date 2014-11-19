
package algorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Sort<T extends Comparable<? super T>>
{
    /*
     * In-place merge
     */
    public void merge(T[] array, int low, int mid, int high)
    {
        new Mergesort<T>().merge(array, low, mid, high);
    }

    /*
     * In-place sort
     */
    public void mergesort(T[] array)
    {
        new Mergesort<T>().sort(array);
    }

    class Mergesort<T extends Comparable<? super T>>
    {
        List<T> aux;

        public Mergesort()
        {
            aux = new ArrayList<T>();
        }

        public void sort(T[] array)
        {
            sort(array, 0, array.length - 1);
        }

        public void sort(T[] array, int low, int high)
        {
            if (high <= low) {
                return;
            }

            int mid = low + ((high - low) / 2);

            sort(array, low, mid);
            sort(array, mid + 1, high);

            merge(array, low, mid, high);
        }

        /**
         * In-place merge of array[low...mid] with array[mid+1...high]
         * into array[low...high] (low/high inclusive)
         *
         * Sedgewick. Algorithms 4th ed. 2011
         */
        public void merge(T[] array, int low, int mid, int high)
        {
            // clear since we're not using "real" array
            aux.clear();
            aux.addAll(Arrays.asList(array));

            int i = low;
            int j = mid + 1;  // mid is the "last" element on left

            for (int k = low; k <= high; ++k) {
                // left half exhausted, take from right
                if (i > mid) {
                    array[k] = aux.get(j++);
                }
                // right half exhausted, take from left
                else if (j > high) {
                    array[k] = aux.get(i++);
                }
                // right key < left key, take from right
                else if (aux.get(j).compareTo(aux.get(i)) < 0) {
                    array[k] = aux.get(j++);
                }
                // right key > left key, take from left
                else {
                    array[k] = aux.get(i++);
                }
            }
        }
    }

}
