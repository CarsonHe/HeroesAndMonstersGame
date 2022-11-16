import java.util.Objects;

/**
 * spell class
 */
public class Spell extends Weapon {

    public static final String DESCRIPTION = "Spell Name / cost / required level / damage / mana cost";
    /**
     * mana cost
     */
    protected int manaCost;
    /**
     * stat that is reduced
     */
    protected String reducedStat;

    public Spell(String name, int cost, int minLevel, int damage, int manaCost, String reducedStat) {
        super(name, cost, minLevel, damage);
        this.manaCost = manaCost;
        this.reducedStat = reducedStat;
    }

    @Override
    public String toString() {
        return type + " / " + name + " / " + cost + " / " + minLevel + " / " + damage + " / " + manaCost;
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof Spell)) {
            return false;
        }

        Spell otherS = (Spell) other;
        return (Objects.equals(this.name, otherS.getName()));

    }

    public int getManaCost() {
        return manaCost;
    }

    public String getReducedStat() {
        return reducedStat;
    }

    @Override
    public String description() {
        return DESCRIPTION;
    }

}