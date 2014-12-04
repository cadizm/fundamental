
package algorithms;

import java.util.Hashtable;
import java.util.Iterator;

import callbacks.DepthFirstSearchCallback;
import datastructures.adt.Graph;


public class DepthFirstSearch<T>
{
    protected Graph<T> graph;
    protected Hashtable<T, Boolean> visited;

    public DepthFirstSearch(Graph<T> graph)
    {
        this.graph = graph;
    }

    public void dfs(T source, DepthFirstSearchCallback<T> callback)
    {
        visited = new Hashtable<T, Boolean>();
        _dfs(source, callback);
    }

    protected void _dfs(T source, DepthFirstSearchCallback<T> callback)
    {
        Iterator<T> adjacent = graph.neighbors(source).iterator();

        while (adjacent.hasNext()) {
            T v = adjacent.next();
            Boolean visited = this.visited.get(v);
            if (visited == null || !visited.booleanValue()) {
                callback.call(graph, v);
                this.visited.put(v, true);
                _dfs(v, callback);
            }
        }
    }
}
