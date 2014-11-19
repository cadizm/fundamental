
package datastructures.impl;

import datastructures.adt.List;
import exception.ListException;


public class DoublyLinkedList<T>
    implements List<T>
{
    private Node head;
    private Node tail;
    private int length;

    class Node
    {
        T data;
        Node next;
        Node prev;

        public Node(T obj)
        {
            data = obj;
            prev = next = null;
        }
    }

    public DoublyLinkedList()
    {
        head = tail = null;
    }

    public int length()
    {
        return length;
    }

    public void append(T obj)
    {
        if (head == null) {
            head = tail = new Node(obj);
            length += 1;
            return;
        }

        Node node = new Node(obj);

        tail.next = node;
        node.prev = tail;
        tail = node;
        length += 1;
    }

    public T delete(int index)
        throws ListException
    {
        if (index > length - 1) {
            throw new ListException("Delete error: index out of bounds");
        }

        T obj = null;

        // delete head
        if (index == 0) {
            obj = head.data;
            head = head.next;
            if (head == null) {
                tail = head;
            }
            else {
                head.prev = null;
            }
            length -= 1;
            return obj;
        }

        // delete tail
        else if (index == length - 1) {
            obj = tail.data;
            tail = tail.prev;
            tail.next = null;
            length -= 1;
            return obj;
        }

        // delete interior
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

            prev.next = next.next;
            prev.next.prev = prev;
            obj = next.data;
            length -= 1;
            return obj;
        }
    }

    public T item(int index)
        throws ListException
    {
        if (index > length) {
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

    public void insert(int index, T obj)
        throws ListException
    {
        if (index > length) {
            throw new ListException("Insert error: index out of bounds");
        }

        // append
        if (index == length) {
            append(obj);
        }

        // adjust head (at least 1 node)
        else if (index == 0) {
            Node node = new Node(obj);
            node.next = head;
            head.prev = node;
            head = node;
            length += 1;
        }

        // insert interior node
        else {
            Node prev = head;
            Node next = head.next;

            int i = 0;
            while (i != index - 1) {
                i += 1;
                prev = next;
                next = next.next;
            }

            Node node = new Node(obj);

            prev.next = node;
            next.prev = node;

            node.prev = prev;
            node.next = next;
            length += 1;
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

    public String reversedToString()
    {
        if (head == null) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        Node runner = tail;

        while (runner != head) {
            sb.append(runner.data.toString());
            runner = runner.prev;
        }

        // append head
        sb.append(runner.data.toString());

        return sb.toString();
    }
}
