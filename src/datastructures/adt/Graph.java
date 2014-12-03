
package datastructures.adt;

import exception.GraphException;


public interface Graph<T>
{
    /*
     * Is there an edge from u to v
     */
    public boolean isAdjacent(T u, T v);

    /*
     * Return all vertices v such that there is an edge from u to v
     * (i.e., u's adjacent vertices)
     */
    public Iterable<T> neighbors(T u);

    /*
     * Add edge from Vertex u to Vertex v
     */
    public void addEdge(T u, T v)
        throws GraphException;

    /*
     * Remove edge from Vertex u to Vertex v
     */
    public void removeEdge(T u, T v)
        throws GraphException;
}
