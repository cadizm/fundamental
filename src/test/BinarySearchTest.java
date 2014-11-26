
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import algorithms.BinarySearch;


public class BinarySearchTest
{
    @Test
    public void testBinarySearch()
    {
        Integer[] array = {
            0, 22, 11, 3, 100, 101, -16, 77
        };

        BinarySearch<Integer> bs = new BinarySearch<Integer>();

        assertEquals(new Integer(22), bs.binarySearchRecursive(array, 22));
        assertEquals(new Integer(22), bs.binarySearchIterative(array, 22));

        assertEquals(new Integer(-16), bs.binarySearchRecursive(array, -16));
        assertEquals(new Integer(-16), bs.binarySearchIterative(array, -16));

        assertEquals(null, bs.binarySearchRecursive(array, 143));
        assertEquals(null, bs.binarySearchIterative(array, 143));
    }

}
