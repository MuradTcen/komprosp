package binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(10);
        binaryTree.add(6);
        binaryTree.add(15);
        System.out.println("min=" + binaryTree.getMin());
        System.out.println("max=" + binaryTree.getMax());
    }
}
