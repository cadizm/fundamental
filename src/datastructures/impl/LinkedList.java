
package datastructures.impl;

import datastructures.adt.List;
import exception.ListException;


public class LinkedList<K, T>
    implements List<T>
{
    private Node head;
    private int size;

    class Node
    {
        K key;
        T data;
        Node next;

        public Node(T obj)
        {
            this(null, obj);
        }

        public Node(K key, T obj)
        {
            this.key = key;
            data = obj;
            next = null;
        }
    }

    public LinkedList()
    {
        head = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public void append(T obj)
    {
        this.append(null, obj);
    }

    public void append(K key, T obj)
    {
        if (head == null) {
            head = new Node(key, obj);
            size += 1;
            return;
        }

        Node runner = head;
        // stop at tail
        while (runner.next != null) {
            runner = runner.next;
        }

        Node node = new Node(key, obj);
        runner.next = node;
        size += 1;
    }

    public T delete(int index)
        throws ListException
    {
        if (index > this.size() - 1) {
            throw new ListException("Delete error: index out of bounds");
        }

        T obj = null;

        // delete head
        if (index == 0) {
            obj = head.data;
            head = head.next;
            size -= 1;
            return obj;
        }

        int i = 0;
        // "start" at index 1
        Node prev = head;
        Node next = head.next;
        while (i != index - 1) {
            i += 1;
            prev = next;
            next = next.next;
        }

        // delete tail
        if (next.next == null) {
            prev.next = null;
            obj = next.data;
            size -= 1;
            return obj;
        }

        // delete interior node
        prev.next = next.next;
        obj = next.data;
        size -= 1;
        return obj;
    }

    public T delete(K key)
        throws ListException
    {
        T obj = null;

        // delete head
        if (head.key.equals(key)) {
            obj = head.data;
            head = head.next;
            size -= 1;
            return obj;
        }

        int i = 0;
        // "start" at index 1
        Node prev = head;
        Node next = head.next;
        while (!next.key.equals(key) && i != this.size() - 1) {
            i += 1;
            prev = next;
            next = next.next;
        }

        if (!next.key.equals(key)) {
            throw new ListException("Delete error: bad key");
        }

        // delete tail
        if (next.next == null) {
            prev.next = null;
            obj = next.data;
            size -= 1;
            return obj;
        }

        // delete interior node
        prev.next = next.next;
        obj = next.data;
        size -= 1;
        return obj;
    }

    public T item(int index)
        throws ListException
    {
        if (index > size) {
            throw new ListException("Item error: index out of bounds");
        }

        int i = 0;
        Node runner = head;
        while (i != index) {
            i += 1;
            runner = runner.next;
        }

        return runner.data;
    }

    public T item(K key)
        throws ListException
    {
        if (head == null) {
            throw new ListException("Item error: bad key");
        }

        Node runner = head;

        while (runner != null) {
            if (key.equals(runner.key)) {
                return runner.data;
            }
            runner = runner.next;
        }

        throw new ListException("Item error: bad key");
    }

    public void insert(int index, T obj)
        throws ListException
    {
        if (index > size) {
            throw new ListException("Insert error: index out of bounds");
        }

        // append
        if (index == size) {
            append(obj);
        }

        // adjust head
        else if (index == 0) {
            Node node = new Node(obj);
            node.next = head;
            head = node;
            size += 1;
        }

        // interior
        else {
            int i = 0;
            // "start" at index 1
            Node prev = head;
            Node next = head.next;
            while (i != index - 1) {
                i += 1;
                prev = next;
                next = next.next;
            }
            Node node = new Node(obj);
            prev.next = node;
            node.next = next;
            size += 1;
        }
    }

    /**
     * In-place reversal
     */
    public void reverse()
    {
        if (head == null) {
            return;
        }

        Node prev = null;
        Node next = head.next;

        while (true) {
            head.next = prev;
            prev = head;
            if (next == null) {
                break;
            }
            head = next;
            next = head.next;
        }
    }

    public String toString()
    {
        if (head == null) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        Node runner = head;

        while (runner != null) {
            sb.append(runner.data.toString());
            runner = runner.next;
        }

        return sb.toString();
    }
}
