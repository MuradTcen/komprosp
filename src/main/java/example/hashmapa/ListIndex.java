package example.hashmapa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListIndex {
    private static final int LEN = 10000;
    private static final int MAX = 20;
    private static final int MIN = -20;

    public static List getIndex(List<Integer> arrayList, Integer number) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < LEN; i++) {
            final Integer key = arrayList.get(i);
            List<Integer> listIndexes = hashMap.getOrDefault(key, new ArrayList<>());
            listIndexes.add(i);
            hashMap.put(key, listIndexes);
        }

        return hashMap.get(number);
    }

    public static void main(String[] args) {
        List<Integer> integers = new Random().ints(MIN, MAX + 1).limit(LEN).boxed().collect(Collectors.toList());

        System.out.println(getIndex(integers, 15));
    }
}
