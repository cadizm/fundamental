
package algorithms;

import java.util.Hashtable;
import java.util.LinkedList;

import algorithms.DepthFirstSearch;
import callbacks.DepthFirstSearchCallback;
import datastructures.adt.Graph;


public class DepthFirstPath<T>
    extends DepthFirstSearch<T>
{
    /*
     * Given key v in graph G, parent.get(v) returns the vertex u
     * discovered in the dfs traversal of G (i.e., the `edge to' v
     */
    private Hashtable<T, T> parent;

    /*
     * Source vertex for this DFS instance
     */
    private T source;

    public DepthFirstPath(Graph<T> graph, T source)
    {
        super(graph);
        parent = new Hashtable<T, T>();
        this.source = source;

        super.dfs(source, new DepthFirstSearchCallback<T>() {
            public void call(Graph<T> graph, T vertex) {
                // do nothing
            }
        });
    }

    public Iterable<T> pathTo(T v)
    {
        T u = parent.get(v);

        if (u == null) {
            return null;
        }

        LinkedList<T> list = new LinkedList<T>();
        list.add(0, v);

        while (u != source) {
            list.add(0, u);
            u = parent.get(u);
        }

        list.add(0, source);

        return list;
    }

    public void dfs(T source, DepthFirstSearchCallback<T> callback)
    {
        String err = "Error: not implemented. dfs call implicit in constructor";
        throw new RuntimeException(err);
    }

    protected void _dfs(T source, DepthFirstSearchCallback<T> callback)
    {
        for (T v : graph.adjacent(source)) {
            // so we don't visit source vertex
            if (v.equals(this.source)) {
                continue;
            }
            Boolean visited = this.visited.get(v);
            if (visited == null || !visited.booleanValue()) {
                callback.call(graph, v);
                this.visited.put(v, true);
                parent.put(v, source);
                _dfs(v, callback);
            }
        }
    }
}
