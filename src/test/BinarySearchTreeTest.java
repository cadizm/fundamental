
package test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

import datastructures.adt.Dictionary;
import datastructures.impl.BinarySearchTree;
import datastructures.impl.TreeNode;
import exception.BinaryTreeException;
import exception.DictionaryException;


public class BinarySearchTreeTest
{
    @Test
    public void testConstruct()
    {
        Dictionary<Integer, String> dict = new BinarySearchTree<Integer, String>();
        assertEquals("", dict.toString());
    }

    /*
     * From: http://lcm.csa.iisc.ernet.in/dsa/node91.html
     *
     * Notice that this tree is obtained by inserting the values 13, 3, 4,
     * 12, 14, 10, 5, 1, 8, 2, 7, 9, 11, 6, 18 in that order, starting from
     * an empty tree.
     *
     * Note that inorder traversal of a binary search tree always gives a
     * sorted sequence of the values. This is a direct consequence of the BST
     * property. This provides a way of sorting a given sequence of keys:
     * first, create a BST with these keys and then do an inorder traversal of
     * the BST so created.
     *
     *                               13
     *                              /  \
     *                             3   14
     *                            / \    \
     *                           1   4   18
     *                            \   \
     *                             2  12
     *                                /
     *                               10
     *                              /  \
     *                             5   11
     *                              \
     *                              8
     *                             / \
     *                            7   9
     *                           /
     *                          6
     */
    @Test
    public void testPut()
        throws DictionaryException, BinaryTreeException
    {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();

        bst.put(13, "A");
        bst.put(3, "B");
        bst.put(4, "C");
        bst.put(12, "D");
        bst.put(14, "E");
        bst.put(10, "F");
        bst.put(5, "G");
        bst.put(1, "H");
        bst.put(8, "I");
        bst.put(2, "J");
        bst.put(7, "K");
        bst.put(9, "L");
        bst.put(11, "M");
        bst.put(6, "N");
        bst.put(18, "O");

        // test level order
        String s = "(13,A)(3,B)(14,E)(1,H)(4,C)(18,O)(2,J)(12,D)(10,F)(5,G)(11,M)(8,I)(7,K)(9,L)(6,N)";
        assertEquals(s, bst.toString());

        StringBuffer sb = new StringBuffer();
        Iterator<TreeNode<Integer, String>> iter = bst.inOrderIterator();

        while (iter.hasNext()) {
            TreeNode<Integer, String> node = iter.next();
            sb.append(node.toString());
        }

        // test (sorted) in-order
        s = "(1,H)(2,J)(3,B)(4,C)(5,G)(6,N)(7,K)(8,I)(9,L)(10,F)(11,M)(12,D)(13,A)(14,E)(18,O)";
        assertEquals(s, sb.toString());

        // test size
        assertEquals(15, bst.size());
    }

    @Test
    public void testGet()
        throws DictionaryException, BinaryTreeException
    {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();

        bst.put(13, "A");
        bst.put(3, "B");
        bst.put(4, "C");
        bst.put(12, "D");
        bst.put(14, "E");
        bst.put(10, "F");
        bst.put(5, "G");
        bst.put(1, "H");
        bst.put(8, "I");
        bst.put(2, "J");
        bst.put(7, "K");
        bst.put(9, "L");
        bst.put(11, "M");
        bst.put(6, "N");
        bst.put(18, "O");

        assertEquals("A", bst.get(13));
        assertEquals("N", bst.get(6));
        assertEquals(null, bst.get(-1));
        assertEquals(null, bst.get(19));
    }

    @Test
    public void testPredecessor()
        throws DictionaryException, BinaryTreeException
    {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();

        bst.put(13, "A");
        bst.put(3, "B");
        bst.put(4, "C");
        bst.put(12, "D");
        bst.put(14, "E");
        bst.put(10, "F");
        bst.put(5, "G");
        bst.put(1, "H");
        bst.put(8, "I");
        bst.put(2, "J");
        bst.put(7, "K");
        bst.put(9, "L");
        bst.put(11, "M");
        bst.put(6, "N");
        bst.put(18, "O");

        assertEquals(null, bst.predecessor(bst.getNode(18)));
        assertEquals(null, bst.predecessor(bst.getNode(2)));
        assertEquals(null, bst.predecessor(bst.getNode(5)));
        assertEquals(null, bst.predecessor(bst.getNode(11)));
        assertEquals(null, bst.predecessor(bst.getNode(9)));
        assertEquals(null, bst.predecessor(bst.getNode(6)));

        assertEquals("(12,D)", bst.predecessor(bst.getNode(13)).toString());
        assertEquals("(11,M)", bst.predecessor(bst.getNode(12)).toString());
        assertEquals("(7,K)", bst.predecessor(bst.getNode(8)).toString());
        assertEquals("(6,N)", bst.predecessor(bst.getNode(7)).toString());
    }

