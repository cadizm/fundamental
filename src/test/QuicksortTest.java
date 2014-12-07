
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;

import algorithms.Quicksort;


public class QuicksortTest
{
    @Test
    public void testQuicksort1()
    {
        Integer[] a = {
            0, 17, 22, -3, 44
        };

        Integer[] b = {
            0, 22, 17, 44, -3
        };

        Arrays.sort(a);  // in-place sort
        Quicksort.qsort(b);  // in-place sort

        assertArrayEquals(a, b);
    }

    @Test
    public void testQuicksort2()
    {
        String[] s = {
            "M", "E", "R", "G", "E",
            "S", "O", "R", "T",
            "E", "X", "A", "M", "P", "L", "E",
        };

        String[] t = {
            "A", "E", "E", "E", "E", "G", "L", "M",
            "M", "O", "P", "R", "R", "S", "T", "X",
        };

        Quicksort.qsort(s);

        assertArrayEquals(t, s);
    }
}
