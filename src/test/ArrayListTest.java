
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import datastructures.impl.ArrayList;
import exception.ListException;


public class ArrayListTest
{
    @Test
    public void testCreate()
    {
        ArrayList<String> list = new ArrayList<String>(1);
        assertEquals("", list.toString());
    }

    @Test
    public void testAppend()
    {
        ArrayList<String> list = new ArrayList<String>(1);
        list.append("A");
        list.append("B");
        list.append("C");
        list.append("D");
        assertEquals("ABCD", list.toString());
    }

    @Test
    public void testDelete()
        throws ListException
    {
        ArrayList<String> list = new ArrayList<String>(1);
        list.append("A");
        list.append("B");
        list.append("C");
        list.append("D");

        assertEquals("B", list.delete(1));
        assertEquals("ACD", list.toString());

        assertEquals("C", list.delete(1));
        assertEquals("AD", list.toString());

        assertEquals("A", list.delete(0));
        assertEquals("D", list.toString());

        assertEquals("D", list.delete(0));
        assertEquals("", list.toString());
    }

    @Test
    public void testInsert()
        throws ListException
    {
        ArrayList<String> list = new ArrayList<String>(1);
        list.insert(0, "A");
        assertEquals("A", list.toString());

        list.insert(0, "B");
        assertEquals("BA", list.toString());

        list.insert(1, "C");
        assertEquals("BCA", list.toString());

        list.insert(1, "D");
        assertEquals("BDCA", list.toString());

        list.insert(2, "E");
        assertEquals("BDECA", list.toString());

        list.insert(4, "F");
        assertEquals("BDECFA", list.toString());

        list.insert(6, "G");
        assertEquals("BDECFAG", list.toString());

        assertEquals("E", list.delete(2));
        assertEquals("BDCFAG", list.toString());

        list.insert(4, "H");
        assertEquals("BDCFHAG", list.toString());
    }

    @Test
    public void testSwap()
        throws ListException
    {
        ArrayList<String> list = new ArrayList<String>(1);

        list.insert(0, "A");
        list.swap(0, 0);
        assertEquals("A", list.toString());


        list.insert(0, "B");
        list.swap(0, 1);
        assertEquals("AB", list.toString());

        list.insert(2, "C");
        assertEquals("ABC", list.toString());
        list.swap(0, 2);
        assertEquals("CBA", list.toString());
    }

    @Test
    public void testReverse()
        throws ListException
    {
        ArrayList<String> list = new ArrayList<String>(1);

        list.reverse();
        assertEquals("", list.toString());

        list.insert(0, "A");
        list.reverse();
        assertEquals("A", list.toString());

        list.insert(0, "B");
        assertEquals("BA", list.toString());

        list.reverse();
        assertEquals("AB", list.toString());

        list.insert(0, "C");
        assertEquals("CAB", list.toString());

        list.reverse();
        assertEquals("BAC", list.toString());

        list.append("D");
        assertEquals("BACD", list.toString());

        list.reverse();
        assertEquals("DCAB", list.toString());

        list.insert(2, "E");
        assertEquals("DCEAB", list.toString());

        list.reverse();
        assertEquals("BAECD", list.toString());
    }

    @Test
    public void testItem()
        throws ListException
    {
        ArrayList<String> list = new ArrayList<String>(1);

        list.append("A");
        assertEquals("A", list.item(0));

        list.append("B");
        assertEquals("B", list.item(1));

        list.insert(0, "C");
        assertEquals("C", list.item(0));

        list.insert(1, "D");
        assertEquals("D", list.item(1));

        list.append("E");
        assertEquals("E", list.item(list.size() - 1));
    }
}
