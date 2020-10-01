import menu.Menu;
import menu.MenuItem;
import orders.OrderItem;

import java.util.Iterator;
import java.util.Map;

public class SystemInterface {
    private static Invoker invoker;

    public static void setInvoker(Invoker invoker) {
        SystemInterface.invoker = invoker;
    }

    public static String[] getMenu() {
        Menu menu = invoker.getMenu();
        Iterator<Map.Entry<Integer, MenuItem>> i = menu.getIterator();

        String[] items = new String[menu.getMenuSize()];
        int index = 0;
        
        while (i.hasNext()) {
            Map.Entry dictionary = i.next();
            MenuItem item = (MenuItem) dictionary.getValue();
            String output = String.format("\t%d - %s", item.getNumber(), item);
            items[index++] = output ;
        }

        return items;
    }

    public static String[] getTab() {
        Tab tab = invoker.getTab();
        String[] items = new String[tab.getItemsSize() + 1];
        Iterator<MenuItem> iterator = tab.getIterator();

        int index = 0;
        float total =0.0f;

        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            items[index++] = String.format("\t%sf", item);;
            total = total + item.getPrice();
        }

        items[index] = String.format("\tTOTAL: .... $%.2f", total);

        return items;
    }

    public static String[] placeOrder(int item) {
        Verification verification = invoker.placeOrder(item);

        return new String[]{ verification.getMessage() };
    }
}
