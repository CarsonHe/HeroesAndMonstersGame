import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * battle content
 */
public class BattleUI extends UserInterface {

    private Random rand = new Random();
    /**
     * monster group
     */
    private MonsterGroup monsterGroup;
    /**
     * current hero
     */
    private Hero currHero;
    /**
     * current monster
     */
    private Monster currMonster;

    private MonsterFactory<Monster> monsterFactory;

    public BattleUI(HeroGroup heroGroup){
        this.heroGroup = heroGroup;
        this.monsterGroup = new MonsterGroup(0);
        monsterFactory = new MonsterFactory<>();

    }

    /**
     * choose spell
     * @return
     */
    private int chooseSpell() {
        Inventory currInventory = currHero.getInventory();
        Inventory spellInventory = new Inventory(currInventory.size());
        for (int i = 0; i < currInventory.size(); i++) {
            if (currInventory.getItemAt(i) instanceof Spell) {
                spellInventory.addItem(currInventory.getItemAt(i));
            }
        }
        if (spellInventory.size() == 0) {
            System.out.println("there is no spell in the inventory");
            return -1;
        }
        PrintUtils.printTable(currHero.getName()+" Spell List",Spell.DESCRIPTION,spellInventory.getItems());
        System.out.println("choose the spell you want to use:");
        return ScannerUtil.getInt(0,spellInventory.size()-1);
    }

    /**
     * use spell
     * @return
     */
    private boolean useSpell() {
        Inventory currInventory = currHero.getInventory();
        Inventory spellInventory = new Inventory(currInventory.size());
        for (int i = 0; i < currInventory.size(); i++) {
            if (currInventory.getItemAt(i) instanceof Spell) {
                spellInventory.addItem(currInventory.getItemAt(i));
            }
        }
        //choose spell
        int chosenSpell = chooseSpell();
        if (chosenSpell == -1) {
            return false;
        }
        Spell spellToUse = (Spell) spellInventory.getItemAt(chosenSpell);
        //dexterity/10000*spellDamage = actual spell damage
        double damageDealt = ((double) currHero.getDexterity() / 10000) * spellToUse.getDamage();
        if (currHero.getMana() < spellToUse.getManaCost()) {
            System.out.println("========================================================");
            System.out.println("not enough mana, cant use this spell!");
            System.out.println("========================================================");
            return false;
        }
        //cause damage to monster
        currMonster.updateHP((int) (currMonster.getHP() - damageDealt));
        //mana caused by hero
        currHero.updateMana(currHero.getMana() - spellToUse.getManaCost());
        //remove item after using it
        currHero.getInventory().removeItem(spellToUse);
        System.out.println("========================================================");
        System.out.println("=============you use spell: " + spellToUse.getName() + "!");
        System.out.println("============="+currHero.getName() + "-----> " +currMonster.getName() +"cause damage: "+ damageDealt);
        System.out.println("========================================================");
        if (currMonster.getHP() < 0) {
            System.out.println("you use spell kill monster " + currMonster.getName() + "!");
            return true;
        }
        //check the item
        switch (spellToUse.getReducedStat()) {
            //damage reduced
            case ("damage"): {
                currMonster.updateDamage((int) (currMonster.getDamage() * 0.9));
                break;
            }
            //defense reduced
            case ("defense"): {
                currMonster.updateDefense((int) (currMonster.getDefense() * 0.9));
                break;
            }
            //doge reduced
            case ("dodge_chance"): {
                currMonster.updateDodgeChance((int) (currMonster.getDodgeChance() * 0.9));
                break;
            }
            default: {
                break;
            }
        }
        return false;
    }

