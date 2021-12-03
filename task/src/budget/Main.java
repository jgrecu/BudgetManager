package budget;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        double total = 0.0d;
        while (sc.hasNextLine()) {
            String purchase = sc.nextLine();
            double price = Double.parseDouble(purchase.substring(purchase.lastIndexOf("$") + 1));
            total += price;
            System.out.println(purchase);
        }
        System.out.printf("%nTotal: $%.2f", total);
    }
}
