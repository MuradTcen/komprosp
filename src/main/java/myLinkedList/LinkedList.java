package myLinkedList;

import java.util.NoSuchElementException;

public class LinkedList implements Methods {
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
        return node(index).getValue();
    }

    @Override
    public void delete(int value) {
        if (first.getValue() == value) {
            first = first.getNext();
            if (first == null) {
                last = null;
            } else
                first.setPrev(null);

        } else if (last.getValue() == value) {
            last = last.getPrev();
            last.setNext(null);

        } else {
            Node tempNode = first;
            while (tempNode != null) {
                tempNode = tempNode.getNext();
                if ((tempNode != null) && (tempNode.getValue() == value))
                    break;
            }
            if (tempNode != null) {
                tempNode.getPrev().setNext(tempNode.getNext());
                tempNode.getNext().setPrev(tempNode.getPrev());
                tempNode.setPrev(null);
                tempNode.setNext(null);
            } else throw new NoSuchElementException();
        }
        size--;
    }

    @Override
    public void add(int index, int value) {
        Node findNode = node(index - 1);
        Node insertNode = new Node(value);
        insertNode.setPrev(findNode);
        insertNode.setNext(findNode.getNext());
        findNode.getNext().setPrev(findNode);
        findNode.setNext(insertNode);
        size++;
    }

    private Node node(int index) {
        Node element = first;
        if ((index < size) && (first != null)) {
            int count = 0;
            while (element != null) {
                if (count == index) {
                    break;
                }
                element = element.getNext();
                count++;

            }
            return element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void deleteIndex(int index) {
        Node findNode = node(index);
        if (findNode == first) {
            first = first.getNext();
            first.setPrev(null);

        } else if (findNode == last) {
            last = last.getPrev();
            last.setNext(null);

        } else {
            findNode.getPrev().setNext(findNode.getNext());
            findNode.getNext().setPrev(findNode.getPrev());
            findNode.setPrev(null);
            findNode.setNext(null);

        }
        size--;
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[size];
        int i = 0;
        Node node = first;
        while (node != null) {
            arr[i] = node.getValue();
            i++;
            node = node.getNext();
        }
        return arr;
    }

    @Override
    public void print() {
        Node node = first;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);
        // linkedList.deleteIndex(7);
        //linkedList.print();
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(1));

    }
}

