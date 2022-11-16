import java.io.IOException;
/*
An abstract class UserInterface to print out the interface when needed.
 */
public abstract class UserInterface {

    HeroGroup heroGroup;
    
    public abstract int chooseAction();

    public abstract void launchInterface() throws IOException;

    public Hero chooseHero() {
        PrintUtils.printTable("All Hero List Info", heroGroup.getEntities().get(0).description(), heroGroup.getEntities());
        System.out.print("please select your hero: ");
        return (Hero)heroGroup.getEntities().get(ScannerUtil.getInt(0,heroGroup.getEntities().size()-1));
    }

}