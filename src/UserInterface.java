import java.util.Scanner;

public class UserInterface {
    boolean running = true;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (running) {
            principalMenu();
            displayMenuOptionInput();

            int menuOption = validateIntInput(scanner,1,4);
            separator();

            switch (menuOption) {
                case 1:
                    String[] items = SystemInterface.getMenu();
                    separator();
                    System.out.println("MENU");
                    separator();
                    display(items);
                    break;
                case 2:
                    displayMenuItemInput();
                    int itemNumber = validateIntInputType(scanner);
                    String[] verificationMessages = SystemInterface.placeOrder(itemNumber);
                    display(verificationMessages);
                    break;
                case 3:
                    String[] orders = SystemInterface.getTab();
                    separator();
                    System.out.println("TAP");
                    separator();
                    display(orders);
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

    private void display(String[] lines) {
        for (String line: lines) {
            System.out.println(line);
        }
    }

    private void principalMenu() {
        separator();
        System.out.println("PRINCIPAL MENU");
        separator();
        System.out.println(
                        "\t1 - Display menu\n"+
                        "\t2 - Submit Order\n"+
                        "\t3 - Display tab\n"+
                        "\t4 - Quit");
    }

    private void  displayMenuOptionInput() {
        separator();
        System.out.print("Please choose an option from the principal menu: ");
    }

    private void  displayMenuItemInput() {
        separator();
        System.out.print("Please insert the number of the item to be placed: ");
    }

    private void separator() {
        System.out.println("-".repeat(50));
    }

    private int validateIntInput(Scanner input, int min, int max) {
        int menuOption = validateIntInputType(input);

        if (menuOption < min || menuOption > max) {
            System.out.print("This option is not in the menu.\n" + "Please choose an option: ");
            menuOption = validateIntInput(input, min, max);
        }
        return menuOption;
    }

    private int validateIntInputType(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("That is not a valid input, please try again.\n" + "Please choose an option: ");
            input.next();
        }

        return input.nextInt();
    }
}
