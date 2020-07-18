package streams;

import imperative.Gender;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static imperative.Gender.FEMALE;
import static imperative.Gender.MALE;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Alisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

//        people.stream()
//                .map( person -> person.name)
//                .mapToInt(String::length)
//                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> MALE.equals(person.gender);
        boolean containsOnlyMale = people.stream()
                .allMatch(personPredicate);
//                .noneMatch()
//                .anyMatch()

        System.out.println(containsOnlyMale);
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
