
package datastructures.impl;

import datastructures.adt.List;
import exception.ListException;


public class ArrayList<T>
    implements List<T>
{
    private static int DEFAULT_LENGTH = 10;

    private T[] buf;
    private int size;

    public ArrayList()
    {
        this(DEFAULT_LENGTH);
    }

    /*
     * Notes on generic arrays
     * http://courses.cs.washington.edu/courses/cse332/10sp/otherNotes/genericArrays.html
     */
    public ArrayList(int length)
    {
        if (length < 1) {
            length = DEFAULT_LENGTH;
        }

        @SuppressWarnings("unchecked")
        T[] _buf = (T[])new Object[length];
        buf = _buf;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public void append(T obj)
    {
        if (size + 1 >= buf.length) {
            this.resize();
        }

        buf[size++] = obj;
    }

    public T delete(int index)
        throws ListException
    {
        if (index < 0 || index >= size) {
            throw new ListException("Delete error: index out of bounds");
        }

        if (index == size - 1) {
            return buf[--size];
        }
        else {
            T obj = buf[index];
            // shift contents left
            for (int i = index; i < size; ++i) {
                buf[i] = buf[i + 1];
            }
            size -= 1;
            return obj;
        }
    }

    public T item(int index)
        throws ListException
    {
        if (index < 0 || index >= size) {
            throw new ListException("Item error: index out of bounds");
        }

        return buf[index];
    }

    public void insert(int index, T obj)
        throws ListException
    {
        if (size + 1 >= buf.length) {
            this.resize();
        }

        if (index == size) {
            append(obj);
            return;
        }
        else if (index < 0 || index > size) {
            throw new ListException("Insert error: index out of bounds");
        }
        else {
            // shift contents right
            for (int i = size; i > index; --i) {
                buf[i] = buf[i - 1];
            }
            buf[index] = obj;
            size += 1;
        }
    }

    /**
     * In-place reversal
     */
    public void reverse()
        throws ListException
    {
        if (size <= 1) {
            return;
        }

        int i = 0;
        int j = size - 1;

        while (i < j) {
            swap(i++, j--);
        }
    }

    public void swap(int i, int j)
        throws ListException
    {
        if (i < 0 || i >= size) {
            String s = String.format("Swap error: index `%d' out of bounds", i);
            throw new ListException(s);
        }
        else if (j < 0 || j >= size) {
            String s = String.format("Swap error: index `%d' out of bounds", j);
            throw new ListException(s);
        }

        T tmp = buf[i];
        buf[i] = buf[j];
        buf[j] = tmp;
    }

    private void resize()
    {
        int length = buf.length * 2;

        @SuppressWarnings("unchecked")
        T[] _buf = (T[])new Object[length];

        for (int i = 0; i < size; ++i) {
            _buf[i] = buf[i];
        }

        buf = _buf;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < size; ++i) {
            sb.append(buf[i].toString());
        }

        return sb.toString();
    }
}
