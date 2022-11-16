/**
 * space on the map
 */
public class BattleSpace extends AccessibleSpace {

    public BattleSpace(int[] position) {
        super(' ', position);
        type = "Battle";
    }

}