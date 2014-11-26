
package util;

import java.util.Comparator;


/*
 * http://stackoverflow.com/questions/15189949/making-a-generic-comparator-class
 */
public class NaturalComparator<T extends Comparable<T>>
    implements Comparator<T>
{
    public int compare(T a, T b)
    {
        return a.compareTo(b);
    }
}
