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
                    addPurchase();
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
        System.out.printf("Balance: $%.2f%n", budgetAmount > 0 ? budgetAmount : 0);
    }

    private void addPurchase() {
        System.out.println("Enter purchase name:");
        String purchaseName = scanner.nextLine();
        System.out.println("Enter its price:");
        String price = scanner.nextLine();
        budget.addPurchase(purchaseName + " $" + price);
    }

    private void showListOfPurchases() {
        budget.showPurchaseList();
    }
}
