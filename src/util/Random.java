
package util;


/*
 * Taken from Sedgewick: http://introcs.cs.princeton.edu/java/stdlib/StdRandom.java.html
 */
public class Random
{
    private static java.util.Random psrng;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        psrng = new java.util.Random(seed);
    }

    private Random()
    {
        // empty
    }

    /*
     * Return pseudo random number in [0, n)
     */
    public static int uniform(int n)
    {
        if (n <= 0) {
            throw new RuntimeException("Error: n must be > 0");
        }

        return psrng.nextInt(n);
    }

    /*
     * Return pseudo random number in [a, b)
     */
    public static int uniform(int a, int b) {
        if (b <= a) {
            throw new RuntimeException("Invalid range");
        }

        if ((long) b - a >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Invalid range");
        }

        return a + uniform(b - a);
    }

    public static void shuffle(Object[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);  // between i and n - 1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
