
package datastructures.adt;

import exception.PriorityQueueException;


/*
 * `Lower' values given higher priority
 */
public interface PriorityQueue<T>
{
    public void insert(T obj)
        throws PriorityQueueException;

    public T deleteMin()
        throws PriorityQueueException;

    public T findMin()
        throws PriorityQueueException;

    public boolean isEmpty();

    public int size();
}
