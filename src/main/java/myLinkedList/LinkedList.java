package myLinkedList;

public class LinkedList implements Methods {
    public int getSize() {
        return size;
    }

    private int size = 0;
    private Node first = null;
    private Node last = null;

    @Override
    public void add(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
            last = node;

        } else {
            node.setPrev(last);
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
    public void print() {
        Node node = first;
        System.out.println(node.getValue());
        do {
            node = node.getNext();
            System.out.println(node.getValue());
        } while (node.getNext() != null);

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);
        linkedList.print();
    }
}

