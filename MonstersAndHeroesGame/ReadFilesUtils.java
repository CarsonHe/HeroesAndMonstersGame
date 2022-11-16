import java.io.IOException;
import java.util.ArrayList;

/**
 * read all the file that is given
 */
public class ReadFilesUtils {
 
    public static ArrayList<Hero> ListOfHeroes(){
        ArrayList<String> WarriorArr = ReaderTxtUtil.readTxtFile("./data/hero/Warriors.txt");
        ArrayList<String> SorcererArr = ReaderTxtUtil.readTxtFile("./data/hero/Sorcerers.txt");
        ArrayList<String> PaladinArr = ReaderTxtUtil.readTxtFile("./data/hero/Paladins.txt");
        ArrayList<Hero> allHero = new ArrayList<>();
        String[] splitRow;
        for (int i = 1; i < WarriorArr.size(); i++) {
            splitRow = WarriorArr.get(i).split("/");
            Warrior warrior = new Warrior(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), Integer.parseInt(splitRow[4].trim()), Integer.parseInt(splitRow[5].trim()), Integer.parseInt(splitRow[6].trim()));
            allHero.add(warrior);
        }
        for (int i = 1; i < SorcererArr.size(); i++) {
            splitRow = SorcererArr.get(i).split("/");
            Sorcerer sorcerer = new Sorcerer(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), Integer.parseInt(splitRow[4].trim()), Integer.parseInt(splitRow[5].trim()), Integer.parseInt(splitRow[6].trim()));
            allHero.add(sorcerer);
        }
        for (int i = 1; i < PaladinArr.size(); i++) {
            splitRow = PaladinArr.get(i).split("/");
            Paladin paladin = new Paladin(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), Integer.parseInt(splitRow[4].trim()), Integer.parseInt(splitRow[5].trim()), Integer.parseInt(splitRow[6].trim()));
            allHero.add(paladin);
        }
        return allHero;
    }

    /**
     * read monster file
     * @return
     * @throws IOException
     */
    public static ArrayList<Monster> ListOfMonsters() throws IOException {
        ArrayList<String> DragonArr = ReaderTxtUtil.readTxtFile("./data/monster/Dragons.txt");
        ArrayList<String> ExoskeletonArr = ReaderTxtUtil.readTxtFile("./data/monster/Exoskeletons.txt");
        ArrayList<String> SpiritArr = ReaderTxtUtil.readTxtFile("./data/monster/Spirits.txt");
        ArrayList<Monster> allMonster = new ArrayList<>();
        String[] splitRow;
        for (int i = 1; i < DragonArr.size(); i++) {
            splitRow = DragonArr.get(i).split("/");
            Dragon monster = new Dragon(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), Integer.parseInt(splitRow[4].trim()));
            allMonster.add(monster);
        }
        for (int i = 1; i < ExoskeletonArr.size(); i++) {
            splitRow = ExoskeletonArr.get(i).split("/");
            Exoskeleton monster = new Exoskeleton(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), Integer.parseInt(splitRow[4].trim()));
            allMonster.add(monster);
        }
        for (int i = 1; i < SpiritArr.size(); i++) {
            splitRow = SpiritArr.get(i).split("/");
            Spirit monster = new Spirit(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), Integer.parseInt(splitRow[4].trim()));
            allMonster.add(monster);
        }
        return allMonster;
    }

    /**
     * get list of items
     * @return
     * @throws IOException
     */
    public static ArrayList<Item> ListOfItems(){
        ArrayList<String> ArmorArr = ReaderTxtUtil.readTxtFile("./data/Armory.txt");
        ArrayList<String> WeaponArr = ReaderTxtUtil.readTxtFile("./data/Weaponry.txt");
        ArrayList<String> PotionArr = ReaderTxtUtil.readTxtFile("./data/Potions.txt");
        ArrayList<String> IceSpellArr = ReaderTxtUtil.readTxtFile("./data/spell/IceSpells.txt");
        ArrayList<String> FireSpellArr = ReaderTxtUtil.readTxtFile("./data/spell/FireSpells.txt");
        ArrayList<String> LightningSpellArr = ReaderTxtUtil.readTxtFile("./data/spell/LightningSpells.txt");
        ArrayList<Item> allItem = new ArrayList<>();
        String[] splitRow;
        for (int i = 1; i < ArmorArr.size(); i++) {
            splitRow = ArmorArr.get(i).split("/");
            Armor item = new Armor(splitRow[0].trim(), Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()));
            allItem.add(item);
        }
        for (int i = 1; i < WeaponArr.size(); i++) {
            splitRow = WeaponArr.get(i).split("/");
            Weapon item = new Weapon(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()));
            allItem.add(item);
        }
        for (int i = 1; i < PotionArr.size(); i++) {
            splitRow = PotionArr.get(i).split("/");
            Potion item = new Potion(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), splitRow[4].trim());
            allItem.add(item);
        }
        for (int i = 1; i < IceSpellArr.size(); i++) {
            splitRow = IceSpellArr.get(i).split("/");
            IceSpell item = new IceSpell(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), Integer.parseInt(splitRow[4].trim()));
            allItem.add(item);
        }
        for (int i = 1; i < FireSpellArr.size(); i++) {
            splitRow = FireSpellArr.get(i).split("/");
            FireSpell item = new FireSpell(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), Integer.parseInt(splitRow[4].trim()));
            allItem.add(item);
        }
        for (int i = 1; i < LightningSpellArr.size(); i++) {
            splitRow = LightningSpellArr.get(i).split("/");
            LightningSpell item = new LightningSpell(splitRow[0], Integer.parseInt(splitRow[1].trim()), Integer.parseInt(splitRow[2].trim()), Integer.parseInt(splitRow[3].trim()), Integer.parseInt(splitRow[4].trim()));
            allItem.add(item);
        }
        return allItem;
    }
}