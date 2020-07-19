package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public Lambdas() {
        System.out.println("Lambdas");
    }

    public static void main(String[] args) {

        System.out.println(biFunction.apply("jacob", 24));
    }

    static Function<String, String> function = name -> {
        if (name.isBlank()) throw new IllegalArgumentException("");
        return name.toUpperCase();
    };
    static BiFunction<String, Integer, String> biFunction = (name, age) -> {
        if (name.isBlank()) throw new IllegalArgumentException("");
        System.out.println(age);
        return name.toUpperCase();
    };
    static class InnerClass{
        public InnerClass() {
            System.out.println("InnerClass");
        }
    }
}
