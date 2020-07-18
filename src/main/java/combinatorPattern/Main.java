package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@email.com",
                "+012345678",
                LocalDate.of(2000, 1, 1)
        );

        CustomerValidationService service = new CustomerValidationService();
        System.out.println(service.isValid(customer));
        //store in db

        ValidationResult apply = isEmailValid().apply(customer);

        System.out.println("----------chain -------------");
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdultValid())
                .apply(customer);


    }
}
