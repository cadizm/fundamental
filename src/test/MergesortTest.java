
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;

import algorithms.Mergesort;


public class MergesortTest
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

        Mergesort<String> mergesort = new Mergesort<String>();
        mergesort.merge(s, 0, 4, s.length - 1);

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

        Mergesort<Integer> mergesort = new Mergesort<Integer>();

        Arrays.sort(a);  // in-place sort
        mergesort.sort(b);  // in-place sort

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

        Mergesort<String> mergesort = new Mergesort<String>();
        mergesort.sort(s);

        assertArrayEquals(t, s);
    }
}
