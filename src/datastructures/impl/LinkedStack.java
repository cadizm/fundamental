
package datastructures.impl;

import datastructures.adt.Stack;
import datastructures.impl.DoublyLinkedList;
import exception.ListException;
import exception.StackException;


public class LinkedStack<T>
    implements Stack<T>
{
    private DoublyLinkedList<T> list;

    public LinkedStack()
    {
        list = new DoublyLinkedList<T>();
    }

    public void push(T obj)
        throws StackException
    {
        try {
            list.insert(0, obj);
        }
        catch (Exception e) {
            String s = "Push error: " + e.getMessage();
            throw new StackException(s);
        }
    }

    public T pop()
        throws StackException
    {
        try {
            return list.delete(0);
        }
        catch (ListException le) {
            String s = "Pop error: " + le.getMessage();
            throw new StackException(s);
        }
    }

    public T top()
        throws StackException
    {
        try {
            return list.item(0);
        }
        catch (ListException le) {
            String s = "Pop error: " + le.getMessage();
            throw new StackException(s);
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

    /*
     * LIFO order
     */
    public String toString()
    {
        return list.toString();
    }
}
