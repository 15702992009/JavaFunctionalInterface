package functionalInterface;

import org.w3c.dom.ls.LSOutput;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValidation("07000000000"));
        System.out.println(isPhoneNumberValidation("09000000000"));
        System.out.println(isPhoneNumberValidation("070000000001"));

        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidation.test("07000000000"));
        System.out.println(isPhoneNumberValidation.test("09000000000"));
        System.out.println(isPhoneNumberValidation.test("070000000001"));

        System.out.println(isPhoneNumberValidation.and(containsNumber3).test("07000000003-0"));
        System.out.println(isPhoneNumberValidation.or(containsNumber3).test("07000000003-111"));
    }

    static boolean isPhoneNumberValidation(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidation = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

}
