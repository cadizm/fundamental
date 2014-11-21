
package datastructures.impl;

import datastructures.adt.Dictionary;
import datastructures.impl.LinkedList;
import exception.DictionaryException;
import exception.ListException;


public class Hashtable<K, V>
    implements Dictionary<K, V>
{
    private static int DEFAUL_TABLE_SIZE = 1013;

    private int tableSize;
    private Object[] table;
    private int size;

    public Hashtable()
    {
        this(DEFAUL_TABLE_SIZE);
    }

    public Hashtable(int size)
    {
        tableSize = size;
        table = new Object[tableSize];
        this.size = 0;
    }

    public boolean containsKey(K key)
    {
        try {
            V value = this.get(key);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public V get(K key)
        throws DictionaryException
    {
        int index = hash(key);

        if (table[index] == null) {
            throw new DictionaryException("Get error: bad key");
        }

        @SuppressWarnings("unchecked")
        LinkedList<K, V> list = (LinkedList<K, V>)table[index];

        try {
            return list.item(key);
        }
        catch (Exception e) {
            throw new DictionaryException("Get error: bad key");
        }
    }

    public void put(K key, V value)
        throws DictionaryException
    {
        if (this.containsKey(key)) {
            this.remove(key);
        }

        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<K, V>();
        }

        @SuppressWarnings("unchecked")
        LinkedList<K, V> list = (LinkedList<K, V>)table[index];
        list.append(key, value);
        size += 1;
    }

    public V remove(K key)
        throws DictionaryException
    {
        int index = hash(key);

        if (table[index] == null) {
            throw new DictionaryException("Remove error: bad key");
        }

        @SuppressWarnings("unchecked")
        LinkedList<K, V> list = (LinkedList<K, V>)table[index];

        try {
            V value = list.delete(key);
            size -= 1;
            return value;
        }
        catch (ListException le) {
            throw new DictionaryException("Remove error: bad key");
        }
    }

    public int size()
    {
        return size;
    }

    public int hash(K key)
    {
        // mask off sign bit
        return (key.hashCode() & 0x7fffffff) % tableSize;
    }
}
