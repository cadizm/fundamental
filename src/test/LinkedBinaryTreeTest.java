
package test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import impl.LinkedBinaryTree;
import exception.BinaryTreeException;


public class LinkedBinaryTreeTest
{
    @Test
    public void testCreate()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();
        assertEquals("", tree.toString());
    }

    /*
     * Implicitly tests level order traversal
     */
    @Test
    public void testAdd()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.add(1, "A");
        tree.add(2, "B");
        tree.add(3, "C");
        tree.add(4, "D");
        tree.add(5, "E");
        tree.add(6, "F");

        assertEquals("(1,A)(2,B)(3,C)(4,D)(5,E)(6,F)", tree.toString());
    }

    @Test
    public void testPreOrderTraversal()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.add(1, "A");
        tree.add(2, "B");
        tree.add(3, "C");
        tree.add(4, "D");
        tree.add(5, "E");
        tree.add(6, "F");

        StringBuffer sb = new StringBuffer();
        Iterator<LinkedBinaryTree<Integer, String>.Node> iter = tree.preOrderIterator();

        while (iter.hasNext()) {
            LinkedBinaryTree<Integer, String>.Node node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(1,A)(2,B)(4,D)(5,E)(3,C)(6,F)", sb.toString());
    }

    @Test
    public void testInOrderTraversal()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.add(1, "A");
        tree.add(2, "B");
        tree.add(3, "C");
        tree.add(4, "D");
        tree.add(5, "E");
        tree.add(6, "F");

        StringBuffer sb = new StringBuffer();
        Iterator<LinkedBinaryTree<Integer, String>.Node> iter = tree.inOrderIterator();

        while (iter.hasNext()) {
            LinkedBinaryTree<Integer, String>.Node node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(4,D)(2,B)(5,E)(1,A)(6,F)(3,C)", sb.toString());
    }

    @Test
    public void testPostOrderTraversal()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.add(1, "A");
        tree.add(2, "B");
        tree.add(3, "C");
        tree.add(4, "D");
        tree.add(5, "E");
        tree.add(6, "F");

        StringBuffer sb = new StringBuffer();
        Iterator<LinkedBinaryTree<Integer, String>.Node> iter = tree.postOrderIterator();

        while (iter.hasNext()) {
            LinkedBinaryTree<Integer, String>.Node node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(4,D)(5,E)(2,B)(6,F)(3,C)(1,A)", sb.toString());
    }
}
