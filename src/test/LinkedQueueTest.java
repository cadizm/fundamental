
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import impl.LinkedQueue;
import exception.QueueException;


public class LinkedQueueTest
{
    @Test
    public void testCreate()
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
    public void testLength()
        throws QueueException
    {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        assertEquals(0, queue.length());

        queue.enqueue("A");
        assertEquals(1, queue.length());

        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals(3, queue.length());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(0, queue.length());
    }
}
