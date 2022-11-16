import java.util.ArrayList;

/**
 * abstract group which contains group of entity and their attributes
 */
public abstract class AbstractGroup<T extends Entity> {
    /**
     * entities group
     */
    protected ArrayList<T> entities;

    protected  int count;

    protected int maxLevel;



    public void addEntity(T newEntity) {
        if (newEntity.getLevel()>maxLevel){
            maxLevel = newEntity.getLevel();
        }
        entities.add(newEntity);
//        for (int i = 0; i < entities.length; i++) {
//            if (entities[i] == null) {
//                entities[i] = newEntity;
//                if (newEntity.getLevel() > maxLevel){
//                    maxLevel = newEntity.getLevel();
//                }
//                return;
//            }
//        }
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public ArrayList<T> getEntities() {
        return entities;
    }

    public boolean removeEntity(Entity entity) {
        return entities.remove(entity);
//        for (int i = 0; i < entities.length; i++) {
//            if (entities[i].equals(entity)) {
//                entities[i] = null;
//                return true;
//            }
//        }
//        return false;
    }

    public boolean isExist(Entity obj) {
        for (Entity entity : entities) {
            if (entity.equals(obj)){
                return true;
            }
        }
        return false;
//        for (int i = 0; i < entities.length; i++) {
//            if (entities[i] != null && entities[i].equals(entity)) {
//                return true;
//            }
//        }
//        return false;

    }

    public Entity get(int index) {
        return entities.get(index);
    }

    public Entity nextAlive() {
        for (Entity entity : entities) {
            if (entity.getHP() > 0){
                return entity;
            }
        }
        return null;
//        for (int i = 0; i < entities.length; i++) {
//            if (entities[i] != null && entities[i].getHP() > 0) {
//                return i;
//            }
//        }
//        return -1;
    }

//    public boolean isEliminated() {
//        for (int i = 0; i < entities.length; i++) {
//            if (entities[i].getHP() > 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * if it's full
     * @return
     */
    public boolean isFull() {
        return entities.size() == count;
//        for (Entity entity : entities) {
//            if (entity == null) {
//                return false;
//            }
//        }
//        return true;
    }

    public int size() {
        return count;
    }

}