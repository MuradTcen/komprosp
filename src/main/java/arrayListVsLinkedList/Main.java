package arrayListVsLinkedList;

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

//        fixTimeDeleteInEnd();
//        fixTimeDeleteInBegin();
//        fixTimeDeleteInMid();
        // fixTimeAdd();
        // fixTimeAddInBegin();
        fixTimeAddInMid();
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

    private static void fixTimeDeleteInEnd() {
        long s = System.nanoTime();
        List<Double> listArray = getArrayList();
        for (int i = ALL_COUNT - 1; i > GET_ITER; i--) {
            listArray.remove(i);
        }
        System.out.println("fixTimeDeleteInEnd ArrayList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));

        s = System.nanoTime();
        List<Double> linkedList = getArrayList();
        for (int i = ALL_COUNT - 1; i > GET_ITER; i--) {
            linkedList.remove(i);
        }
        System.out.println("fixTimeDeleteInEnd LinkedList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));
    }

    private static void fixTimeDeleteInBegin() {
        long s = System.nanoTime();
        ArrayList<Double> listArray = getArrayList();
        for (int i = 0; i < GET_ITER; i++) {
            listArray.remove(0);
        }
        System.out.println("fixTimeDeleteInBegin ArrayList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));

        s = System.nanoTime();
        LinkedList<Double> linkedList = getLinkedList();
        for (int i = 0; i < GET_ITER; i++) {
            linkedList.pollFirst();
        }
        System.out.println("fixTimeDeleteInBegin LinkedList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));
    }


    private static void fixTimeDeleteInMid() {
        long s = System.nanoTime();
        List<Double> listArray = getArrayList();
        for (int i = ALL_COUNT / 2; i < (ALL_COUNT / 2) + GET_ITER; i++) {
            listArray.remove(ALL_COUNT / 2);
        }
        System.out.println("fixTimeDeleteInMid ArrayList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));

        s = System.nanoTime();
        List<Double> linkedList = getLinkedList();
        for (int i = ALL_COUNT / 2; i < (ALL_COUNT / 2) + GET_ITER; i++) {
            linkedList.remove(i);
        }
        System.out.println("fixTimeDeleteInMid LinkedList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));
    }


    private static void fixTimeAdd() {
        List<Double> linkedList = getLinkedList();
        long s = System.nanoTime();
        for (int i = 0; i < ALL_COUNT; i++) {
            linkedList.add(Math.random());
        }
        System.out.println("fixTimeAdd LinkedList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));


        List<Double> listArray = getArrayList();

        s = System.nanoTime();
        for (int i = 0; i < ALL_COUNT; i++) {
            listArray.add(Math.random());
        }
        System.out.println("fixTimeAdd ArrayList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));

    }

    private static void fixTimeAddInBegin() {
        List<Double> linkedList = getLinkedList();
        long s = System.nanoTime();
        for (int i = 0; i < GET_ITER; i++) {
            linkedList.add(0, Math.random());
        }
        System.out.println("fixTimeAddInBegin LinkedList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));


        List<Double> listArray = getArrayList();

        s = System.nanoTime();
        for (int i = 0; i < GET_ITER; i++) {
            listArray.add(0, Math.random());
        }
        System.out.println("fixTimeAddInBegin ArrayList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));

    }

    private static void fixTimeAddInMid() {
        List<Double> linkedList = getLinkedList();
        long s = System.nanoTime();
        for (int i = ALL_COUNT / 2; i < ALL_COUNT / 2 + GET_ITER; i++) {
            linkedList.add(i, Math.random());
        }
        System.out.println("fixTimeAddInMi LinkedList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));


        List<Double> listArray = getArrayList();

        s = System.nanoTime();
        for (int i = ALL_COUNT / 2; i < ALL_COUNT / 2 + GET_ITER; i++) {
            listArray.add(i, Math.random());
        }
        System.out.println("fixTimeAddInMi ArrayList " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - s));

    }


    private static ArrayList<Double> getArrayList() {
        return new Random()
                .doubles()
                .limit(ALL_COUNT)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

    }

    private static LinkedList<Double> getLinkedList() {
        return DoubleStream.generate(Math::random)
                .limit(ALL_COUNT)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));


    }

}
