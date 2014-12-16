
package util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


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
     * Use a "bit-mask" for the 2^n combinations of s, where n = s.length()
     */
    public static String[] combinations(String s)
    {
        int n = s.length();
        int N = (int)Math.pow(2, n);

        List<String> res = new ArrayList<String>();

        for (int i = 0; i < N; ++i) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) != 0) {
                    sb.append(s.charAt(j));
                }
            }
            res.add(sb.toString());
        }

        return res.toArray(new String[0]);
    }

    private static Map<Integer, Integer> factorialMap = new Hashtable<Integer, Integer>();

    public static int factorial(int n)
    {
        if (n < 0) {
            throw new RuntimeException("Factorial error: n < 0");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        if (factorialMap.containsKey(n)) {
            return factorialMap.get(n);
        }

        int f = n * factorial(n - 1);
        factorialMap.put(n, f);

        return f;
    }
}
