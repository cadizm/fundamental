
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import impl.Hashtable;
import exception.DictionaryException;


public class HashtableTest
{
    @Test
    public void testPut()
        throws DictionaryException
    {
        Hashtable<String> hashtable = new Hashtable<String>();
        hashtable.put("A", "A");
        assertEquals("A", hashtable.get("A"));

        hashtable.put("B", "A");
        assertEquals("A", hashtable.get("B"));

        assertEquals(2, hashtable.size());
    }
}
