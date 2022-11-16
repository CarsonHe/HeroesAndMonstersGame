import java.util.ArrayList;

/**
 * team monster in the battle
 */
public class MonsterGroup extends AbstractGroup<Monster> {

    public MonsterGroup(int size) {
        this.entities = new ArrayList<>();
        this.count = size;
    }

    public String toString() {
        PrintUtils.printTable("HeroGroup List Info", entities.get(0).description(), entities);
        return "";
    }
}