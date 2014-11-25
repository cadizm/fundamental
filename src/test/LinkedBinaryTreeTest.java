
package test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import datastructures.impl.LinkedBinaryTree;
import datastructures.impl.TreeNode;
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
    public void testPreOrderTraversal1()
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
        Iterator<TreeNode<Integer, String>> iter = tree.preOrderIterator();

        while (iter.hasNext()) {
            TreeNode<Integer, String> node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(1,A)(2,B)(4,D)(5,E)(3,C)(6,F)", sb.toString());
    }

    @Test
    public void testPreOrderTraversal2()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.root = new TreeNode<Integer, String>(1, "F");
        tree.root.left = new TreeNode<Integer, String>(2, "B");
        tree.root.left.left = new TreeNode<Integer, String>(3, "A");
        tree.root.left.right = new TreeNode<Integer, String>(4, "D");
        tree.root.left.right.left = new TreeNode<Integer, String>(5, "C");
        tree.root.left.right.right = new TreeNode<Integer, String>(6, "E");
        tree.root.right = new TreeNode<Integer, String>(7, "G");
        tree.root.right.right = new TreeNode<Integer, String>(8, "I");
        tree.root.right.right.left = new TreeNode<Integer, String>(9, "H");

        StringBuffer sb = new StringBuffer();
        Iterator<TreeNode<Integer, String>> iter = tree.preOrderIterator();

        while (iter.hasNext()) {
            TreeNode<Integer, String> node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(1,F)(2,B)(3,A)(4,D)(5,C)(6,E)(7,G)(8,I)(9,H)", sb.toString());
    }

    @Test
    public void testInOrderTraversal1()
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
        Iterator<TreeNode<Integer, String>> iter = tree.inOrderIterator();

        while (iter.hasNext()) {
            TreeNode<Integer, String> node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(4,D)(2,B)(5,E)(1,A)(6,F)(3,C)", sb.toString());
    }

    @Test
    public void testInOrderTraversal2()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.root = new TreeNode<Integer, String>(1, "F");
        tree.root.left = new TreeNode<Integer, String>(2, "B");
        tree.root.left.left = new TreeNode<Integer, String>(3, "A");
        tree.root.left.right = new TreeNode<Integer, String>(4, "D");
        tree.root.left.right.left = new TreeNode<Integer, String>(5, "C");
        tree.root.left.right.right = new TreeNode<Integer, String>(6, "E");
        tree.root.right = new TreeNode<Integer, String>(7, "G");
        tree.root.right.right = new TreeNode<Integer, String>(8, "I");
        tree.root.right.right.left = new TreeNode<Integer, String>(9, "H");

        StringBuffer sb = new StringBuffer();
        Iterator<TreeNode<Integer, String>> iter = tree.inOrderIterator();

        while (iter.hasNext()) {
            TreeNode<Integer, String> node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(3,A)(2,B)(5,C)(4,D)(6,E)(1,F)(7,G)(9,H)(8,I)", sb.toString());
    }

    @Test
    public void testPostOrderTraversal1()
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
        Iterator<TreeNode<Integer, String>> iter = tree.postOrderIterator();

        while (iter.hasNext()) {
            TreeNode<Integer, String> node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(4,D)(5,E)(2,B)(6,F)(3,C)(1,A)", sb.toString());
    }

    @Test
    public void testPostOrderTraversal2()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.root = new TreeNode<Integer, String>(1, "F");
        tree.root.left = new TreeNode<Integer, String>(2, "B");
        tree.root.left.left = new TreeNode<Integer, String>(3, "A");
        tree.root.left.right = new TreeNode<Integer, String>(4, "D");
        tree.root.left.right.left = new TreeNode<Integer, String>(5, "C");
        tree.root.left.right.right = new TreeNode<Integer, String>(6, "E");
        tree.root.right = new TreeNode<Integer, String>(7, "G");
        tree.root.right.right = new TreeNode<Integer, String>(8, "I");
        tree.root.right.right.left = new TreeNode<Integer, String>(9, "H");

        StringBuffer sb = new StringBuffer();
        Iterator<TreeNode<Integer, String>> iter = tree.postOrderIterator();

        while (iter.hasNext()) {
            TreeNode<Integer, String> node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(3,A)(5,C)(6,E)(4,D)(2,B)(9,H)(8,I)(7,G)(1,F)", sb.toString());
    }

    @Test
    public void testLevelOrderTraversal()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.root = new TreeNode<Integer, String>(1, "F");
        tree.root.left = new TreeNode<Integer, String>(2, "B");
        tree.root.left.left = new TreeNode<Integer, String>(3, "A");
        tree.root.left.right = new TreeNode<Integer, String>(4, "D");
        tree.root.left.right.left = new TreeNode<Integer, String>(5, "C");
        tree.root.left.right.right = new TreeNode<Integer, String>(6, "E");
        tree.root.right = new TreeNode<Integer, String>(7, "G");
        tree.root.right.right = new TreeNode<Integer, String>(8, "I");
        tree.root.right.right.left = new TreeNode<Integer, String>(9, "H");

        StringBuffer sb = new StringBuffer();
        Iterator<TreeNode<Integer, String>> iter = tree.levelOrderIterator();

        while (iter.hasNext()) {
            TreeNode<Integer, String> node = iter.next();
            sb.append(node.toString());
        }

        assertEquals("(1,F)(2,B)(7,G)(3,A)(4,D)(8,I)(5,C)(6,E)(9,H)", sb.toString());
        assertEquals("(1,F)(2,B)(7,G)(3,A)(4,D)(8,I)(5,C)(6,E)(9,H)", tree.toString());
    }

    @Test
    public void testRemoveRoot()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.add(1, "A");
        tree.add(2, "B");
        tree.add(3, "C");
        tree.add(4, "D");
        tree.add(5, "E");
        assertEquals("(1,A)(2,B)(3,C)(4,D)(5,E)", tree.toString());

        tree.remove(1);
        assertEquals("(2,B)(4,D)(5,E)(3,C)", tree.toString());

        tree.remove(2);
        assertEquals("(4,D)(3,C)(5,E)", tree.toString());

        tree.remove(4);
        assertEquals("(3,C)(5,E)", tree.toString());

        tree.remove(3);
        assertEquals("(5,E)", tree.toString());

        tree.remove(5);
        assertEquals("", tree.toString());
    }

    @Test
    public void testRemoveLeaves()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.add(1, "A");
        tree.add(2, "B");
        tree.add(3, "C");
        tree.add(4, "D");
        tree.add(5, "E");
        assertEquals("(1,A)(2,B)(3,C)(4,D)(5,E)", tree.toString());

        tree.remove(4);
        assertEquals("(1,A)(2,B)(3,C)(5,E)", tree.toString());

        tree.remove(3);
        assertEquals("(1,A)(2,B)(5,E)", tree.toString());

        tree.remove(5);
        assertEquals("(1,A)(2,B)", tree.toString());

        tree.remove(2);
        assertEquals("(1,A)", tree.toString());

        tree.remove(1);
        assertEquals("", tree.toString());
    }

    @Test
    public void testRemoveInternal()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.add(1, "A");
        tree.add(2, "B");
        tree.add(3, "C");
        tree.add(4, "D");
        tree.add(5, "E");
        assertEquals("(1,A)(2,B)(3,C)(4,D)(5,E)", tree.toString());

        tree.remove(2);
        assertEquals("(1,A)(4,D)(3,C)(5,E)", tree.toString());

        tree.remove(4);
        assertEquals("(1,A)(5,E)(3,C)", tree.toString());

        tree.add(6, "F");
        tree.add(7, "G");
        tree.add(8, "H");
        tree.add(9, "I");
        assertEquals("(1,A)(5,E)(3,C)(6,F)(7,G)(8,H)(9,I)", tree.toString());

        tree.remove(3);
        assertEquals("(1,A)(5,E)(8,H)(6,F)(7,G)(9,I)", tree.toString());

        tree.remove(8);
        assertEquals("(1,A)(5,E)(9,I)(6,F)(7,G)", tree.toString());

        tree.remove(5);
        assertEquals("(1,A)(6,F)(9,I)(7,G)", tree.toString());

        tree.remove(6);
        assertEquals("(1,A)(7,G)(9,I)", tree.toString());

        tree.remove(1);
        assertEquals("(7,G)(9,I)", tree.toString());

        tree.remove(9);
        assertEquals("(7,G)", tree.toString());

        tree.remove(7);
        assertEquals("", tree.toString());
    }

    @Test(expected=BinaryTreeException.class)
    public void testRemoveException()
        throws BinaryTreeException
    {
        LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<Integer, String>();

        tree.add(1, "A");
        tree.add(2, "B");
        tree.add(3, "C");
        tree.add(4, "D");
        tree.add(5, "E");

        tree.remove(6);
    }
}
