/**
 * Ice spell
 */
public class IceSpell extends Spell {

    public IceSpell(String name, int cost, int minLevel, int damage, int mana) {
        super(name, cost, minLevel, damage, mana, "damage");
        this.type = "Ice";
    }
    
}