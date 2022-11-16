import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/*
HeroesAndMonstersGame class
launch the game of HeroesAndMonster
 */
public class HeroesAndMonstersGame extends Game {

    private final Random rand = new Random();
    /**
     * battle probability
     */
    private static final double BATTLE_RATE = 0.2;
    /**
     * hero group
     */
    HeroGroup heroGroup;


    private HashMap<Cell,MarketUI> cellMarketUIHashMap = new HashMap<>();

    public HeroesAndMonstersGame() throws IOException {
        //initialize map
        this.spaceMap = new SpaceMap();
    }

    public void launchGame() {
        System.out.println("welcome to 《Heroes and monsters》");
        System.out.print("how many heroes you want to use?(1 - 3): ");
        //get hero's number
        int numHeroes = ScannerUtil.getInt(0,3);
        //initialize the number of hero
        heroGroup = new HeroGroup(numHeroes);
        System.out.println("please select " + numHeroes + " different hero.");
        System.out.println("**************************The order you choose them will be the order for them to fight**************************");
        System.out.println();
        //read heroes data files
        ArrayList<Hero> heroes = ReadFilesUtils.ListOfHeroes();
        //print hero list information
        PrintUtils.printTable("Hero List Information", Hero.DESCRIPTION, heroes);
        //build hero team
        buildHeroList(numHeroes, heroes);

        System.out.println("your team information: ");
        System.out.println(heroGroup.toString());
        PrintUtils.printTable("your hero group list: ", Hero.DESCRIPTION,heroGroup.getEntities());
        //print help message
        printHelpMessages();
        System.out.println("\n Map information！ \n");
        //print map
        spaceMap.printMap();
    }

    /**
     * build hero team
     *
     * @param numHeroes
     * @param heroList
     */
    private void buildHeroList(int numHeroes, ArrayList<Hero> heroList) {
        System.out.println("Please enter the NO of the hero, then press enter until you select " + numHeroes + " different hero");
        for (int i = 0; i < numHeroes; i++) {
            int currHeroChoice = ScannerUtil.getInt(0,heroList.size()-1);
            Hero hero = heroList.get(currHeroChoice);
            if (heroGroup.isExist(hero)) {
                System.out.print("This hero exists, please select another one.");
            } else {
                heroGroup.addEntity(hero);
                System.out.println("Add " + hero.getName() + " to your team");
            }
        }
    }

    /**
     * help messages
     */
    private void printHelpMessages() {
        System.out.println("===========================================================================================================================================");
        System.out.println("Welcome to《Hero and Monsters》");
        System.out.println("you can move in the map，'X' is inaccessible space，'M' is market，'_'free space");
        System.out.println("you can enter 'w', 'a', 's','d' to move your team,which means 'up','left','down','right'");
        System.out.println("you can enter 'e' to check your team's information");
        System.out.println("you can enter 'i' to check inventory");
        System.out.println("when you in the space of market，enter 'm' to enter the market");
        System.out.println("you can enter 'q' to quit the game");
        System.out.println("if you want to show this information again, enter'h' to print the help message");
        System.out.println("have a good game!");
        System.out.println("===========================================================================================================================================");
    }

    public int processMapInput() {
        System.out.print("where do you want to move? enter h to show the rule: ");

        char choice = Character.toLowerCase(ScannerUtil.getString().charAt(0));
        //get current position
        int[] currPosition = spaceMap.getHeroGroupPosition();
        switch (choice) {
            case ('w'): {
                int[] newPosition = new int[]{currPosition[0] - 1, currPosition[1]};
                return move(newPosition);
            }
            case ('a'): {
                int[] newPosition = new int[]{currPosition[0], currPosition[1] - 1};
                return move(newPosition);
            }
            case ('s'): {
                int[] newPosition = new int[]{currPosition[0] + 1, currPosition[1]};
                return move(newPosition);
            }
            case ('d'): {
                int[] newPosition = new int[]{currPosition[0], currPosition[1] + 1};
                return move(newPosition);
            }
            case ('m'): {
                if (spaceMap.getCell(currPosition) instanceof MarketSpace) {
                    return 3;
                } else {
                    System.out.println("There is no market in you position.");
                    return -1;
                }
            }
            case ('e'): {
                return 4;
            }
            case ('i'): {
                return 5;
            }
            case ('h'): {
                return 6;
            }
            case ('q'): {
                return 7;
            }
            default: {
                System.out.println("Invalid input, please try again.");
                return -1;
            }
        }

    }

    public int move(int[] newPosition) {
        if (spaceMap.move(newPosition)) {
            if (spaceMap.getCell(newPosition) instanceof BattleSpace) {
                float roll = rand.nextFloat();
                if (roll < BATTLE_RATE) {
                    return 2;
                }
            }
            return 1;
        }
        return -1;
    }


    public void playGame() throws IOException {
        //launch game
        launchGame();
        while (true) {
            int choice = processMapInput();
            switch (choice) {
                //monster
                case (2): {
                    //initialize battle
                    BattleUI battleWindow = new BattleUI(heroGroup);
                    //battle
                    battleWindow.launchInterface();
                    break;
                }
                case (3): {
                    Cell cell = spaceMap.getCell(spaceMap.getHeroGroupPosition());
                    MarketUI marketUI;
                    if ((marketUI = cellMarketUIHashMap.get(cell)) == null){
                        marketUI = new MarketUI(heroGroup, (MarketSpace) cell);
                        cellMarketUIHashMap.put(cell,marketUI);
                    }
                    marketUI.launchInterface();
                    break;
                }
                case (4): {
                    PrintUtils.printTable("Hero Group stats", Hero.DESCRIPTION, heroGroup.getEntities());
                    break;
                }
                case (5): {
                    UserInventoryUI inventoryCheck = new UserInventoryUI(heroGroup);
                    inventoryCheck.launchInterface();
                    break;
                }
                case (6): {
                    printHelpMessages();
                    break;
                }
                case (7): {
                    return;
                }
                default: {
                    break;
                }
            }
            spaceMap.printMap();
        }
    }

}
