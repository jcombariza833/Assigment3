import menu.Menu;
import orders.Orders;

public class CMDGetTap implements Command<Tab> {
    private Aggregator aggregator;

    public CMDGetTap(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Override
    public Tab execute() {
        Menu menu = aggregator.getMenu();
        Orders orders = aggregator.getOrders();

        return new Tab(menu,orders);
    }
}
