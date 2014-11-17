
package adt;

import exception.ListException;


public interface List<T>
{
    public int length();

    public void append(T obj);

    public T delete(int index)
        throws ListException;

    public T item(int index)
        throws ListException;

    public void insert(int index, T obj)
        throws ListException;
}
