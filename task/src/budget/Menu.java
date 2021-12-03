package budget;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private Budget budget;

    public Menu() {
        budget = new Budget();
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
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("\nChoose your action:\n" +
                "1) Add income\n" +
                "2) Add purchase\n" +
                "3) Show list of purchases\n" +
                "4) Balance\n" +
                "0) Exit\n");
    }

    private void addIncome() {
        System.out.println("Enter income: ");
        int income = Integer.parseInt(scanner.nextLine());
        budget.addIncome(income);
    }

    private void showBalance() {
        double budgetAmount = budget.getBalance();
        System.out.printf("%nBalance: $%.2f%n", budgetAmount > 0 ? budgetAmount : 0);
    }

    private void addPurchaseMenu() {
        while (true) {
            printAddPurchaseMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addPurchase("Food");
                    break;
                case "2":
                    addPurchase("Clothes");
                    break;
                case "3":
                    addPurchase("Entertainment");
                    break;
                case "4":
                    addPurchase("Other");
                    break;
                case "5":
                    return;
                default:
                    break;
            }
        }
    }

    private void addPurchase(String type) {
        System.out.println("Enter purchase name:");
        String purchaseName = scanner.nextLine();
        System.out.println("Enter its price:");
        double price = Double.parseDouble(scanner.nextLine());
        budget.addPurchase(purchaseName, price, type);
    }

    private void showListOfPurchases() {
        if (budget.isListEmpty()) {
            System.out.println("\nThe purchase list is empty!");
        } else {
            while (true) {
                printListOfPurchasesMenu();
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        budget.showAllPurchaseList("Food");
                        break;
                    case "2":
                        budget.showAllPurchaseList("Clothes");
                        break;
                    case "3":
                        budget.showAllPurchaseList("Entertainment");
                        break;
                    case "4":
                        budget.showAllPurchaseList("Other");
                        break;
                    case "5":
                        budget.showAllPurchaseList("All");
                        break;
                    case "6":
                        return;
                    default:
                        break;
                }
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
