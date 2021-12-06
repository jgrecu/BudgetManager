package budget;

import java.io.*;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final String inputFile = "purchases.txt";
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
                case "7":
                    analyzeData();
                    break;
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    break;
            }
        }
    }

    private void analyzeData() {
        while (true) {
            printAnalyzeMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    analyzeDataAll();
                    break;
                case "2":
                    analyzeDataByType();
                    break;
                case "3":
                    analyzeDataType();
                    break;
                case "4":
                    return;
                default:
                    break;
            }

        }
    }

    private void analyzeDataAll() {
        if (budgetManager.isListEmpty()) {
            System.out.println("\nThe purchase list is empty!");
        } else {
            budgetManager.showAllPurchaseListSorted();
        }
    }

    private void analyzeDataByType() {
        budgetManager.showAllPurchaseListSortedbyType();
    }

    private void analyzeDataType() {
        printAnalyzeTypeMenu();
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
            default:
                break;
        }
        budgetManager.showPurchaseListCategorySorted(category);
    }

    private void saveData() {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(inputFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(budgetManager);
            System.out.println("Purchases were saved!");
        } catch (IOException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadData() {
        try (FileInputStream fi = new FileInputStream(new File(inputFile));
             ObjectInputStream oi = new ObjectInputStream(fi)) {
            BudgetManager temp = (BudgetManager) oi.readObject();
            if (temp != null) {
                budgetManager.setBalance(temp.getBalance());
                budgetManager.addPurchasesFromFile(temp.getPurchaseList());
                System.out.println("Purchases were loaded!");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
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
                "7) Analyze (Sort)\n" +
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

    private void printAnalyzeMenu() {
        System.out.println("\nHow do you want to sort?\n" +
                "1) Sort all purchases\n" +
                "2) Sort by type\n" +
                "3) Sort certain type\n" +
                "4) Back\n");
    }

    private void printAnalyzeTypeMenu() {
        System.out.println("\nChoose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n");
    }
}
