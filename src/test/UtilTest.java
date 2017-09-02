
package test;

import java.util.Map;
import java.util.Hashtable;


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import static util.Util.combinations;
import static util.Util.factorial;
import static util.Util.hex2dec;
import static util.Util.permutations;


public class UtilTest
{
    @Test
    public void testHex2dec()
    {
        char[] c = {
            '0','1','2','3',
            '4','5','6','7',
            '8','9','a','b',
            'c','d','e','f',
        };

        for (int i = 0; i < c.length; ++i) {
            assertEquals(i, hex2dec(c[i]));
        }

        assertEquals(-1, hex2dec(' '));
        assertEquals(-1, hex2dec('/'));
        assertEquals(-1, hex2dec('g'));
        assertEquals(-1, hex2dec('G'));
    }

    @Test
    public void testPermutations()
    {
        String[] S = {
            "A",
            "AB",
            "ABC",
            "ABCD",
        };
        for (String s : S) {
            Map<String, Integer> map = new Hashtable<String, Integer>();
            String[] P = permutations(s);
            for (String p : P) {
                map.put(p, 1);
            }
            assertEquals(map.size(), factorial(s.length()));
        }
    }

    @Test
    public void testCombinations()
    {
        String[] S = {
            "A",
            "AB",
            "ABC",
            "ABCD",
            "ABCDE",
        };
        for (String s : S) {
            Map<String, Integer> map = new Hashtable<String, Integer>();
            String[] C = combinations(s);
            for (String c : C) {
                map.put(c, 1);
            }
            assertEquals(map.size(), (int)Math.pow(2, s.length()));
        }
    }
}
