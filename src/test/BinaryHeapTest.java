
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
    public void testCreate()
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

        heap.insert(new Integer(5));
        assertEquals("(5)", heap.toString());

        heap.insert(new Integer(3));
        assertEquals("(3)(5)", heap.toString());

        heap.insert(new Integer(1));
        assertEquals("(1)(5)(3)", heap.toString());

        heap.insert(new Integer(2));
        assertEquals("(1)(2)(3)(5)", heap.toString());
    }

    // TODO:
    @Test
    public void testDeleteMin()
        throws PriorityQueueException
    {
    }
}
