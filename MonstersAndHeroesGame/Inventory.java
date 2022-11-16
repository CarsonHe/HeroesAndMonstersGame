import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * inventory
 * the inventory of heroes and market
 */
public class Inventory {

    private final ArrayList<Item> items;

    private final int size;

    public Inventory(int length) {
        this.items = new ArrayList<>(length);
        size = length;
    }

    /**
     * randomize inventory
     */
    public void randomizeInventory(){
        ArrayList<Item> itemList = ReadFilesUtils.ListOfItems();
        Collections.shuffle(itemList);
        for (int i = 0; i < size; i++) {
            addItem(itemList.get(i));
        }
        this.items.sort(Comparator.comparing(Item::getType));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }


    public Item getItemAt(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public boolean isFull() {
            return items.size() == size;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

}