
package impl;

import adt.Dictionary;
import impl.LinkedList;
import exception.DictionaryException;


/**
 * Can't create arrays of parameterized types
 * https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createArrays
 *
 * Key type K needs valid hashCode() implementation
 */
public class Hashtable<K>
    implements Dictionary<K>
{
    private static int DEFAUL_TABLE_SIZE = 1;

    private int tableSize;
    private Object[] table;
    private int size;

    public Hashtable()
    {
        tableSize = DEFAUL_TABLE_SIZE;
        table = new Object[tableSize];
        size = 0;
    }

    public boolean containsKey(K key)
    {
        try {
            Object value = this.get(key);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Object get(K key)
        throws DictionaryException
    {
        int index = hash(key);

        if (table[index] == null) {
            return null;
        }

        @SuppressWarnings("unchecked")
        LinkedList<K, Object> list = (LinkedList<K, Object>)table[index];

        try {
            return list.item(key);
        }
        catch (Exception e) {
            throw new DictionaryException("Get error: bad key");
        }
    }

    public void put(K key, Object value)
    {
        if (this.containsKey(key)) {
            this.remove(key);
        }

        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<K, Object>();
        }

        @SuppressWarnings("unchecked")
        LinkedList<K, Object> list = (LinkedList<K, Object>)table[index];
        list.append(key, value);
        size += 1;
    }

    // TODO:
    public Object remove(K key)
    {
        return null;
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

    private void resize()
    {
        tableSize *= 2;
        Object[] newTable = new Object[tableSize];

        for (int i = 0; i < table.length; ++i) {
            newTable[i] = table[i];
        }

        table = newTable;
    }

}
