
package test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import algorithms.BreadthFirstSearch;
import callbacks.BreadthFirstSearchCallback;
import datastructures.adt.Graph;
import datastructures.impl.AdjacencyListGraph;
import exception.GraphException;


public class BreadthFirstSearchTest
{
    @Test
    public void testConstruct()
        throws GraphException
    {
        Graph<Integer> graph = new AdjacencyListGraph<Integer>();
    }

    @Test
    public void testBfs()
        throws GraphException
    {
        Graph<Integer> graph = new AdjacencyListGraph<Integer>();

        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);

        BreadthFirstSearch<Integer> bfs;
        bfs = new BreadthFirstSearch<Integer>(graph, 0,
            new BreadthFirstSearchCallback<Integer>() {
                public void call(Graph<Integer> graph, Integer vertex)
                {
                }
            }
        );

        assertEquals("[0, 2, 4]", bfs.pathTo(4).toString());
    }
}