    @Test
    public void testDelete()
        throws DictionaryException, BinaryTreeException
    {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();

        bst.put(17, "A");
        bst.put(13, "B");
        bst.put(10, "C");
        bst.put(15, "D");
        bst.put( 4, "E");
        bst.put(11, "F");
        bst.put(16, "G");
        bst.put(21, "H");
        bst.put(24, "I");
        bst.put(23, "J");
        bst.put(27, "K");
        bst.put(25, "L");
        bst.put(26, "M");

        // initial tree
        String s = "(17,A)(13,B)(21,H)(10,C)(15,D)(24,I)(4,E)(11,F)(16,G)(23,J)(27,K)(25,L)(26,M)";
        assertEquals(s, bst.toString());
        assertEquals(13, bst.size());

        // remove leaf
        bst.remove(4);
        s = "(17,A)(13,B)(21,H)(10,C)(15,D)(24,I)(11,F)(16,G)(23,J)(27,K)(25,L)(26,M)";
        assertEquals(s, bst.toString());
        assertEquals(12, bst.size());

        // remove node w/ no left subtree
        bst.remove(10);
        s = "(17,A)(13,B)(21,H)(11,F)(15,D)(24,I)(16,G)(23,J)(27,K)(25,L)(26,M)";
        assertEquals(s, bst.toString());
        assertEquals(11, bst.size());

        // remove node w/ no right subtree
        bst.remove(27);
        s = "(17,A)(13,B)(21,H)(11,F)(15,D)(24,I)(16,G)(23,J)(25,L)(26,M)";
        assertEquals(s, bst.toString());
        assertEquals(10, bst.size());

        // remove node w/ both left and right subtrees
        bst.remove(13);
        s = "(17,A)(15,D)(21,H)(11,F)(16,G)(24,I)(23,J)(25,L)(26,M)";
        assertEquals(s, bst.toString());
        assertEquals(9, bst.size());

        // remove root
        bst.remove(17);
        s = "(21,H)(15,D)(24,I)(11,F)(16,G)(23,J)(25,L)(26,M)";
        assertEquals(s, bst.toString());
        assertEquals(8, bst.size());

        // remove root
        bst.remove(21);
        s = "(23,J)(15,D)(24,I)(11,F)(16,G)(25,L)(26,M)";
        assertEquals(s, bst.toString());
        assertEquals(7, bst.size());

        // remove root
        bst.remove(23);
        s = "(24,I)(15,D)(25,L)(11,F)(16,G)(26,M)";
        assertEquals(s, bst.toString());
        assertEquals(6, bst.size());

        // remove root
        bst.remove(24);
        s = "(25,L)(15,D)(26,M)(11,F)(16,G)";
        assertEquals(s, bst.toString());
        assertEquals(5, bst.size());

        // remove root
        bst.remove(25);
        s = "(26,M)(15,D)(11,F)(16,G)";
        assertEquals(s, bst.toString());
        assertEquals(4, bst.size());

        // remove root
        bst.remove(26);
        s = "(15,D)(11,F)(16,G)";
        assertEquals(s, bst.toString());
        assertEquals(3, bst.size());

        // remove root
        bst.remove(15);
        s = "(16,G)(11,F)";
        assertEquals(s, bst.toString());
        assertEquals(2, bst.size());

        // remove root
        bst.remove(16);
        s = "(11,F)";
        assertEquals(s, bst.toString());
        assertEquals(1, bst.size());

        // remove root
        bst.remove(11);
        s = "";
        assertEquals(s, bst.toString());
        assertEquals(0, bst.size());
    }
}
