
package test;

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

System.out.println("TODO: add test case");
System.out.println(graph.toString());
    }
}
