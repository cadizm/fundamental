
package list;

class LinkedListException
    extends Exception
{
    public LinkedListException(String err)
    {
        super(err);
    }
}


public class LinkedList<T>
{
    private Node head;

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

    public LinkedList()
    {
        head = null;
    }

    public int length()
    {
        int length = 0;
        Node runner = head;

        while (runner != null) {
            runner = runner.next;
            length += 1;
        }

        return length;
    }

    public void append(T obj)
    {
        if (head == null) {
            head = new Node(obj);
            return;
        }

        Node runner = head;
        // stop at tail
        while (runner.next != null) {
            runner = runner.next;
        }

        Node node = new Node(obj);
        runner.next = node;
    }

    public T delete(int index)
        throws LinkedListException
    {
        if (index > this.length() - 1) {
            throw new LinkedListException("Delete error: index out of bounds");
        }

        T obj = null;

        // delete head
        if (index == 0) {
            obj = head.data;
            head = head.next;
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
            return obj;
        }

        // delete interior node
        prev.next = next.next;
        obj = next.data;
        return obj;
    }

    public T item(int index)
        throws LinkedListException
    {
        if (index > this.length()) {
            throw new LinkedListException("Item error: index out of bounds");
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
        throws LinkedListException
    {
        if (index > this.length()) {
            throw new LinkedListException("Insert error: index out of bounds");
        }

        // append
        if (index == this.length()) {
            append(obj);
        }

        // adjust head
        else if (index == 0) {
            Node node = new Node(obj);
            node.next = head;
            head = node;
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

    public String toString() {
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
