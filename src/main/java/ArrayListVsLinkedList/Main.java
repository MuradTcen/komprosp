package ArrayListVsLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {

    private static final int ALL_COUNT = 1000_000;
    private static final int GET_ITER = 100000;

    public static void main(String[] args) {
        withoutStream();
        withStreams();
    }

    private static void withoutStream() {
        List<Double> linkedList = new LinkedList<>();
        List<Double> arrayList = new ArrayList<>();

        for (int i = 0; i < ALL_COUNT; i++) {
            linkedList.add(Math.random());
            arrayList.add(Math.random());
        }

        long s = System.nanoTime();

        for (int i = 0; i < GET_ITER; i++) {
            linkedList.get((int) Math.random() * (GET_ITER - 1));
        }
        System.out.println("withoutStream linkedList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));

        s = System.nanoTime();

        for (int i = 0; i < GET_ITER; i++) {
            arrayList.get((int) Math.random() * (GET_ITER - 1));
        }
        System.out.println("withoutStream arrayList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));

    }

    private static void withStreams() {
        List<Double> linkedList = DoubleStream.generate(Math::random)
                .limit(ALL_COUNT)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        List<Double> doubles = new Random()
                .doubles()
                .limit(ALL_COUNT)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.print("withStreams ");
        fixTime(linkedList);

        System.out.print("withStreams ");
        fixTime(doubles);
    }

    private static void fixTime(List<Double> list) {
        long s = System.nanoTime();
        IntStream.rangeClosed(0, GET_ITER).forEach(x -> list.get(((int) (Math.random() * (GET_ITER - 1)))));

        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));
    }
}
