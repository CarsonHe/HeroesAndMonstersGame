import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/*
MonsterFactory is to create monsters that match the level of the heroes and number of the team hero
 */
public class MonsterFactory<T extends Monster> implements EntityFactory<Monster>{


    @Override
    public Monster getOneEntity(int maxLevel) {
        ArrayList<Monster> monsters = getAllEntity();
        Random random = new Random();
        int i = random.nextInt(monsters.size());
        while (i<monsters.size()){
            if (monsters.get(i).getLevel() <= maxLevel){
                return monsters.get(i);
            }
            i = random.nextInt(monsters.size());
        }
        return monsters.get(0);
    }

    @Override
    public ArrayList<Monster> getSomeEntity(int size,int maxLevel) {
        ArrayList<Monster> result = new ArrayList<>();
        ArrayList<Monster> monsters = getAllEntity();
        ArrayList<Monster> matchMonsters = new ArrayList<>();
        //level of monster matched
        for (Monster monster : monsters) {
            if (monster.getLevel() <= maxLevel){
                matchMonsters.add(monster);
            }
        }
        //number of monster matched
        for (int i = 0; i < size; i++) {
            Monster monster = matchMonsters.get(i);
            if (monster != null){
                result.add(monster);
            }else {
                result.add(matchMonsters.get(0).copy());
            }

        }
        return result;
    }

    @Override
    public ArrayList<Monster> getAllEntity() {
        try {
            return ReadFilesUtils.ListOfMonsters();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
