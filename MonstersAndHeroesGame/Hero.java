/**
 * hero class
 */
public class Hero extends Entity {
    /**
     * description
     */
    public static final String DESCRIPTION = "Type/Name/Level/HP/Mana/Strength/agility/dexterity/Wallet/Experience";
    /**
     * exp
     */
    protected int experience;
    /**
     * Mana
     * MP. MP (or manaCost) is used to cast spells
     */
    protected int mana;
    /**
     * initial mana
     */
    protected int startMana;
    /**
     * initial hp
     */
    protected int startHP;
    /**
     * strength
     * A hero’s strength increases the amount of damage they deal when using a weapon.
     */
    protected int strength;
    /**
     * agility
     * A hero’s agility increases their chance to dodge a monster’s attack.
     */
    protected int agility;
    /**
     * dexterity
     * A hero’s dexterity increases the amount of damage they deal when casting a spell.
     */
    protected int dexterity;
    /**
     * wallet
     * Gold represents the hero’s money for use in the market.
     */
    protected int wallet;
    /**
     * weapon
     */
    protected Weapon weapon;
    /**
     * armor
     */
    protected Armor armor;
    /**
     * inventory
     */
    protected Inventory inventory;



    /**
     * hero constructor
     *
     * @param name
     * @param mana
     * @param strength
     * @param agility
     * @param dexterity
     * @param wallet
     * @param experience
     */
    public Hero(String name, int mana, int strength, int agility, int dexterity, int wallet, int experience) {
        this.name = name;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.wallet = wallet;
        this.level = 1;
        this.hp = level * 100;
        this.experience = experience;
        this.inventory = new Inventory(10);
    }

    public String toString() {
        return type + " / " + name + " / " + level + " / " + hp + " / " + mana + " / " + strength + " / " + agility + " / " + dexterity + " / " + wallet + " / " + experience;
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof Hero)) {
            return false;
        }

        Hero otherH = (Hero) other;
        return (this.name == otherH.getName());

    }

    public int getEXP() {
        return experience;
    }

    public int updateEXP(int newEXP) {
        this.experience = newEXP;
        if (this.experience >= (this.level * 10)) {
            levelUp();
        }
        return experience;
    }

    public String getType() {
        return type;
    }

    public int getMana() {
        return mana;
    }

    public int updateMana(int newMana) {
        this.mana = newMana;
        return newMana;
    }

    public int getStrength() {
        return strength;
    }

    public int updateStrength(int newStrength) {
        this.strength = newStrength;
        return newStrength;
    }

    public int getAgility() {
        return agility;
    }

    public int updateAgility(int newAgility) {
        this.agility = newAgility;
        return newAgility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int updateDexterity(int newDexterity) {
        this.dexterity = newDexterity;
        return newDexterity;
    }

    public int getWallet() {
        return wallet;
    }

    public int updateWallet(int newWallet) {
        this.wallet = newWallet;
        return wallet;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Weapon updateWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Armor updateArmor(Armor newArmor) {
        this.armor = newArmor;
        return armor;
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     * use potion
     *
     * @param potion
     */
    public void usePotion(Potion potion) {
        String[] buffedStats = potion.getAttributeAffected().split("\\|");
        int buffAmt = potion.getAttributeIncrease();
        for (int i = 0; i < buffedStats.length; i++) {
            String buffedStat = buffedStats[0];
            switch (buffedStat) {
                case ("Health"): {
                    updateHP(hp + buffAmt);
                    break;
                }
                case ("All Health"):{
                    updateMana(mana + buffAmt);
                    updateHP(hp + buffAmt);
                    break;
                }
                case ("Strength"): {
                    updateStrength(strength + buffAmt);
                    break;
                }
                case ("Mana"): {
                    updateMana(mana + buffAmt);
                    break;
                }
                case ("Agility"): {
                    updateAgility(agility + buffAmt);
                    break;
                }
                case ("Dexterity"): {
                    updateDexterity(dexterity + buffAmt);
                    break;
                }
                default: {
                    System.out.println();
                    break;
                }
            }
        }
    }


    public void initStartManaAndHp(){
        this.startMana = mana;
        this.startHP = hp;
    }

    public int getStartMana() {
        return startMana;
    }

    public int getStartHP() {
        return startHP;
    }

    public void levelUp() {
        this.hp = level * 100;
        this.mana *= 1.1;
        this.startHP = hp;
        this.startMana = mana;
    }

    @Override
    public String description() {
        return DESCRIPTION;
    }

}