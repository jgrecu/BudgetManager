package budget;

public class Clothes extends PurchaseItem {
    private String name;
    private double price;

    public Clothes(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f",name, price);
    }
}
