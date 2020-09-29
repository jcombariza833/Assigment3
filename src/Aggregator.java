import menu.Menu;
import orders.Orders;

public class Aggregator {
    private Menu menu;
    private Orders orders;

    public Aggregator() {
        this.menu = new Menu();
        this.orders = new Orders();
    }

    public Menu getMenu() {
        return menu;
    }

    public Orders getOrders() {
        return orders;
    }
}
