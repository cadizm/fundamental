
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import datastructures.impl.Hashtable;
import exception.DictionaryException;


public class HashtableTest
{
    @Test
    public void testPut()
        throws DictionaryException
    {
        Hashtable<String, String> hashtable = new Hashtable<String, String>(1);

        hashtable.put("A", "A");
        assertEquals("A", hashtable.get("A"));

        hashtable.put("B", "A");
        assertEquals("A", hashtable.get("B"));

        assertEquals(2, hashtable.size());
    }

    @Test
    public void testGet()
        throws DictionaryException
    {
        Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>(1);

        hashtable.put("A", 1);
        assertEquals(new Integer(1), hashtable.get("A"));

        hashtable.put("B", 2);
        assertEquals(new Integer(2), hashtable.get("B"));

        assertEquals(2, hashtable.size());
    }

    @Test
    public void testRemove()
        throws DictionaryException
    {
        Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>(1);

        hashtable.put("A", 1);
        assertEquals(1, hashtable.size());

        assertEquals(new Integer(1), hashtable.remove("A"));
        assertEquals(0, hashtable.size());

        hashtable.put("B", 2);
        assertEquals(1, hashtable.size());

        assertEquals(new Integer(2), hashtable.remove("B"));
        assertEquals(0, hashtable.size());
    }

    @Test
    public void testContainsKey()
        throws DictionaryException
    {
        Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>(1);

        hashtable.put("A", 1);
        assertEquals(false, hashtable.containsKey("1"));
        assertEquals(true, hashtable.containsKey("A"));

        hashtable.remove("A");
        assertEquals(0, hashtable.size());
        assertEquals(false, hashtable.containsKey("A"));

        hashtable.put("A", 1);
        hashtable.put("B", 2);
        hashtable.put("C", 3);
        hashtable.put("D", 4);
        hashtable.put("E", 5);

        hashtable.remove("A");
        assertEquals(new Integer(2), hashtable.get("B"));
        assertEquals(new Integer(3), hashtable.get("C"));
        assertEquals(new Integer(4), hashtable.get("D"));
        assertEquals(new Integer(5), hashtable.get("E"));

        hashtable.remove("C");
        assertEquals(new Integer(2), hashtable.get("B"));
        assertEquals(new Integer(4), hashtable.get("D"));
        assertEquals(new Integer(5), hashtable.get("E"));

        hashtable.remove("E");
        assertEquals(new Integer(2), hashtable.get("B"));
        assertEquals(new Integer(4), hashtable.get("D"));

        hashtable.put("A", 11);
        assertEquals(true, hashtable.containsKey("A"));
    }
}
