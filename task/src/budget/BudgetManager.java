package budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    public static final String THE_PURCHASE_LIST_IS_EMPTY = "The purchase list is empty";
    private final List<Product> purchaseList;
    private double balance;


    public BudgetManager() {
        balance = 0.0d;
        purchaseList = new ArrayList<>();
    }

    public void addIncome(int income) {
        this.balance += income;
        System.out.println("Income was added!");
    }

    public void addPurchase(Product product) {
        purchaseList.add(product);
        balance -= product.getPrice();
        System.out.println("Purchase was added!");
    }

    public double getBalance() {
        return balance;
    }

    public void showAllPurchaseList(Category type) {
        double total = 0.0d;
        System.out.println(type.name() + ":");
        switch (type) {
            case Food:
                if (purchaseList.stream().noneMatch(e -> e.getCategory() == Category.Food)) {
                    System.out.println(THE_PURCHASE_LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Food)
                            .mapToDouble(Product::getPrice)
                            .sum();
                    purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Food)
                            .forEach(System.out::println);
                }
                break;
            case Clothes:
                if (purchaseList.stream().noneMatch(e -> e.getCategory() == Category.Clothes)) {
                    System.out.println(THE_PURCHASE_LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Clothes)
                            .mapToDouble(Product::getPrice)
                            .sum();
                    purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Clothes)
                            .forEach(System.out::println);
                }
                break;
            case Entertainment:
                if (purchaseList.stream().noneMatch(e -> e.getCategory() == Category.Entertainment)) {
                    System.out.println(THE_PURCHASE_LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Entertainment)
                            .mapToDouble(Product::getPrice)
                            .sum();
                    purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Entertainment)
                            .forEach(System.out::println);
                }
                break;
            case Other:
                if (purchaseList.stream().noneMatch(e -> e.getCategory() == Category.Other)) {
                    System.out.println(THE_PURCHASE_LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Other)
                            .mapToDouble(Product::getPrice)
                            .sum();
                    purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Other)
                            .forEach(System.out::println);
                }
                break;
            case All:
                total = purchaseList.stream()
                        .mapToDouble(Product::getPrice)
                        .sum();
                purchaseList.forEach(System.out::println);
                break;
            default:
                break;
        }
        System.out.printf("Total sum: $%.2f%n", total);

    }

    public boolean isListEmpty() {
        return purchaseList.isEmpty();
    }
}
