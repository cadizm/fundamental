
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import datastructures.impl.LinkedQueue;
import exception.QueueException;


public class LinkedQueueTest
{
    @Test
    public void testConstruct()
    {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        assertEquals("", queue.toString());
    }

    @Test
    public void testEnqueueDequeue()
        throws QueueException
    {
        LinkedQueue<String> queue = new LinkedQueue<String>();

        queue.enqueue("A");
        assertEquals("A", queue.toString());

        assertEquals("A", queue.dequeue());
        assertEquals("", queue.toString());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals("A", queue.dequeue());

        queue.enqueue("D");
        assertEquals("B", queue.dequeue());

        queue.enqueue("E");
        assertEquals("CDE", queue.toString());
    }

    @Test
    public void testIsEmpty()
        throws QueueException
    {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        assertEquals(true, queue.isEmpty());

        queue.enqueue("A");
        assertEquals(false, queue.isEmpty());

        queue.enqueue("B");
        queue.enqueue("C");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testSize()
        throws QueueException
    {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        assertEquals(0, queue.size());

        queue.enqueue("A");
        assertEquals(1, queue.size());

        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals(3, queue.size());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(0, queue.size());
    }
}