    /**
     * attack monster return true if the monster is dead
     * @return
     */
    private boolean attackMonster() {
        //dodge chance
        double dodgeChance = currMonster.getDodgeChance() * 0.01;
        float roll = rand.nextFloat();
        //dodge success
        if (roll < dodgeChance) {
            System.out.println("========================================================");
            System.out.println("=============you missed the attack!");
            System.out.println("============="+currHero.getName() + "-----> "+currMonster.getName() +"cause 0 damage! ");
            System.out.println("========================================================");
            return false;
        } else {
            //caused damage
            double damageDealt = currHero.getStrength();
            if (currHero.getWeapon() != null){
                damageDealt = (currHero.getStrength() + currHero.getWeapon().getDamage()) * 0.05;
            }

            currMonster.updateHP((int) (currMonster.getHP() - damageDealt));
            System.out.println("========================================================");
            if (currHero.getWeapon() != null){
                System.out.println("=============you use " + currHero.getWeapon().getName() + "attack!");
            }

            System.out.println("=============Hero "+currHero.getName() + "----->"+currMonster.getName() +"caused damage: "+ damageDealt);
            System.out.println("========================================================");
            if (currMonster.getHP() <= 0) {
                System.out.println("==================================Hero "+currHero.getName()+"  kill the monster: " + currMonster.getName() + "!==================================");
                //after each round, heroes that not fainted regain hp and mana
                return true;
            }
            return false;
        }
    }

    /**
     * monster attacks hero
     * @return
     */
    private boolean attackHero() {
        //dodge
        double dodgeChance = currHero.getAgility() * 0.0002;
        float roll = rand.nextFloat();
        if (roll < dodgeChance) {
            System.out.println("========================================================");
            System.out.println("=============you dodged the attack!");
            System.out.println("============= Hero "+currMonster.getName() + "----->"+currHero.getName() +"caused 0 damage ");
            System.out.println("========================================================");
            return false;
        }
        else {
            double damageDealt = currMonster.getDamage();
            if (currHero.getArmor() != null){
                //damage to hero
                damageDealt = (currMonster.getDamage() - currHero.getArmor().getDamageReduction());
            }
            //armor defense success
            if (damageDealt < 0) {
                System.out.println("========================================================");
                System.out.println("=============your armor defense the attack!");
                System.out.println(currMonster.getName() + "-----> "+currHero.getName() +"caused 0 damage! ");
                System.out.println("========================================================");
                return false;
            }
            else {
                //remove hero's HP
                currHero.updateHP((int)(currHero.getHP() - damageDealt));
                System.out.println("========================================================");
                System.out.println("=============The monster attack you!");
                System.out.println("============="+currMonster.getName() + "-----> "+currHero.getName() +"caused damage: "+ damageDealt);
                System.out.println("========================================================");
                if (currHero.getHP() <= 0) {
                    System.out.println("=======================Hero "+currHero.getName()+" defeated by monster "+currMonster.getName()+" !=======================");
                    return true;
                }
                return false;
            }
            
        }
    }

    /**
     * print current hero information
     */
    private void displayCurrHero() {
        System.out.println("=============current hero's information：");
        PrintUtils.printTable("Hero current stats",Hero.DESCRIPTION,currHero);
    }

    /**
     * print all hero information
     */
    private void displayAllHero() {
//        System.out.println("=============Hero's information：");
        PrintUtils.printTable("Hero stats",Hero.DESCRIPTION,heroGroup.getEntities());
    }

    /**
     * print all monster information
     * @param allMonster
     */
    private void displayAllMonster(ArrayList<Monster> allMonster) {
        PrintUtils.printTable("Monster stats",Monster.DESCRIPTION,allMonster);
    }



    /**
     * monster information
     */
    private void displayCurrMonster() {
        System.out.println("=============monster information：");
        PrintUtils.printTable("Monster current stats",Monster.DESCRIPTION,currMonster);
    }



    @Override
    public int chooseAction() {
        System.out.println("you can take following action:");
        System.out.println("0. attack");
        System.out.println("1. use spell");
        System.out.println("2. inventory");
        System.out.println("please select: ");
        return ScannerUtil.getInt(0,2);
    }

