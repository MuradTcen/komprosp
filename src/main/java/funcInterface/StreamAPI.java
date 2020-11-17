package funcInterface;

import java.util.Scanner;
import java.util.function.*;

public class StreamAPI {
    static class User {
        private User(String name) {
            this.name = name;
        }

        private String name;

        private String getName() {
            return name;
        }

    }

    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 5;
        System.out.println("Predicate " + isPositive.test(5));

        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        System.out.println("BinaryOperator " + multiply.apply(2, 3));

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("UnaryOperator " + square.apply(5));

        Function<Integer, String> convert = x -> x + "долл";
        System.out.println("Function " + convert.apply(5));

        Consumer<Integer> printer = x -> System.out.printf("%d долларов \n", x);
        printer.accept(600);

        Supplier<User> userFactory = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        System.out.println("Вы ввели" + user1.getName());
    }
}
