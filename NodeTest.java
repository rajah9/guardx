package binaryTree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Rajah on 3/18/2017.
 */
public class NodeTest extends TestCase {
    private static final Logger LOGGER = Logger.getLogger(Node.class.getName());

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public NodeTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( NodeTest.class );
    }

    public void testNode() {
        int theAnswer=42;
        Node t = new Node<Integer>(theAnswer);
        t.printNode();
        assertEquals(t.getVal(), theAnswer);
    }

    private Node<String> smallTree() {
        Node<String> root = new Node<String> ("root");
        Node<String> left = new Node<String> ("left");
        Node<String> right = new Node<String> ("right");

        root.setlChild(left);
        root.setrChild(right);
        return root;
    }

    /**
     * Set up a sorted, binary tree of Integers.
     *                      0
     *                  /       \
     *              -5            5
     *             /   \        /   \
     *          -7     -3      3     7
     *          /\     /\     /\     /\
     *        -8  6  -4  2   2 4    6  8
     *
     * @return Root node of tree
     */
    private Node<Integer> bigTree() {
        Node<Integer> root = new Node<Integer> (0);
        Node<Integer> m5 = new Node<Integer> (-5);
        Node<Integer> m7 = new Node<Integer> (-7);
        Node<Integer> m8 = new Node<Integer> (-8);
        Node<Integer> m6 = new Node<Integer> (-6);
        Node<Integer> m3 = new Node<Integer> (-3);
        Node<Integer> m4 = new Node<Integer> (-4);
        Node<Integer> m2 = new Node<Integer> (-2);

        Node<Integer> p5 = new Node<Integer> (5);
        Node<Integer> p7 = new Node<Integer> (7);
        Node<Integer> p8 = new Node<Integer> (8);
        Node<Integer> p6 = new Node<Integer> (6);
        Node<Integer> p3 = new Node<Integer> (3);
        Node<Integer> p4 = new Node<Integer> (4);
        Node<Integer> p2 = new Node<Integer> (2);

        root.setlChild(m5);
        m5.setlChild(m7);
        m5.setrChild(m3);
        m7.setlChild(m8);
        m7.setrChild(m6);
        m3.setlChild(m4);
        m3.setrChild(m2);

        root.setrChild(p5);
        p5.setlChild(p3);
        p5.setrChild(p7);
        p3.setlChild(p2);
        p3.setrChild(p4);
        p7.setlChild(p6);
        p7.setrChild(p8);
        return root;
    }

    private Node<Integer> mediumTree() {
        Node<Integer> root = new Node<Integer> (0);
        Node<Integer> m5 = new Node<Integer> (-5);
        Node<Integer> m7 = new Node<Integer> (-7);
        Node<Integer> m3 = new Node<Integer> (-3);

        Node<Integer> p5 = new Node<Integer> (5);
        Node<Integer> p7 = new Node<Integer> (7);
        Node<Integer> p3 = new Node<Integer> (3);

        root.setlChild(m5);
        m5.setlChild(m7);
        m5.setrChild(m3);

        root.setrChild(p5);
        p5.setlChild(p3);
        p5.setrChild(p7);
        return root;
    }

    public void testTree() {
        Node<String> t = smallTree();
        t.printTree();
        assertEquals("left", t.getlChild().getVal());
        assertEquals("right", t.getrChild().getVal());
    }

    public void testPrintTree_Depth() {
        LOGGER.info("Starting testPrintTree_Depth. Nodes should print in ascending order.");
        Node t = mediumTree();
        t.printTree_Depth();
        LOGGER.info("Ending testPrintTree_Depth.");
    }


    public void testMirrorTreeSmall() {
        Node t = smallTree();
        t.mirrorTree();
        assertEquals("right", t.getlChild().getVal());
        assertEquals("left", t.getrChild().getVal());
    }

    public void testMirrorTreeLarge() {
        Node t = bigTree();
        LOGGER.info("Starting testMirrorTreeLarge. After mirror, nodes should print in descending order.");
        t.mirrorTree();
        t.printTree_Depth();
        LOGGER.info("Ending testMirrorTreeLarge.");
    }

    public void testMirrorTreeLarge2() {
        Node<Integer> t = bigTree();
        LOGGER.info("Starting testMirrorTreeLarge2.");
        t.mirrorTree(); // should now be in descending order
        ArrayList<Integer> ans = new ArrayList<Integer>();
        t.inOrder(ans);
        Integer prev = Integer.MAX_VALUE;
        for (Integer val: ans
                ) {
            assertTrue(val < prev);
            prev=val;
        }
        LOGGER.info("Ending testMirrorTreeLarge2.");
    }

    public void testInOrder() {
        Node<Integer> t = bigTree();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        t.inOrder(ans);
        Integer prev = Integer.MIN_VALUE;
        for (Integer val: ans
             ) {
            assertTrue(val > prev);
            prev=val;
        }
    }
}

