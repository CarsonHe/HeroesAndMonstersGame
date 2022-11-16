import java.io.IOException;
import java.util.Random;

/**
 * Generate a new map
 */
public class SpaceMap {

    private Random rand = new Random();
    private Cell[][] map;
    private int[] currPosition;

    public SpaceMap() throws IOException {
        this.map = new Cell[8][8];
        //(0,0) is a empty space
        this.map[0][0] = new BattleSpace(new int[] {0,0});
        //set(0,0) for hero initial position
        ((AccessibleSpace) this.map[0][0]).setHere();
        //current position
        currPosition = new int[] {0,0};
        //randomize the map
        randomizeMap();
    }

    public SpaceMap(int mapSize) throws IOException {
        this.map = new Cell[mapSize][mapSize];
        randomizeMap();
    }

    public SpaceMap(int mapLength, int mapWidth) throws IOException {
        this.map = new Cell[mapLength][mapWidth];
        randomizeMap();
    }

    public void printMap() {
        PrintUtils.printSpace(map);
    }

    /**
     * randomize the map
     * @throws IOException
     */
    private void randomizeMap() throws IOException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                float roll = rand.nextFloat();
                int[] coord = new int[] {i,j};
                // 20% of inaccessible space
                if (roll < 0.20) {
                    this.map[i][j] = new InaccessibleSpace(coord);
                }
                // 30% of market
                else if (roll < 0.30) {
                    this.map[i][j] = new MarketSpace(coord);
                }
                // 50% of free space
                else {
                    this.map[i][j] = new BattleSpace(coord);
                }
            }
        }
    }
    
    public int[] getHeroGroupPosition() {
        return currPosition;
    }

    public Cell getCell(int[] position) {
        Cell result = map[position[0]][position[1]];
        switch (result.getType()) {
            case ("Market"): {
                return (MarketSpace) result;
            }
            case ("Battle"): {
                return (BattleSpace) result;
            }
            default: {
                return result;
            }
        }
    }

    public boolean move(int[] newPosition) {
        if (newPosition[0] < 0 || newPosition[1] < 0 || newPosition[0] >= map.length || newPosition[1] >= map[0].length) {
            System.out.println("Current position out of bound, please try again");
            return false;
        }
        if (getCell(newPosition).getType().equals("Inaccessible")) {
            System.out.println("this space is inaccessible, please try again");
            return false;
        }
        ((AccessibleSpace) this.map[currPosition[0]][currPosition[1]]).removeHere();
        ((AccessibleSpace) this.map[newPosition[0]][newPosition[1]]).setHere();
        currPosition = newPosition;
        return true;
    }

}