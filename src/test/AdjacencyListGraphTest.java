
package test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import datastructures.adt.Graph;
import datastructures.impl.AdjacencyListGraph;
import exception.GraphException;


public class AdjacencyListGraphTest
{
    @Test
    public void testConstruct()
        throws GraphException
    {
        Graph<Integer> graph = new AdjacencyListGraph<Integer>();
    }

    @Test
    public void testNeighbors()
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

        List<Integer> connected = Arrays.asList(5, 1, 2, 6);
        int size = 0;
        for (Integer v : graph.neighbors(0)) {
            assertEquals(true, connected.contains(v));
            size += 1;
        }
        assertEquals(size, connected.size());

        connected = Arrays.asList(0);
        size = 0;
        for (Integer v : graph.neighbors(1)) {
            assertEquals(true, connected.contains(v));
            size += 1;
        }
        assertEquals(size, connected.size());

        connected = Arrays.asList(0);
        size = 0;
        for (Integer v : graph.neighbors(2)) {
            assertEquals(true, connected.contains(v));
            size += 1;
        }
        assertEquals(size, connected.size());

        connected = Arrays.asList(0, 4);
        size = 0;
        for (Integer v : graph.neighbors(6)) {
            assertEquals(true, connected.contains(v));
            size += 1;
        }
        assertEquals(size, connected.size());

        connected = Arrays.asList(4, 5);
        size = 0;
        for (Integer v : graph.neighbors(3)) {
            assertEquals(true, connected.contains(v));
            size += 1;
        }
        assertEquals(size, connected.size());

        connected = Arrays.asList(3, 6, 5);
        size = 0;
        for (Integer v : graph.neighbors(4)) {
            assertEquals(true, connected.contains(v));
            size += 1;
        }
        assertEquals(size, connected.size());

        connected = Arrays.asList(0, 3, 4);
        size = 0;
        for (Integer v : graph.neighbors(5)) {
            assertEquals(true, connected.contains(v));
            size += 1;
        }
        assertEquals(size, connected.size());
    }
}
