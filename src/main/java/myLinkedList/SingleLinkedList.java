package myLinkedList;

public class SingleLinkedList implements Methods {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void add(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
            last = node;
        }
        size++;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public void delete(int value) {

    }

    @Override
    public void add(int index, int value) {

    }

    @Override
    public void deleteIndex(int index) {


    }

    @Override
    public int[] toArray() {
        return new int[0];
    }

    @Override
    public void print() {
        Node node = first;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }

    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.add(10);
        singleLinkedList.print();

    }
}
