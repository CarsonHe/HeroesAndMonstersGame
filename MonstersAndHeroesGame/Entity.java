/**
 * An abstract entity class that contains attributes of the entity
 */
public abstract class Entity {
    /**
     * type
     */
    protected String type;
    /**
     * entity name
     */
    protected String name;
    /**
     * entity level
     */
    protected int level;
    /**
     * entity hp
     */
    protected int hp;

    /**
     * toString method
     * @return
     */
    public abstract String toString();

    /**
     * description
     * @return  information
     */
    public abstract String description();

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return hp;
    }

    /**
     * update new HP
     * @param newHP
     */
    public void updateHP(int newHP) {
        if (newHP <= 0){
            newHP = 0;
        }
        this.hp = newHP;
    }

}