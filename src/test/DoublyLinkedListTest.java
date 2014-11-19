
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import datastructures.impl.DoublyLinkedList;
import exception.ListException;


public class DoublyLinkedListTest
{
    @Test
    public void testCreate()
    {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        assertEquals("", list.toString());
    }

    @Test
    public void testAppend()
    {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();

        list.append("A");
        assertEquals("A", list.toString());
        assertEquals("A", list.reversedToString());
        list.append("B");
        list.append("C");
        list.append("D");

        assertEquals("ABCD", list.toString());
        assertEquals("DCBA", list.reversedToString());
    }

    @Test
    public void testDelete()
        throws ListException
    {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.append("A");
        assertEquals("A", list.toString());
        assertEquals("A", list.reversedToString());
        list.append("B");
        list.append("C");
        list.append("D");

        assertEquals("A", list.delete(0));
        assertEquals("BCD", list.toString());
        assertEquals("DCB", list.reversedToString());

        assertEquals("C", list.delete(1));
        assertEquals("BD", list.toString());
        assertEquals("DB", list.reversedToString());

        assertEquals("D", list.delete(1));
        assertEquals("B", list.toString());
        assertEquals("B", list.reversedToString());

        assertEquals("B", list.delete(0));
        assertEquals("", list.toString());
        assertEquals("", list.reversedToString());

        list.append("B");
        list.append("C");
        assertEquals("BC", list.toString());
        assertEquals("CB", list.reversedToString());

        assertEquals("C", list.delete(1));
        assertEquals("B", list.toString());
        assertEquals("B", list.reversedToString());

        assertEquals("B", list.delete(0));
        assertEquals("", list.toString());
        assertEquals("", list.reversedToString());
    }

    @Test
    public void testInsert()
        throws ListException
    {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.insert(0, "A");
        assertEquals("A", list.toString());
        assertEquals("A", list.reversedToString());

        list.insert(0, "B");
        assertEquals("BA", list.toString());
        assertEquals("AB", list.reversedToString());

        list.insert(0, "C");
        assertEquals("CBA", list.toString());
        assertEquals("ABC", list.reversedToString());

        list.insert(1, "D");
        assertEquals("CDBA", list.toString());
        assertEquals("ABDC", list.reversedToString());

        list.insert(4, "E");
        assertEquals("CDBAE", list.toString());
        assertEquals("EABDC", list.reversedToString());

        list.insert(4, "F");
        assertEquals("CDBAFE", list.toString());
        assertEquals("EFABDC", list.reversedToString());

        list.insert(6, "G");
        assertEquals("CDBAFEG", list.toString());
        assertEquals("GEFABDC", list.reversedToString());
    }

    @Test
    public void testItem()
        throws ListException
    {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();

        list.append("A");
        assertEquals("A", list.item(0));

        list.append("B");
        assertEquals("B", list.item(1));

        list.insert(0, "C");
        assertEquals("C", list.item(0));

        list.insert(1, "D");
        assertEquals("D", list.item(1));

        list.append("E");
        assertEquals("E", list.item(list.length() - 1));
    }
}
