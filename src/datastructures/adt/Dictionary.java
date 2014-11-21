
package datastructures.adt;

import exception.DictionaryException;


public interface Dictionary<K, V>
{
    public int size();

    public boolean containsKey(K key);

    public V get(K key)
        throws DictionaryException;

    public void put(K key, V value)
        throws DictionaryException;

    public V remove(K key)
        throws DictionaryException;
}
