/**
 * abstract Item class
 * all items have name, price, level
 */
public abstract class Item {
    /**
     * name
     */
    protected String name;
    /**
     * price
     */
    protected int cost;
    /**
     * minimal level require
     */
    protected int minLevel;
    /**
     * type
     */
    protected String type;

    public abstract String toString();

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public String getType() {
        return type;
    }

    /**
     * description
     * @return  description
     */
    public abstract String description();
    
}