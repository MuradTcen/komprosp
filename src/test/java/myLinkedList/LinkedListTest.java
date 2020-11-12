package myLinkedList;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    @Test
    void add_whenAddedToLinkedList_thenEquals() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(100);
        list.add(23);
        int[] actual = list.toArray();
        int[] expected = new int[]{1, 100, 23};
        for (int i = 0; i < list.getSize(); i++) {
            assertThat(actual[i]).isEqualTo(expected[i]);
        }
    }

    @Test
    void add_whenDeletedFromLinkedList_thenEquals() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(100);
        list.add(23);
        list.delete(23);
        int[] actual = list.toArray();
        int[] expected = new int[]{1, 100};
        for (int i = 0; i < list.getSize(); i++) {
            assertThat(actual[i]).isEqualTo(expected[i]);
        }
    }

    @Test
    void addInMed() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(100);
        list.add(23);
        list.add(43);
        list.add(2, -10);
        list.add(3, -23);
        int[] actual = list.toArray();
        int[] expected = new int[]{1, 100, -10, -23, 23, 43};
        for (int i = 0; i < list.getSize(); i++) {
            assertThat(actual[i]).isEqualTo(expected[i]);
        }
    }
}
