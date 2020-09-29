import orders.OrderItem;

public class CMDSubmitOrder implements Command<Verification> {
    private Aggregator aggregator;
    private int item;

    public CMDSubmitOrder(Aggregator aggregator, int item) {
        this.aggregator = aggregator;
        this.item = item;
    }

    @Override
    public Verification execute() {
        Verification verification = new Verification();

        if (item > 0 && item <= aggregator.getMenu().getMenuSize()) {
            aggregator.getOrders().add(new OrderItem(item));
            verification.setMessage("\tYour order was placed successfully");
        } else {
            verification.setMessage("\tthe item selected does not exist or is not in the inventory");
        }

        return verification;
    }
}
