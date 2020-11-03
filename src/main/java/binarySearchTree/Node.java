package binarySearchTree;

public class Node {

    private int value;
    private Node right;
    private Node left;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
