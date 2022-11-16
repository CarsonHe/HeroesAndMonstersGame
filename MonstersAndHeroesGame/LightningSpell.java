/**
 * lightning spell
 */
public class LightningSpell extends Spell {
    
    public LightningSpell(String name, int cost, int minLevel, int damage, int mana) {
        super(name, cost, minLevel, damage, mana, "dodge_chance");
        this.type = "Lightning";
    }

}