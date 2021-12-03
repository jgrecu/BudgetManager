package budget;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOperations {
    private static final String fileName = "purchases.txt";

    public static BudgetManager loadData() {
        try {
            String content = new String(Files.readAllBytes(Path.of(fileName)));
            return new Gson().fromJson(content, BudgetManager.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void saveData(BudgetManager budgetManager) {
        try {
            Files.write(Path.of(fileName), prettyPrint(budgetManager).getBytes());
            System.out.println("Purchases were saved!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String prettyPrint(Object jsonObject) {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create().toJson(jsonObject);
    }

//    private String print(Object jsonObject) {
//        return new GsonBuilder()
//                .create()
//                .toJson(jsonObject);
//    }
}
