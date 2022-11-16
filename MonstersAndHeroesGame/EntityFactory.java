import java.util.ArrayList;
/*
Entity factory to get entites
 */
public interface EntityFactory<T extends Entity> {


    public T getOneEntity(int maxLevel);



    public ArrayList<T> getSomeEntity(int size, int maxLevel);



    public ArrayList<T> getAllEntity();


}
