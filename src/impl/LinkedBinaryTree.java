
package impl;

import java.util.Iterator;

import adt.BinaryTree;
import adt.Queue;
import adt.Stack;
import exception.BinaryTreeException;
import exception.QueueException;
import exception.StackException;
import impl.LinkedQueue;
import impl.LinkedStack;


public class LinkedBinaryTree<K, V>
    implements BinaryTree<K, V>
{
    private Node root;
    private int size;
    /*
     * Using queue since we add nodes in level order
     */
    private Queue<Node> queue;

    public class Node
    {
        K key;
        V value;
        boolean visited;

        Node left;
        Node right;

        public Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.visited = false;
        }

        public String toString()
        {
            return String.format("(%s,%s)", key.toString(), value.toString());
        }
    }

    public LinkedBinaryTree()
    {
        root = null;
        size = 0;
        queue = new LinkedQueue<Node>();
    }

    public int size()
    {
        return size;
    }

    /*
     * Add in level (Breadth First) order
     */
    public void add(K key, V value)
        throws BinaryTreeException
    {
        try {
            if (root == null) {
                root = new Node(key, value);
                queue.enqueue(root);
            }
            else {
                while (!queue.isEmpty()) {
                    Node node = queue.peek();
                    if (node.left == null) {
                        node.left = new Node(key, value);
                        queue.enqueue(node.left);
                        break;
                    }
                    else if (node.right == null) {
                        node.right = new Node(key, value);
                        queue.enqueue(node.right);
                        break;
                    }
                    else {
                        queue.dequeue();
                    }
                }
            }
        }
        catch (QueueException qe) {
            String s = "Add error: " + qe.getMessage();
            throw new BinaryTreeException(s);
        }
    }

    /*
     * TODO:
     */
    public V remove(K key)
        throws BinaryTreeException
    {
        return null;
    }

    /*
     * TODO:
     */
    public V get(K key)
        throws BinaryTreeException
    {
        return null;
    }

    /*
     * **DFS** traversal: visit current, then left, then right nodes
     */
    public Iterator<Node> preOrderIterator()
        throws BinaryTreeException
    {
        return new PreOrderIterator();
    }

    /*
     * **DFS** traversal: visit left, then current, then right nodes
     */
    public Iterator<Node> inOrderIterator()
        throws BinaryTreeException
    {
        return new InOrderIterator();
    }

    /*
     * **DFS** traversal: visit left, then right, then current nodes
     */
    public Iterator<Node> postOrderIterator()
        throws BinaryTreeException
    {
        return new PostOrderIterator();
    }

    /*
     * **BFS** traversal
     */
    public Iterator<Node> levelOrderIterator()
        throws BinaryTreeException
    {
        return new LevelOrderIterator();
    }

    /*
     * Nodes concatenated in level order
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        try {
            Iterator<Node> iter = this.levelOrderIterator();
            while (iter.hasNext()) {
                Node node = iter.next();
                sb.append(node.toString());
            }
        }
        catch (Exception e) {
            return null;
        }

        return sb.toString();
    }

    /*
     * **DFS** traversal: visit current, then left, then right nodes
     */
    private class PreOrderIterator
        implements Iterator<Node>
    {
        private Stack<Node> stack;

        public PreOrderIterator()
            throws BinaryTreeException
        {
            stack = new LinkedStack<Node>();
            try {
                stack.push(root);
            }
            catch (StackException se) {
                throw new BinaryTreeException(se.getMessage());
            }
        }

        public boolean hasNext()
        {
            return !stack.isEmpty();
        }

        public Node next()
        {
            try {
                Node node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                return node;
            }
            catch (Exception e) {
                return null;
            }
        }

        /*
         * Not implemented
         */
        public void remove() {}
    }

    /*
     * **DFS** traversal: visit left, then current, then right nodes
     */
    private class InOrderIterator
        implements Iterator<Node>
    {
        private Stack<Node> stack;

        public InOrderIterator()
            throws BinaryTreeException
        {
            stack = new LinkedStack<Node>();
            try {
                if (root != null) {
                    stack.push(root);
                }
            }
            catch (StackException se) {
                throw new BinaryTreeException(se.getMessage());
            }
        }

        public boolean hasNext()
        {
            return !stack.isEmpty();
        }

        public Node next()
        {
            try {
                Node node = stack.pop();

                while (node != null && !node.visited) {
                    stack.push(node);
                    node = node.left;
                }

                node = stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                }

                node.visited = true;
                return node;
            }
            catch (Exception e) {
                return null;
            }
        }

        /*
         * Not implemented
         */
        public void remove() {}
    }

    /*
     * **DFS** traversal: visit left, then current, then right nodes
     */
    private class PostOrderIterator
        implements Iterator<Node>
    {
        private Stack<Node> stack;

        public PostOrderIterator()
            throws BinaryTreeException
        {
            stack = new LinkedStack<Node>();
            try {
                if (root != null) {
                    stack.push(root);
                    P(root);
                }
            }
            catch (StackException se) {
                throw new BinaryTreeException(se.getMessage());
            }
        }

        private void P(Node node)
            throws StackException
        {
            if (node == null) {
                return;
            }

            if (node.right != null) {
                stack.push(node.right);
                P(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
                P(node.left);
            }
        }

        public boolean hasNext()
        {
            return !stack.isEmpty();
        }

        public Node next()
        {
            try {
                return stack.pop();
            }
            catch (Exception e) {
                return null;
            }
        }

        /*
         * Not implemented
         */
        public void remove() {}
    }

    private class LevelOrderIterator
        implements Iterator<Node>
    {
        private Queue<Node> queue;

        public LevelOrderIterator()
            throws BinaryTreeException
        {
            queue = new LinkedQueue<Node>();
            Q(root);
        }

        private void Q(Node node)
            throws BinaryTreeException
        {
            if (node == null) {
                return;
            }
            try {
                queue.enqueue(node);
            }
            catch (QueueException qe) {
                throw new BinaryTreeException(qe.getMessage());
            }
        }

        public boolean hasNext()
        {
            return !queue.isEmpty();
        }

        public Node next()
        {
            try {
                Node node = queue.dequeue();
                if (node.left != null) {
                    Q(node.left);
                }
                if (node.right != null) {
                    Q(node.right);
                }
                return node;
            }
            catch (Exception e) {
                return null;
            }
        }

        /*
         * Not implemented
         */
        public void remove() {}
    }
}
