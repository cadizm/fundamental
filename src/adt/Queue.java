
package adt;

import exception.QueueException;


public interface Queue<T>
{
    public void enqueue(T obj)
        throws QueueException;

    public T dequeue()
        throws QueueException;

    public T peek()
        throws QueueException;

    public boolean isEmpty();

    public int length();
}
