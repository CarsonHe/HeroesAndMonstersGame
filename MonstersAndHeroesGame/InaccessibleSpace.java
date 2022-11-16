/**
 *inaccessible space
 */
public class InaccessibleSpace extends Cell {
    
    public InaccessibleSpace(int[] position) {
        super('X', false, position);
        type = "Inaccessible";
    }

}