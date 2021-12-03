package budget;

public class Other extends PurchaseItem {
    private String name;
    private double price;

    public Other(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f",name, price);
    }
}
