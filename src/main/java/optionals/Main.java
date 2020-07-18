package optionals;

import imperative.Gender;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        System.out.println(value);

        Optional.ofNullable("jacob@163.com")
                .ifPresent(System.out::println);

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Cannot  send email")
                );

//        my practice
        Person linda = Optional.ofNullable(new Person("Linda", Gender.FEMALE))
                .get();


        Person lindaNull = null;
        try {
            Person person = Optional.ofNullable(lindaNull)
                    .get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }


    }

    private String method() {
        return Optional.ofNullable(null).isPresent() ? "true" : "false";
    }

    private static class Person {
        private final String name;
        private final Gender gender;

        private Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
}
