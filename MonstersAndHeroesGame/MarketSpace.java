/**
 * market space
 */
public class MarketSpace extends AccessibleSpace {

    private Inventory stock;

    public MarketSpace(int[] position){
        super('M', position);
        type = "Market";
        //15 items
        stock = new Inventory(15);
        //randomize the inventory
        stock.randomizeInventory();
    }

    public Inventory getStock() {
        return stock;
    }

}