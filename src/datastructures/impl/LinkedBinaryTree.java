
package datastructures.impl;

import java.util.Iterator;

import datastructures.adt.BinaryTree;
import datastructures.adt.Queue;
import datastructures.adt.Stack;
import datastructures.impl.LinkedQueue;
import datastructures.impl.LinkedStack;
import exception.BinaryTreeException;
import exception.QueueException;
import exception.StackException;


public class LinkedBinaryTree<K, V>
    implements BinaryTree<K, V>
{
    public TreeNode<K, V> root;
    protected int size;

    public LinkedBinaryTree()
    {
        root = null;
        size = 0;
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
        if (root == null) {
            root = new TreeNode<K, V>(key, value);
            size += 1;
            return;
        }

        Iterator<TreeNode<K, V>> iter = this.levelOrderIterator();

        while (iter.hasNext()) {
            TreeNode<K, V> node = iter.next();
            if (node.left == null) {
                node.left = new TreeNode<K, V>(key, value);
                size += 1;
                break;
            }
            else if (node.right == null) {
                node.right = new TreeNode<K, V>(key, value);
                size += 1;
                break;
            }
        }
    }

    public V remove(K key)
        throws BinaryTreeException
    {
        Iterator<TreeNode<K, V>> iter = this.levelOrderIterator();

        while (iter.hasNext()) {
            TreeNode<K, V> node = iter.next();
            TreeNode<K, V> parent = parent(node);

            if (node.key.equals(key)) {
                // remove root node
                if (parent == null) {
                    if (node.left != null) {
                        root = node.left;
                        if (node.right != null) {
                            this.add(node.right.key, node.right.value);
                        }
                    }
                    else if (node.right != null) {
                        root = node.right;
                        if (node.left != null) {
                            this.add(node.left.key, node.left.value);
                        }
                    }
                    else {
                        root = null;
                    }
                }
                // remove leaf node
                else if (node.left == null && node.right == null) {
                    if (parent.left == node) {
                        parent.left = null;
                    }
                    else {
                        parent.right = null;
                    }
                }
                // remove internal node
                else {
                    if (parent.left == node) {
                        if (node.left != null) {
                            parent.left = node.left;
                            if (node.right != null) {
                                this.add(node.right.key, node.right.value);
                            }
                        }
                        else {
                            parent.left = node.right;
                            if (node.left != null) {
                                this.add(node.left.key, node.left.value);
                            }
                        }
                    }
                    else {
                        if (node.left != null) {
                            parent.right = node.left;
                            if (node.right != null) {
                                this.add(node.right.key, node.right.value);
                            }
                        }
                        else {
                            parent.right = node.right;
                            if (node.left != null) {
                                this.add(node.left.key, node.left.value);
                            }
                        }
                    }
                }

                size -= 1;
                return node.value;
            }
        }

        throw new BinaryTreeException("Remove error: key not found");
    }

    public TreeNode<K, V> parent(TreeNode<K, V> child)
        throws BinaryTreeException
    {
        Iterator<TreeNode<K, V>> iter = this.levelOrderIterator();

        while (iter.hasNext()) {
            TreeNode<K, V> node = iter.next();
            if (node.left != null && node.left == child) {
                return node;
            }
            else if (node.right != null && node.right == child) {
                return node;
            }
        }

        return null;
    }

    public V get(K key)
        throws BinaryTreeException
    {
        Iterator<TreeNode<K, V>> iter = this.levelOrderIterator();

        while (iter.hasNext()) {
            TreeNode<K, V> node = iter.next();
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        throw new BinaryTreeException("Get error: key not found");
    }

    /*
     * **DFS** traversal: visit current, then left, then right nodes
     */
    public Iterator<TreeNode<K, V>> preOrderIterator()
        throws BinaryTreeException
    {
        return new PreOrderIterator();
    }

    /*
     * **DFS** traversal: visit left, then current, then right nodes
     */
    public Iterator<TreeNode<K, V>> inOrderIterator()
        throws BinaryTreeException
    {
        return new InOrderIterator();
    }

    /*
     * **DFS** traversal: visit left, then right, then current nodes
     */
    public Iterator<TreeNode<K, V>> postOrderIterator()
        throws BinaryTreeException
    {
        return new PostOrderIterator();
    }

    /*
     * **BFS** traversal
     */
    public Iterator<TreeNode<K, V>> levelOrderIterator()
        throws BinaryTreeException
    {
        return new LevelOrderIterator();
    }

    /*
     * TreeNodes concatenated in level order
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        try {
            Iterator<TreeNode<K, V>> iter = this.levelOrderIterator();
            while (iter.hasNext()) {
                TreeNode<K, V> node = iter.next();
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
        implements Iterator<TreeNode<K, V>>
    {
        private Stack<TreeNode<K, V>> stack;

        public PreOrderIterator()
            throws BinaryTreeException
        {
            stack = new LinkedStack<TreeNode<K, V>>();
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

        public TreeNode<K, V> next()
        {
            try {
                TreeNode<K, V> node = stack.pop();
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

        public void remove()
        {
            throw new RuntimeException("Not implemented");
        }
    }

    /*
     * **DFS** traversal: visit left, then current, then right nodes
     */
    private class InOrderIterator
        implements Iterator<TreeNode<K, V>>
    {
        private Stack<TreeNode<K, V>> stack;

        public InOrderIterator()
            throws BinaryTreeException
        {
            stack = new LinkedStack<TreeNode<K, V>>();
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

        public TreeNode<K, V> next()
        {
            try {
                TreeNode<K, V> node = stack.pop();

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

        public void remove()
        {
            throw new RuntimeException("Not implemented");
        }
    }

    /*
     * **DFS** traversal: visit left, then current, then right nodes
     */
    private class PostOrderIterator
        implements Iterator<TreeNode<K, V>>
    {
        private Stack<TreeNode<K, V>> stack;

        public PostOrderIterator()
            throws BinaryTreeException
        {
            stack = new LinkedStack<TreeNode<K, V>>();
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

        private void P(TreeNode<K, V> node)
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

        public TreeNode<K, V> next()
        {
            try {
                return stack.pop();
            }
            catch (Exception e) {
                return null;
            }
        }

        public void remove()
        {
            throw new RuntimeException("Not implemented");
        }
    }

    private class LevelOrderIterator
        implements Iterator<TreeNode<K, V>>
    {
        private Queue<TreeNode<K, V>> queue;

        public LevelOrderIterator()
            throws BinaryTreeException
        {
            queue = new LinkedQueue<TreeNode<K, V>>();
            Q(root);
        }

        private void Q(TreeNode<K, V> node)
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

        public TreeNode<K, V> next()
        {
            try {
                TreeNode<K, V> node = queue.dequeue();
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

        public void remove()
        {
            throw new RuntimeException("Not implemented");
        }
    }
}
