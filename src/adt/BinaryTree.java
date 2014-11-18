
package adt;

import java.util.Iterator;

import exception.BinaryTreeException;


public interface BinaryTree<K, V>
{
    public int size();

    public void add(K key, V value)
        throws BinaryTreeException;

    public V remove(K key)
        throws BinaryTreeException;

    public V get(K key)
        throws BinaryTreeException;

    public Iterator<?> preOrderIterator()
        throws BinaryTreeException;

    public Iterator<?> inOrderIterator()
        throws BinaryTreeException;

    public Iterator<?> postOrderIterator()
        throws BinaryTreeException;

    public Iterator<?> levelOrderIterator()
        throws BinaryTreeException;
}
