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
        aggregator.getOrders().add(new OrderItem(item));
        Verification verification = new Verification("\tYour order was placed successfully");

        if (!(item > 0 && item <= aggregator.getMenu().getMenuSize())) {
            verification.setMessage("\tthe item selected does not exist");
        }

        return verification;
    }
}