    /**
     * hero's round
     * return true if monster dead
     * @return
     * @throws IOException
     */
    public boolean battleOperations(){


        while (true){
            //get input
            int actionChoice = chooseAction();
            switch (actionChoice) {
                //attack, return true if monster dead
                case (0): {
                    return attackMonster();

                }
                //use spell
                case (1): {
                    return useSpell();

                }
                //inventory
                case (2): {
                    UserInventoryUI inventoryCheck = new UserInventoryUI(heroGroup);
                    inventoryCheck.launchInterface();
                    continue;
                }
                default: {
                    break;
                }
            }
        }
    }

    @Override
    public void launchInterface() throws IOException {
        System.out.println("There are some monsters here!");
        //create monster
        ArrayList<Monster> allMonster = monsterFactory.getSomeEntity(heroGroup.size(), heroGroup.getMaxLevel());
        ArrayList<Monster> startMonsters = new ArrayList<>(allMonster);
        //fail heroes
        ArrayList<Hero> failHeroList = new ArrayList<>();
        //hero before battle
        ArrayList<Hero> startHeroList = new ArrayList<>(heroGroup.getEntities());
        //print information
        displayAllHero();
        displayAllMonster(allMonster);
        //heroes or monsters are all dead
        while (!(startHeroList.size()==0 || allMonster.size() == 0)){
            System.out.println("select hero that take action:");
            displayAllHero();
            int heroIndex = ScannerUtil.getInt(0, heroGroup.size());
            Hero hero = (Hero)heroGroup.get(heroIndex);
            hero.initStartManaAndHp();
            if (hero.getHP() <= 0){
                System.out.println("Hero "+hero.getName()+"dead, please select again");
                continue;
            }
            System.out.println("select the monster you want to take action to:");
            displayAllMonster(allMonster);
            int monsterIndex = ScannerUtil.getInt(0, allMonster.size());
            Monster monster = allMonster.get(monsterIndex);
            currHero = hero;
            currMonster=monster;

            while (true){
                //hero round
                if (battleOperations()) {
                    //monster is dead, end round
                    allMonster.remove(monster);
                    break;
                }

                //monster round
                if (attackHero()){
                    //hero is dead
                    failHeroList.add(hero);
                    startHeroList.remove(hero);
                    break;
                }
            }
        }
        // Game over and choose if want another game
        if (startHeroList.size() == 0){
            System.out.println("ALl of the hero die, game over");
            System.out.println("Do you want another game, Yes 0 , No 1;");
            int st = ScannerUtil.getInt(0,1);{
                if(st == 0){
                    Game game = new HeroesAndMonstersGame();
                    game.playGame();
                }else {
                    System.exit(0);
                }
            }
        }else {
            battleOver(startMonsters);
            System.out.println("Monsters are all dead！");

            System.out.println("===================After battle information===========================");
            displayAllHero();
            System.out.println("====================================================");
        }
    }



    /**
     * end each round
     */
    private void battleOver(ArrayList<Monster> startMonsters){
        int exp = 0;
        for (Monster monster : startMonsters) {
            exp+= monster.getLevel();
        }
        for (Entity entity : heroGroup.getEntities()) {
            Hero hero = (Hero)entity;
            int heroStartHP = hero.getStartHP()==0?hero.getHP():hero.getStartHP();
            int heroStartMana = hero.getStartMana()==0?hero.getMana():hero.getStartMana();
            if (hero.getHP() <= 0){
                //hero fainted regain half hp and mana
                hero.updateHP(heroStartHP /2);
                hero.updateMana(heroStartMana /2);
            }else {
                //gain money
                hero.updateWallet( hero.getWallet()+(exp * 100));
                //gain hp
                hero.updateHP((int) (heroStartHP*1.1));
                //gain mana
                hero.updateMana((int) (heroStartMana*1.1));
                //gain exp
                hero.updateEXP(hero.getEXP() + exp);
            }
        }
    }
    
}
