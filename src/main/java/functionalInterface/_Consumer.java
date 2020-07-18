package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer jacob = new Customer("jacob", "99999");

        //Normal java function
        greetCustomer(jacob);
        greetCustomerV2(jacob,false);
        //Consumer Functional interface
        greetCustomerConsumer.accept(jacob);
        greetCustomerConsumerV2.accept(jacob,false);
    }


    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", Thanks for registering phone number " +
                    customer.customerPhoneNumber);
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", Thanks for registering phone number " +
                    (showPhoneNumber ? customer.customerPhoneNumber : "*****"));

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", Thanks for registering phone number " +
                customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer,Boolean showPhoneNumber ) {
        System.out.println("Hello " + customer.customerName +
                ", Thanks for registering phone number " +
                (showPhoneNumber ? customer.customerPhoneNumber : "*****"));
    }


    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

    }
}
