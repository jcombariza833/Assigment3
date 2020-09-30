package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Menu {
    private HashMap<Integer, MenuItem> menuItems;

    public Menu() {
        menuItems = new HashMap<>();
        populateMenu();
    }

    public void add(MenuItem menuItem) {
        menuItems.put(menuItem.getNumber(), menuItem);
    }

    public void deleteItem(int number) {
        menuItems.remove(number);
    }

    public MenuItem searchItem(int number) {
        return menuItems.get(number);
    }

    public int getMenuSize() {
        return menuItems.size();
    }

    public Iterator<Map.Entry<Integer, MenuItem>> getIterator() {
        return menuItems.entrySet().iterator();
    }

    private void populateMenu() {
        add(new MenuItem(1,"Bruschetta", 8.95f));
        add(new MenuItem(2, "Artichoke and Spinach Dip", 8.00f));
        add(new MenuItem(3,"Stuffed Mushrooms", 7.50f));
        add(new MenuItem(4,"Fried Calamari", 8.00f));
        add(new MenuItem(5,"Four Cheese Garlic Bread", 4.00f));
        add(new MenuItem(6,"Shrimp Scampi", 10.00f));
        add(new MenuItem(7,"French Fries", 6.00f));
    }
}
