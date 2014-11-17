
package impl;

import adt.Queue;
import exception.ListException;
import exception.QueueException;
import impl.DoublyLinkedList;


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

    public boolean isEmpty()
    {
        return list.length() == 0;
    }

    public int length()
    {
        return list.length();
    }

    public String toString()
    {
        return list.toString();
    }
}
