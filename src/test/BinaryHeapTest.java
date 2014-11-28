
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import datastructures.impl.BinaryHeap;
import exception.PriorityQueueException;
import util.NaturalComparator;


public class BinaryHeapTest
{
    @Test
    public void testConstruct()
    {
        NaturalComparator<Integer> comparator = new NaturalComparator<Integer>();
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(comparator, 1);

        assertEquals("", heap.toString());
    }

    @Test
    public void testInsert()
        throws PriorityQueueException
    {
        NaturalComparator<Integer> comparator = new NaturalComparator<Integer>();
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(comparator, 1);

        heap.insert(5);
        assertEquals("(5)", heap.toString());

        heap.insert(3);
        assertEquals("(3)(5)", heap.toString());

        heap.insert(1);
        assertEquals("(1)(5)(3)", heap.toString());

        heap.insert(2);
        assertEquals("(1)(2)(3)(5)", heap.toString());
    }

    @Test
    public void testDeleteMin()
        throws PriorityQueueException
    {
        NaturalComparator<Integer> comparator = new NaturalComparator<Integer>();
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(comparator, 1);

        heap.insert(0);
        heap.insert(3);
        heap.insert(-1);
        heap.insert(-2);
        heap.insert(3);
        assertEquals("(-2)(-1)(0)(3)(3)", heap.toString());

        assertEquals(new Integer(-2), heap.deleteMin());
        assertEquals("(-1)(3)(0)(3)", heap.toString());

        assertEquals(new Integer(-1), heap.deleteMin());
        assertEquals("(0)(3)(3)", heap.toString());

        assertEquals(new Integer(0), heap.deleteMin());
        assertEquals("(3)(3)", heap.toString());

        assertEquals(new Integer(3), heap.deleteMin());
        assertEquals("(3)", heap.toString());

        assertEquals(new Integer(3), heap.deleteMin());
        assertEquals("", heap.toString());
    }
}
