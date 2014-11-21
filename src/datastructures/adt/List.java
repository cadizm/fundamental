
package datastructures.adt;

import exception.ListException;


public interface List<T>
{
    public int size();

    public void append(T obj);

    public T delete(int index)
        throws ListException;

    public T item(int index)
        throws ListException;

    public void insert(int index, T obj)
        throws ListException;
}
