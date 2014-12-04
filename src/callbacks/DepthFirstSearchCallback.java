
package callbacks;

import datastructures.adt.Graph;


public interface DepthFirstSearchCallback<T>
{
    public void call(Graph<T> graph, T vertex);
}
