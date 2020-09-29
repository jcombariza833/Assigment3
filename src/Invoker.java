import menu.Menu;

public class Invoker {
    private Aggregator aggregator;

    public Invoker(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    public Menu getMenu(){
        return new CMDGetMenu(aggregator).execute();
    }

    public Verification placeOrder(int item){
        return new CMDSubmitOrder(aggregator,item).execute();
    }

    public Tab getTab(){
        return new CMDGetTap(aggregator).execute();
    }
}
