package budget;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    public static final String THE_PURCHASE_LIST_IS_EMPTY = "The purchase list is empty";
    private final List<PurchaseItem> purchaseList;
    private double balance;


    public Budget() {
        balance = 0.0d;
        purchaseList = new ArrayList<>();
    }

    public void addIncome(int income) {
        this.balance += income;
        System.out.println("Income was added!");
    }

    public void addPurchase(String name, double price, String type) {
        switch (type) {
            case "Food":
                purchaseList.add(new Food(name, price));
                break;
            case "Clothes":
                purchaseList.add(new Clothes(name, price));
                break;
            case "Entertainment":
                purchaseList.add(new Entertainment(name, price));
                break;
            case "Other":
                purchaseList.add(new Other(name, price));
                break;
            default:
                break;
        }
        balance -= price;
        System.out.println("Purchase was added!");
    }

    public double getBalance() {
        return balance;
    }

    public void showAllPurchaseList(String type) {
        double total = 0.0d;
        System.out.println(type + ":");
        switch (type) {
            case "Food":
                if (purchaseList.stream().noneMatch(e -> e.getClass() == Food.class)) {
                    System.out.println(THE_PURCHASE_LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream().filter(e -> e.getClass() == Food.class).mapToDouble(PurchaseItem::getPrice).sum();
                    purchaseList.stream().filter(e -> e.getClass() == Food.class).forEach(System.out::println);
                }
                break;
            case "Clothes":
                if (purchaseList.stream().noneMatch(e -> e.getClass() == Clothes.class)) {
                    System.out.println(THE_PURCHASE_LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream().filter(e -> e.getClass() == Clothes.class).mapToDouble(PurchaseItem::getPrice).sum();
                    purchaseList.stream().filter(e -> e.getClass() == Clothes.class).forEach(System.out::println);
                }
                break;
            case "Entertainment":
                if (purchaseList.stream().noneMatch(e -> e.getClass() == Entertainment.class)) {
                    System.out.println(THE_PURCHASE_LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream().filter(e -> e.getClass() == Entertainment.class).mapToDouble(PurchaseItem::getPrice).sum();
                    purchaseList.stream().filter(e -> e.getClass() == Entertainment.class).forEach(System.out::println);
                }
                break;
            case "Other":
                if (purchaseList.stream().noneMatch(e -> e.getClass() == Other.class)) {
                    System.out.println(THE_PURCHASE_LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream().filter(e -> e.getClass() == Other.class).mapToDouble(PurchaseItem::getPrice).sum();
                    purchaseList.stream().filter(e -> e.getClass() == Other.class).forEach(System.out::println);
                }
                break;
            case "All":
                total = purchaseList.stream().mapToDouble(PurchaseItem::getPrice).sum();
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
