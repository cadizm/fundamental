
package datastructures.adt;

import exception.StackException;


public interface Stack<T>
{
    public void push(T obj)
        throws StackException;

    public T pop()
        throws StackException;

    public T top()
        throws StackException;

    public boolean isEmpty();

    public int size();
}
