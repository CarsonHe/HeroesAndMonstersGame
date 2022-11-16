/*
game class used to start the game
 */
import java.io.IOException;

public abstract class Game {
 
    protected SpaceMap spaceMap;

    /**
     * launch the game

     * @throws IOException
     */
    public abstract void launchGame() throws IOException;

    /**
     * play the game
     * @throws IOException
     */
    public abstract void playGame() throws IOException;

}