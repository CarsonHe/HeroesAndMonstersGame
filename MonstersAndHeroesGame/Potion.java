/**
 * potion
 */
public class Potion extends Item {

    public static final String DESCRIPTION = "Potion Name/cost/required level/attribute increase/attribute affected";
    private final int attributeIncrease;
    private final String attributeAffected;

    public Potion(String name, int cost, int minLevel, int attributeIncrease, String attributeAffected) {
        this.name = name;
        this.cost = cost;
        this.minLevel = minLevel;
        this.attributeIncrease = attributeIncrease;
        this.attributeAffected = attributeAffected;
        this.type = "Potion";
    }

    public String toString() {
        return name + " / " + cost + " / " + minLevel + " / " + attributeIncrease + " / " + attributeAffected;
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof Potion)) {
            return false;
        }
        
        Potion otherP = (Potion) other;
        return (this.name == otherP.getName());
    
    }

    public int getAttributeIncrease() {
        return attributeIncrease;
    }

    public String getAttributeAffected() {
        return attributeAffected;
    }

    public String description() {
        return DESCRIPTION;
    }

}