package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorPattern.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {
    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdultValid() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }

    /**
     * todo
     * @param other
     * @return
     */
    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ?
                    other.apply(customer) : result;
        };

    }
}
