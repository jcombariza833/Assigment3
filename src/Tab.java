import menu.Menu;
import menu.MenuItem;
import orders.OrderItem;
import orders.Orders;

import java.util.Iterator;

public class Tab {
    private Menu menu;
    private Orders orders;

    public Tab(Menu menu, Orders orders) {
        this.menu = menu;
        this.orders = orders;
    }

    public String[] orderedItems() {
        String[] items = new String[orders.getOrdersSize() + 1];
        Iterator<OrderItem> iterator = orders.getIterator();
        int index = 0;
        float total =0.0f;

        while (iterator.hasNext()) {
            int orderInMenu = iterator.next().getNumber();
            MenuItem item = menu.searchItem(orderInMenu);
            items[index++] = String.format("\t%s .... $%.2f", item.getName(), item.getPrice());;
            total = total + item.getPrice();
        }

        items[index] = String.format("\tTOTAL: .... $%.2f", total);

        return items;
    }
}
