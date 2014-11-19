
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;

import algorithms.Sort;


public class SortTest
{
    @Test
    public void testMerge()
    {
        String[] s = {
            "E", "E", "G", "M", "R", "A", "C", "E", "R", "T",
        };

        String[] t = {
            "A", "C", "E", "E", "E", "G", "M", "R", "R", "T",
        };

        Sort<String> sort = new Sort<String>();
        sort.merge(s, 0, 4, s.length - 1);

        assertArrayEquals(t, s);
    }

    @Test
    public void testMergesort1()
    {
        Integer[] a = {
            0, 17, 22, -3, 44
        };

        Integer[] b = {
            0, 22, 17, 44, -3
        };

        Sort<Integer> sort = new Sort<Integer>();

        Arrays.sort(a);  // in-place sort
        sort.mergesort(b);  // in-place sort

        assertArrayEquals(a, b);
    }

    @Test
    public void testMergesort2()
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

        Sort<String> sort = new Sort<String>();
        sort.mergesort(s);

        assertArrayEquals(t, s);
    }
}
