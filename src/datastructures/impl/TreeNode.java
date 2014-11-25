
package datastructures.impl;

public class TreeNode<K, V>
{
    K key;
    V value;
    boolean visited;

    public TreeNode<K, V> left;
    public TreeNode<K, V> right;

    public TreeNode(K key, V value)
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
