
package datastructures.impl;

import java.util.Comparator;

import datastructures.adt.PriorityQueue;
import exception.PriorityQueueException;


/*
 * Value of any node is less than or equal to that of its children
 */
public class BinaryHeap<T>
    implements PriorityQueue<T>
{
    private static int DEFAULT_LENGTH = 10;

    private T[] buf;
    private int size;
    private Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator)
    {
        this(comparator, DEFAULT_LENGTH);
    }

    /*
     * Private constructor, comparator required
     */
    private BinaryHeap() {}

    public BinaryHeap(Comparator<T> comparator, int length)
    {
        if (length < 1) {
            length = DEFAULT_LENGTH;
        }

        this.comparator = comparator;

        // Our array represents a complete binary tree
        // index 0 unused to simplify indexing; given index i:
        //   left child at position: 2i
        //   right child at position: 2i + 1
        //   parent at position: floor(i / 2)
        @SuppressWarnings("unchecked")
        T[] _buf = (T[])new Object[length + 1];
        buf = _buf;
        size = 0;
    }

    public void insert(T obj)
        throws PriorityQueueException
    {
        if (size + 1 >= buf.length) {
            this.resize();
        }

        buf[++size] = obj;
        bubbleUp();
    }

    public T deleteMin()
        throws PriorityQueueException
    {
        if (size == 0) {
            throw new PriorityQueueException("Find min error: queue emtpy");
        }

        T obj = buf[1];  // min at index 1, not 0
        buf[1] = buf[size--];
        siftDown();

        return obj;
    }

    public T findMin()
        throws PriorityQueueException
    {
        if (size == 0) {
            throw new PriorityQueueException("Find min error: queue emtpy");
        }

        return buf[1];  // min at index 1, not 0
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    private void resize()
    {
        int length = buf.length * 2;

        @SuppressWarnings("unchecked")
        T[] _buf = (T[])new Object[length];

        for (int i = 1; i <= size; ++i) {
            _buf[i] = buf[i];
        }

        buf = _buf;
    }

    private void bubbleUp()
        throws PriorityQueueException
    {
        int i = size;
        int j = i / 2;

        // child.compareTo(parent)
        while (j > 0 && comparator.compare(buf[i], buf[j]) < 0) {
            swap(i, j);
            i = j;
            j /= 2;
        }
    }

    private void siftDown()
        throws PriorityQueueException
    {
        int i = 1;
        int j = 2 * i;
        int k = j + 1;

        // if we have a smaller right child
        if (k <= size && comparator.compare(buf[k], buf[j]) < 0) {
            j = k;
        }

        // parent.compareTo(child)
        while (j <= size && comparator.compare(buf[i], buf[j]) > 0) {
            swap(i, j);
            i = j;
            j *= 2;
            k = j + 1;
            if (k <= size && comparator.compare(buf[k], buf[j]) < 0) {
                j = k;
            }
        }
    }

    private void swap(int i, int j)
        throws PriorityQueueException
    {
        if (i < 1 || i > size) {
            String s = String.format("Swap error: index `%d' out of bounds", i);
            throw new PriorityQueueException(s);
        }
        else if (j < 1 || j > size) {
            String s = String.format("Swap error: index `%d' out of bounds", j);
            throw new PriorityQueueException(s);
        }

        T tmp = buf[i];
        buf[i] = buf[j];
        buf[j] = tmp;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= size; ++i) {
            sb.append("(");
            sb.append(buf[i].toString());
            sb.append(")");
        }

        return sb.toString();
    }
}
