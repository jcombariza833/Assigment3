import menu.Menu;
import menu.MenuItem;

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
            String output = String.format("\t%d - %s .... $%.2f", item.getNumber(), item.getName(), item.getPrice());
            items[index++] = output ;
        }

        return items;
    }

    public static String[] getTab() {
        return invoker.getTab().orderedItems();
    }

    public static String[] placeOrder(int item) {
        Verification verification = invoker.placeOrder(item);

        return new String[]{ verification.getMessage() };
    }
}
