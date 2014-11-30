
package datastructures.impl;

import datastructures.adt.Dictionary;
import datastructures.impl.LinkedBinaryTree;
import exception.DictionaryException;


public class BinarySearchTree<K extends Comparable<? super K>, V>
    extends LinkedBinaryTree<K, V>
    implements Dictionary<K, V>
{
    public BinarySearchTree()
    {
        super();
    }

    public boolean containsKey(K key)
    {
        return get(key) != null ? true : false;
    }

    public V get(K key)
    {
        TreeNode<K, V> node = getNode(root, key);

        return node != null ? node.value : null;
    }

    public TreeNode<K, V> getNode(K key)
    {
        return getNode(root, key);
    }

    private TreeNode<K, V> getNode(TreeNode<K, V> node, K key)
    {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);

        // key is < node's key
        if (compare < 0) {
            return getNode(node.left, key);
        }
        // key is > node's key
        else if (compare > 0) {
            return getNode(node.right, key);
        }
        // found our key
        else {
            return node;
        }
    }

    public void put(K key, V value)
        throws DictionaryException
    {
        root = put(root, key, value);
    }

    private TreeNode<K, V> put(TreeNode<K, V> node, K key, V value)
        throws DictionaryException
    {
        if (node == null) {
            size++;
            return new TreeNode<K, V>(key, value);
        }

        int compare = key.compareTo(node.key);

        // key to be inserted is < node's key
        if (compare < 0) {
            node.left = put(node.left, key, value);
        }
        // key to be inserted is > node's key
        else if (compare > 0) {
            node.right = put(node.right, key, value);
        }
        // replace this node's value
        else {
            node.value = value;
        }

        return node;
    }

    /*
     * Increased running time to support `get' ADT
     */
    public V remove(K key)
    {
        V value = get(key);

        if (value != null) {
            root = removeNode(root, key);
            size--;
            return value;
        }

        return null;
    }

    private TreeNode<K, V> removeNode(TreeNode<K, V> node, K key)
    {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);

        // key to delete is < node's key
        if (compare < 0) {
            node.left = removeNode(node.left, key);
        }
        // key to delete is > node's key
        else if (compare > 0) {
            node.right = removeNode(node.right, key);
        }
        // we found the key to delete
        else {
            // node has no left subtree
            if (node.left == null) {
                node = node.right;
            }
            // node has no left subtree
            else if (node.right == null) {
                node = node.left;
            }
            else {
                TreeNode<K, V> deleted = node;
                // replace this node w/ its successor.
                node = successor(deleted);
                // set node's right to deleted node's `min' node
                node.right = removeMinNode(deleted.right);
                // set node's left to deleted node's left
                // **NOTE** assignment must be made after node.right
                node.left = deleted.left;
            }
        }

        return node;
    }

    // remove node's min descendent if it exists; its right subtree otherwise
    private TreeNode<K, V> removeMinNode(TreeNode<K, V> node)
    {
        if (node.left == null) {
            return node.right;
        }

        node.left = removeMinNode(node.left);

        return node;
    }

    public TreeNode<K, V> predecessor(TreeNode<K, V> node)
    {
        if (node == null) {
            throw new RuntimeException("Predecessor error: null param");
        }

        return max(node.left);
    }

    public TreeNode<K, V> successor(TreeNode<K, V> node)
    {
        if (node == null) {
            throw new RuntimeException("Successor error: null param");
        }

        return min(node.right);
    }

    public TreeNode<K, V> min(TreeNode<K, V> node)
    {
        if (node == null) {
            return null;
        }
        else if (node.left == null) {
            return node;
        }
        else {
            return min(node.left);
        }
    }

    public TreeNode<K, V> max(TreeNode<K, V> node)
    {
        if (node == null) {
            return null;
        }
        else if (node.right == null) {
            return node;
        }
        else {
            return max(node.right);
        }
    }
}
