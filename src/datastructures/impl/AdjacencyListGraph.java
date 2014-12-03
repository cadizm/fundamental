
package datastructures.impl;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import datastructures.adt.Graph;
import exception.GraphException;


/*
 * Standard representation for sparse (not dense) graphs
 */
public class AdjacencyListGraph<T extends Comparable<? super T>>
    implements Graph<T>
{
    private Hashtable<T, LinkedList<T>> adj;

    public AdjacencyListGraph()
    {
        adj = new Hashtable<T, LinkedList<T>>();
    }

    public boolean isAdjacent(T u, T v)
    {
        LinkedList<T> list = adj.get(u);

        if (list != null) {
            return list.indexOf(v) != -1;
        }

        return false;
    }

    public Iterable<T> neighbors(T u)
    {
        return adj.get(u);
    }

    public void addEdge(T u, T v)
        throws GraphException
    {
        LinkedList<T> ulist = adj.get(u);
        LinkedList<T> vlist = adj.get(v);

        if (ulist == null) {
            ulist = new LinkedList<T>();
            adj.put(u, ulist);
        }

        if (vlist == null) {
            vlist = new LinkedList<T>();
            adj.put(v, vlist);
        }

        // v is on u's adjacency list and u on v's
        ulist.add(v);
        vlist.add(u);
    }

    public void removeEdge(T u, T v)
        throws GraphException
    {
        LinkedList<T> ulist = adj.get(u);
        LinkedList<T> vlist = adj.get(v);

        if (ulist == null) {
            throw new GraphException("Remove Edge error: edge does not exist");
        }

        if (vlist == null) {
            throw new GraphException("Remove Edge error: malformed graph");
        }

        // v is on u's adjacency list and u on v's
        ulist.remove(v);
        vlist.remove(u);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        Iterator<T> keys = new TreeSet<T>(adj.keySet()).iterator();

        while (keys.hasNext()) {
            T u = keys.next();
            sb.append(u);
            sb.append(": ");

            LinkedList<T> list = adj.get(u);
            Collections.sort(list);

            Iterator<T> values = list.iterator();

            while (values.hasNext()) {
                T v = values.next();
                sb.append(v);
                sb.append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
