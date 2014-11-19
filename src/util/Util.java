
package util;

import java.util.List;
import java.util.ArrayList;


public class Util
{
    /*
     * `man ascii'
     */
    public static int hex2dec(char c)
    {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        else if (c >= 'a' && c <= 'f') {
            return 10 + c - 'a';
        }
        else if (c >= 'A' && c <= 'F') {
            return 10 + c - 'A';
        }
        return -1;
    }

    /*
     * For given string s[1],...,s[n], chop off last character and recursively
     * generate all permutations of s[1],...,s[n-1].  Given all permutations
     * of s[1],...,s[n-1], insert s[n] into every "slot" in each permutation.
     *
     * Numer of permutations is n!, where n = s.length()
     */
    public static String[] permutations(String s)
    {
        int n = s.length();

        // base case
        if (n <= 1) {
            return new String[] {s};
        }

        List<String> res = new ArrayList<String>();

        String t = s.substring(0, n-1);
        String u = s.substring(n-1, n);
        String[] P = permutations(t);

        for (String p : P) {
            int m = p.length();
            for (int i = 0; i < m; ++i) {
                String prefix = p.substring(0, i+1);
                String suffix = p.substring(i+1, m);
                String pp = prefix + u + suffix;
                res.add(pp);
            }
            res.add(u + p);
        }

        return res.toArray(new String[0]);
    }

    /*
     * Use a "bit-mask" for the 2^n k-ary combinations of n choose k of s,
     * where n = s.length()
     */
    public static String[] combinations(String s)
    {
        return null;
    }
}
