
package algorithms;

import java.util.Arrays;


public class BinarySearch<T extends Comparable<? super T>>
{
    public BinarySearch()
    {
    }

    public T binarySearchRecursive(T[] array, T key)
    {
        Arrays.sort(array);  // ensure sorted

        return binarySearchRecursive(array, key, 0, array.length - 1);
    }

    private T binarySearchRecursive(T[] array, T key, int low, int high)
    {
        // note low < high
        if (high < low) {
            return null;
        }

        int mid = low + ((high - low) / 2);  // avoid overflow

        if (array[mid].compareTo(key) > 0) {
            return binarySearchRecursive(array, key, low, mid - 1);
        }
        else if (array[mid].compareTo(key) < 0) {
            return binarySearchRecursive(array, key, mid + 1, high);
        }
        else {
            return array[mid];
        }
    }

    public T binarySearchIterative(T[] array, T key)
    {
        Arrays.sort(array);  // ensure sorted

        return binarySearchIterative(array, key, 0, array.length - 1);
    }

    private T binarySearchIterative(T[] array, T key, int low, int high)
    {
        // note high >= low
        while (high >= low) {
            int mid = low + ((high - low) / 2);  // avoid overflow

            if (array[mid].compareTo(key) > 0) {
                high = mid - 1;
            }
            else if (array[mid].compareTo(key) < 0) {
                low = mid + 1;
            }
            else {
                return array[mid];
            }
        }

        return null;
    }
}
