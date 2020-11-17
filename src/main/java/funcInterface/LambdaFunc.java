package funcInterface;

import java.util.Arrays;
import java.util.List;

public class LambdaFunc {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach((System.out::println));

        Calculation eq = x -> x * x + 2 * x + 5;
        System.out.println(eq.equation(1));

    }

    @FunctionalInterface
    interface Calculation {
        int equation(int x);
    }

}
