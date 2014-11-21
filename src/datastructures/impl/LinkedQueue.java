
package datastructures.impl;

import datastructures.adt.Queue;
import datastructures.impl.DoublyLinkedList;
import exception.ListException;
import exception.QueueException;


public class LinkedQueue<T>
    implements Queue<T>
{
    private DoublyLinkedList<T> list;

    public LinkedQueue()
    {
        list = new DoublyLinkedList<T>();
    }

    public void enqueue(T obj)
        throws QueueException
    {
        try {
            list.append(obj);
        }
        catch (Exception e) {
            String s = "Enqueue error: " + e.getMessage();
            throw new QueueException(s);
        }
    }

    public T dequeue()
        throws QueueException
    {
        try {
            return list.delete(0);
        }
        catch (ListException le) {
            String s = "Dequeue error: " + le.getMessage();
            throw new QueueException(s);
        }
    }

    public T peek()
        throws QueueException
    {
        try {
            return list.item(0);
        }
        catch (ListException le) {
            String s = "Peek error: " + le.getMessage();
            throw new QueueException(s);
        }
    }

    public boolean isEmpty()
    {
        return list.size() == 0;
    }

    public int size()
    {
        return list.size();
    }

    public String toString()
    {
        return list.toString();
    }
}
