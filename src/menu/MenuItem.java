package menu;

public class MenuItem {
    private int number;
    private String name;
    private float price;

    public MenuItem(int number, String name, float price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s .... $%.2f", name, price);
    }
}
