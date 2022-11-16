/**
 * Sorcerer
 */
public class Sorcerer extends Hero {

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
    public Sorcerer(String name, int mana, int strength, int agility,int dexterity, int wallet, int experience){
        super(name, mana, strength, agility, dexterity, wallet,experience);
        this.type = "Sorcerer";
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.dexterity *= 1.1;
        this.agility *= 1.1;
        this.strength *= 1.05;
    }

}