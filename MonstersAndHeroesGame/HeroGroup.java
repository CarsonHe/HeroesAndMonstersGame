import java.util.ArrayList;

/**
 * Hero group
 */
public class HeroGroup extends AbstractGroup<Hero> {

    public HeroGroup(int size) {
        this.entities = new ArrayList<>();
        this.count = size;
    }
}