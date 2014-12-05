
package callbacks;

import datastructures.adt.Graph;


public interface BreadthFirstSearchCallback<T>
{
    public void call(Graph<T> graph, T vertex);
}
