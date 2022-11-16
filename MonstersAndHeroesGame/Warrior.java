/**
 * Warrior
 */
public class Warrior extends Hero {

    /**
     *  hero constructor
     * @param name
     * @param mana
     * @param strength
     * @param agility
     * @param dexterity
     * @param wallet
     * @param experience
     */
    public Warrior(String name, int mana, int strength, int agility,int dexterity, int wallet, int experience){
        super(name, mana, strength, agility, dexterity, wallet,experience);
        this.type = "Warrior";
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.strength *= 1.1;
        this.agility *= 1.1;
        this.dexterity *= 1.05;
    }

}