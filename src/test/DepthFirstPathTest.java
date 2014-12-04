
package test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import algorithms.DepthFirstSearch;
import algorithms.DepthFirstPath;
import callbacks.DepthFirstSearchCallback;
import datastructures.adt.Graph;
import datastructures.impl.AdjacencyListGraph;
import exception.GraphException;


public class DepthFirstPathTest
{
    @Test
    public void testConstruct()
        throws GraphException
    {
        Graph<Integer> graph = new AdjacencyListGraph<Integer>();
    }

    @Test
    public void testPathTo()
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

        DepthFirstPath<Integer> dfs = new DepthFirstPath<Integer>(graph, 0);

        assertEquals(null, dfs.pathTo(7));
        assertEquals(null, dfs.pathTo(8));
        assertEquals(null, dfs.pathTo(9));
        assertEquals(null, dfs.pathTo(10));
        assertEquals(null, dfs.pathTo(11));
        assertEquals(null, dfs.pathTo(12));

        Iterator<Integer> iter = dfs.pathTo(6).iterator();
        StringBuffer sb = new StringBuffer();

        while (iter.hasNext()) {
            Integer v = iter.next();
            sb.append(v);
        }

        assertEquals("0546", sb.toString());
    }
}
