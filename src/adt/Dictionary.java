
package adt;

import exception.DictionaryException;


public interface Dictionary<K>
{
    public boolean containsKey(K key);

    public Object get(K key)
        throws DictionaryException;

    public void put(K key, Object value);

    public Object remove(K key);

    public int size();
}
