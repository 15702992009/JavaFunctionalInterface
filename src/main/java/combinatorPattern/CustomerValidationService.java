package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidationService {

    public boolean isValid(Customer customer) {
        return isAdult(customer.getDob()) &&
                isEmailValidation(customer.getEmail()) &&
                isPhoneNumberValidation(customer.getPhoneNumber());
    }

    private boolean isEmailValidation(String email) {
        return email.contains("@") && email.endsWith(".com");
    }

    private boolean isPhoneNumberValidation(String email) {
        return email.startsWith("+0");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }


}
