
package test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import algorithms.DepthFirstSearch;
import callbacks.DepthFirstSearchCallback;
import datastructures.adt.Graph;
import datastructures.impl.AdjacencyListGraph;
import exception.GraphException;


public class DepthFirstSearchTest
{
    @Test
    public void testConstruct()
        throws GraphException
    {
        Graph<Integer> graph = new AdjacencyListGraph<Integer>();
    }

    @Test
    public void testDfs()
        throws GraphException
    {
        Graph<Integer> graph = new AdjacencyListGraph<Integer>();

        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);

        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<Integer>(graph);

        dfs.dfs(0, new DepthFirstSearchCallback<Integer>() {
            List<Integer> connected = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
            public void call(Graph<Integer> graph, Integer vertex) {
                assertEquals(true, connected.contains(vertex));
            }
        });

        dfs.dfs(7, new DepthFirstSearchCallback<Integer>() {
            List<Integer> connected = Arrays.asList(7, 8);
            public void call(Graph<Integer> graph, Integer vertex) {
                assertEquals(true, connected.contains(vertex));
            }
        });

        dfs.dfs(9, new DepthFirstSearchCallback<Integer>() {
            List<Integer> connected = Arrays.asList(9, 10, 11, 12);
            public void call(Graph<Integer> graph, Integer vertex) {
                assertEquals(true, connected.contains(vertex));
            }
        });
    }
}
