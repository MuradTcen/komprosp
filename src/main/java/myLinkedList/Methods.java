package myLinkedList;

public interface Methods {
    void add(int value);

    int get(int index);

    void delete(int value);

    void add(int index, int value);

    void deleteIndex(int index);

    int[] toArray();

    void print();
}
