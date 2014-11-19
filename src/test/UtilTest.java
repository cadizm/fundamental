
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import util.Util;


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
            assertEquals(i, Util.hex2dec(c[i]));
        }

        assertEquals(-1, Util.hex2dec(' '));
        assertEquals(-1, Util.hex2dec('/'));
        assertEquals(-1, Util.hex2dec('g'));
        assertEquals(-1, Util.hex2dec('G'));

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
            String[] P = Util.permutations(s);
            System.out.print(s + " => ");
            for (String p : P) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }
}
