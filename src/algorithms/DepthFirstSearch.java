
package algorithms;

import java.util.Hashtable;
import java.util.Iterator;

import datastructures.adt.Graph;


public class DepthFirstSearch<T>
{
    private Graph<T> graph;
    private Hashtable<T, Boolean> visited;

    public DepthFirstSearch(Graph<T> graph)
    {
        this.graph = graph;
    }

    public void dfs(T source)
    {
        visited = new Hashtable<T, Boolean>();
        _dfs(source);
    }

    private void _dfs(T source)
    {
        Iterator<T> adjacent = graph.neighbors(source).iterator();

        while (adjacent.hasNext()) {
            T v = adjacent.next();
            Boolean visited = this.visited.get(v);
            if (visited == null || !visited.booleanValue()) {
                this.visited.put(v, true);
System.out.println("Visited: " + v.toString());
System.out.println("TODO: add action");
                _dfs(v);
            }
        }
    }
}
