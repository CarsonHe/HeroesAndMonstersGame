/*
run the game
 */
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new HeroesAndMonstersGame();
        game.playGame();
    }
}