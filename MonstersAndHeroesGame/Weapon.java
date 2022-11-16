/**
 * weapon class
 */
public class Weapon extends Item {

    public static final String DESCRIPTION = "Weapon Name/cost/level/damage";
    /**
     * damage
     */
    protected int damage;

    /**
     * @param name
     * @param cost
     * @param minLevel
     * @param damage
     */
    public Weapon(String name, int cost, int minLevel, int damage) {
        this.name = name;
        this.cost = cost;
        this.minLevel = minLevel;
        this.damage = damage;
        this.type = "Weapon";
    }

    public String toString() {
        return  name + " / " + cost + " / " + minLevel + " / " + damage;
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof Weapon)) {
            return false;
        }

        Weapon otherW = (Weapon) other;
        return (this.name == otherW.getName());

    }

    public int getDamage() {
        return damage;
    }

    public String description() {
        return DESCRIPTION;
    }

}