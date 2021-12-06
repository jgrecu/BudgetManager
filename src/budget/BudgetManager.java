package budget;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BudgetManager implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addPurchasesFromFile(List<Product> list) {
        purchaseList.addAll(list);
    }

    public List<Product> getPurchaseList() {
        return new ArrayList<>(purchaseList);
    }

    public void showAllPurchaseList(Category type) {
        final String LIST_IS_EMPTY = "The purchase list is empty";
        double total = 0.0d;
        System.out.println(type.name() + ":");
        switch (type) {
            case Food:
                if (purchaseList.stream().noneMatch(e -> e.getCategory() == Category.Food)) {
                    System.out.println(LIST_IS_EMPTY);
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
                    System.out.println(LIST_IS_EMPTY);
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
                    System.out.println(LIST_IS_EMPTY);
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
                    System.out.println(LIST_IS_EMPTY);
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

    public void showPurchaseListCategorySorted(Category type) {
        final String LIST_IS_EMPTY = "The purchase list is empty";
        double total = 0.0d;
        System.out.println(type.name() + ":");
        switch (type) {
            case Food:
                if (purchaseList.stream().noneMatch(e -> e.getCategory() == Category.Food)) {
                    System.out.println(LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Food)
                            .mapToDouble(Product::getPrice)
                            .sum();
                    purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Food)
                            .sorted(Comparator.comparing(Product::getPrice).reversed())
                            .forEach(System.out::println);
                }
                break;
            case Clothes:
                if (purchaseList.stream().noneMatch(e -> e.getCategory() == Category.Clothes)) {
                    System.out.println(LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Clothes)
                            .mapToDouble(Product::getPrice)
                            .sum();
                    purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Clothes)
                            .sorted(Comparator.comparing(Product::getPrice).reversed())
                            .forEach(System.out::println);
                }
                break;
            case Entertainment:
                if (purchaseList.stream().noneMatch(e -> e.getCategory() == Category.Entertainment)) {
                    System.out.println(LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Entertainment)
                            .mapToDouble(Product::getPrice)
                            .sum();
                    purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Entertainment)
                            .sorted(Comparator.comparing(Product::getPrice).reversed())
                            .forEach(System.out::println);
                }
                break;
            case Other:
                if (purchaseList.stream().noneMatch(e -> e.getCategory() == Category.Other)) {
                    System.out.println(LIST_IS_EMPTY);
                    return;
                } else {
                    total = purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Other)
                            .mapToDouble(Product::getPrice)
                            .sum();
                    purchaseList.stream()
                            .filter(e -> e.getCategory() == Category.Other)
                            .sorted(Comparator.comparing(Product::getPrice).reversed())
                            .forEach(System.out::println);
                }
                break;
            default:
                break;
        }
        System.out.printf("Total sum: $%.2f%n", total);

    }

    public void showAllPurchaseListSorted() {
        double total = 0.0d;
        System.out.println("All:");
        total = purchaseList.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        purchaseList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).forEach(System.out::println);
        System.out.printf("Total sum: $%.2f%n", total);
    }

    public void showAllPurchaseListSortedbyType() {
        double total = 0.0d;

        System.out.println("Types:");
        for (Category type : Category.values()) {
            if (type == Category.All) {
                continue;
            }
            double tempTotal = 0.0d;
            tempTotal = purchaseList.stream()
                    .filter(e -> e.getCategory() == type)
                    .mapToDouble(Product::getPrice)
                    .sum();
            if (tempTotal == 0) {
                continue;
            }
            System.out.printf("%s - $%.2f%n", type.name(), tempTotal);
            total += tempTotal;
        }

        System.out.printf("Total sum: $%.2f%n", total);
    }

    public boolean isListEmpty() {
        return purchaseList.isEmpty();
    }

    @Override
    public String toString() {
        return "BudgetManager{" +
                "purchaseList=" + purchaseList +
                ", balance=" + balance +
                '}';
    }
}
