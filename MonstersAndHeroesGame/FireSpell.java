/**
 * Fire Spell
 */
public class FireSpell extends Spell {

    public FireSpell(String name, int cost, int minLevel, int damage, int mana) {
        super(name, cost, minLevel, damage, mana, "defense");
        this.type = "Fire";
    }
    
}