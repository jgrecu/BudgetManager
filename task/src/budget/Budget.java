package budget;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private double balance;
    private List<String> purchaseList;

    public Budget() {
        balance = 0.0d;
        purchaseList = new ArrayList<>();
    }

    public void addIncome(int income) {
        this.balance += income;
        System.out.println("Income was added!");
    }

    public void addPurchase(String purchase) {
        purchaseList.add(purchase);
        balance -= Double.parseDouble(purchase.substring(purchase.lastIndexOf("$") + 1));
        System.out.println("Purchase was added!");
    }

    public double getBalance() {
        return balance;
    }

    public void showPurchaseList() {
        if (purchaseList.isEmpty()) {
            System.out.println("The purchase list is empty");
        } else {
            double total = 0.0d;
            for (String purchase : purchaseList) {
                total += Double.parseDouble(purchase.substring(purchase.lastIndexOf("$") + 1));
                System.out.println(purchase);
            }
            System.out.printf("Total sum: $%.2f%n", total);
        }
    }
}
