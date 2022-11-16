/**
 * Armor class that contains the attributes of the armor
 */
public class Armor extends Item {

    public static final String DESCRIPTION = "Armor Name/cost/required level/damage reduction";

    /**
     * 护甲值
     */
    private int damageReduction;

    /**
     * 
     * @param name
     * @param cost
     * @param minLevel
     * @param damageReduction
     */
    public Armor(String name, int cost, int minLevel, int damageReduction) {
        this.name = name;
        this.cost = cost;
        this.minLevel = minLevel;
        this.damageReduction = damageReduction;
        this.type = "Armor";
    }

    public String toString() {
        return name + " / " + cost + " / " + minLevel + " / " + damageReduction;
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof Armor)) {
            return false;
        }
        
        Armor otherA = (Armor) other;
        return (this.name == otherA.getName());
    
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public String description() {
        return DESCRIPTION;
    }

}