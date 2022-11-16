import java.util.Objects;

/**
 * monster
 * subclass of entity
 */
public class Monster extends Entity{

    public static final String DESCRIPTION = "Type/Name/level/HP/damage/defense/dodge chance";
    /**
     * damage
     */
    protected int damage;
    /**
     * defense
     */
    protected int defense;
    /**
     * dodge Chance
     */
    protected int dodgeChance;

    /**
     * monster constructor
     *
     * @param name
     * @param level
     * @param damage
     * @param defense
     * @param dodgeChance
     */
    public Monster(String name, int level, int damage, int defense, int dodgeChance) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
        this.hp = level * 100;
    }

    public String toString() {
        return type + " / " + name + " / " + level + " / " + hp + " / " + damage + " / " + defense + " / " + dodgeChance;
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof Monster)) {
            return false;
        }

        Monster otherM = (Monster) other;
        return (Objects.equals(this.name, otherM.getName()));

    }

    public Monster copy(){
        Monster monster = new Monster(name, level, damage, defense, dodgeChance);
        monster.type = this.type;
        return monster;

    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int updateDamage(int newDamage) {
        this.damage = newDamage;
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int updateDefense(int newDefense) {
        this.defense = newDefense;
        return defense;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public int updateDodgeChance(int newDodgeChance) {
        this.dodgeChance = newDodgeChance;
        return dodgeChance;
    }

    @Override
    public String description() {
        return DESCRIPTION;
    }

}