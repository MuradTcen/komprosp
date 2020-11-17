package funcInterface;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        System.out.println("Example1");
        IntStream.of(50, 60, 70, 80, 90, 120).filter(x -> x < 90).map(x -> x + 10).limit(3).forEach(System.out::println);

        System.out.println("Example2");
        String[] array = {"java", "Rush"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }
}

