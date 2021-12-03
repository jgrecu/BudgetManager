package budget;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private BudgetManager budgetManager;

    public Menu() {
        budgetManager = new BudgetManager();
    }

    void run() {
        while (true) {
            printMenu();

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addIncome();
                    break;
                case "2":
                    addPurchaseMenu();
                    break;
                case "3":
                    showListOfPurchases();
                    break;
                case "4":
                    showBalance();
                    break;
                case "5":
                    saveData();
                    break;
                case "6":
                    loadData();
                    break;
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    break;
            }
        }
    }

    private void saveData() {
        FileOperations.saveData(budgetManager);
    }

    private void loadData() {
        BudgetManager temp = FileOperations.loadData();
        if (temp != null) {
            budgetManager.setBalance(temp.getBalance());
            budgetManager.addPurchasesFromFile(temp.getPurchaseList());
            System.out.println("Purchases were loaded!");
        }
    }

    private void printMenu() {
        System.out.println("\nChoose your action:\n" +
                "1) Add income\n" +
                "2) Add purchase\n" +
                "3) Show list of purchases\n" +
                "4) Balance\n" +
                "5) Save\n" +
                "6) Load\n" +
                "0) Exit\n");
    }

    private void addIncome() {
        System.out.println("Enter income: ");
        int income = Integer.parseInt(scanner.nextLine());
        budgetManager.addIncome(income);
    }

    private void showBalance() {
        double budgetAmount = budgetManager.getBalance();
        System.out.printf("%nBalance: $%.2f%n", budgetAmount > 0 ? budgetAmount : 0.0d);
    }

    private void addPurchaseMenu() {
        while (true) {
            printAddPurchaseMenu();
            String choice = scanner.nextLine();
            Category category = null;
            switch (choice) {
                case "1":
                    category = Category.Food;
                    break;
                case "2":
                    category = Category.Clothes;
                    break;
                case "3":
                    category = Category.Entertainment;
                    break;
                case "4":
                    category = Category.Other;
                    break;
                case "5":
                    return;
                default:
                    break;
            }

            addPurchase(category);
        }
    }

    private void addPurchase(Category type) {
        System.out.println("Enter purchase name:");
        String purchaseName = scanner.nextLine();
        System.out.println("Enter its price:");
        double price = Double.parseDouble(scanner.nextLine());
        budgetManager.addPurchase(new Product(type, purchaseName, price));
    }

    private void showListOfPurchases() {
        if (budgetManager.isListEmpty()) {
            System.out.println("\nThe purchase list is empty!");
        } else {
            while (true) {
                printListOfPurchasesMenu();
                String choice = scanner.nextLine();
                Category category = null;

                switch (choice) {
                    case "1":
                        category = Category.Food;
                        break;
                    case "2":
                        category = Category.Clothes;
                        break;
                    case "3":
                        category = Category.Entertainment;
                        break;
                    case "4":
                        category = Category.Other;
                        break;
                    case "5":
                        category = Category.All;
                        break;
                    case "6":
                        return;
                    default:
                        break;
                }
                budgetManager.showAllPurchaseList(category);
            }
        }
    }

    private void printAddPurchaseMenu() {
        System.out.println("\nChoose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) Back\n");
    }

    private void printListOfPurchasesMenu() {
        System.out.println("\nChoose the type of purchases\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) All\n" +
                "6) Back\n");
    }
}
