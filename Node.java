package binaryTree;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Rajah on 3/18/2017.
 * Node is the basic element of a binary tree. It takes a type.
 * @param <T>   a non-primitive Type, such as Integer or String
 */
public class Node<T> {
    private Node<T> lChild=null;
    private Node<T> rChild=null;
    private T val;
    private static final Logger LOGGER = Logger.getLogger(Node.class.getName());

    /**
     * Creator for a node, setting the value. lChild and rChild are null.
     * @param val   value of type T.
     */
    public Node(T val) {
        this.val = val;
    }

    /**
     * Getter for the left child.
     * @return  a Node (or null if there is none).
     */
    public Node<T> getlChild() {
        return lChild;
    }

    /**
     * Setter for the left child.
     * @param lChild a Node.
     */
    public void setlChild(Node<T> lChild) {
        this.lChild = lChild;
    }

    /**
     * Getter for the right child.
     * @return  a Node (or null if there is none).
     */
    public Node<T> getrChild() {
        return rChild;
    }

    /**
     * Setter for the right child.
     * @param rChild a Node.
     */
    public void setrChild(Node<T> rChild) {
        this.rChild = rChild;
    }

    /**
     * Getter for the node's value.
     * @return  value of type T.
     */
    public T getVal() {
        return val;
    }

    /**
     * Setter for the node's value.
     * @param val value of type T.
     */
    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +  "val=" + val + '}';
    }

    public void printNode() {
        LOGGER.info(toString());
    }

    /**
     * Recursively print the tree from the given node. (This prints top-down.)
     */
    public void printTree() {
        printNode();
        if (getlChild() != null) {
            getlChild().printTree();
        }
        if (getrChild() != null) {
            getrChild().printTree();
        }
    }

    /**
     * Recursively print the tree in-order. This is depth first.
     */
    public void printTree_Depth() {
        if (getlChild() != null) {
            getlChild().printTree_Depth();
        }
        printNode();
        if (getrChild() != null) {
            getrChild().printTree_Depth();
        }
    }

    /**
     * Given an empty List answer, create an in-order List of the values.
     * @param answer Empty List, which will be appended with all Node values in-order.
     */
    public void inOrder(List<T> answer) {
        if (getlChild() != null) {
            getlChild().inOrder(answer);
        }
        answer.add(getVal());
        if (getrChild() != null) {
            getrChild().inOrder(answer);
        }

    }

    /**
     * Recursively mirror the left and the right children.
     */
    public void mirrorTree() {
        if (getlChild() != null) {
            getlChild().mirrorTree();
        }
        if (getrChild() != null) {
            getrChild().mirrorTree();
        }
        swapChildren();
    }

    /**
     * Swap the left and the right children of this node.
     */
    private void swapChildren() {
        Node<T> temp = getlChild();
        setlChild(getrChild());
        setrChild(temp);
    }
}
