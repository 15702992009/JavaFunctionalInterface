package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlsSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:3306/user";
    }

    static Supplier<List<String>> getDBConnectionUrlsSupplier = () ->
            List.of(
                    "jdbc://localhost:3306/user",
                    "jdbc://localhost:3306/tom");

}
