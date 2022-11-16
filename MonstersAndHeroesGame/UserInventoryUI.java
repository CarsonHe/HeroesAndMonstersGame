import java.util.ArrayList;

/**
 * print inventory
 */
public class UserInventoryUI extends UserInterface {

    public UserInventoryUI(HeroGroup party) {
        this.heroGroup = party;
    }

    public int chooseAction() {

        System.out.println("0. change weapon \n 1. change armor \n 2. use potion \n 3. check inventory");
        System.out.print("please select: ");
        return ScannerUtil.getInt(0, 3);
    }

    /**
     * change weapon
     *
     * @param currHero
     */
    public void changeWeapon(Hero currHero) {
        Inventory currInventory = currHero.getInventory();
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < currInventory.size(); i++) {
            if (currInventory.getItemAt(i) instanceof Weapon) {
                items.add(currInventory.getItemAt(i));
            }
        }

        if (items.isEmpty()) {
            System.out.println("You dont have any weapon.");
            return;
        }
        System.out.println("Please select the weapon you want to use from the list.");
        PrintUtils.printTable("equip list", Weapon.DESCRIPTION, items);

        System.out.print("please select the weapon you want to use: ");
        int index = ScannerUtil.getInt(0, items.size() - 1);
        Weapon chosenWeapon = (Weapon) items.get(index);
        System.out.println("you make change of " + currHero.getWeapon().getName() + " and use " + chosenWeapon.getName()+" now");
        System.out.println();
        currHero.getInventory().removeItem(chosenWeapon);
        currHero.getInventory().addItem(currHero.getWeapon());
        currHero.updateWeapon(chosenWeapon);
    }

    /**
     * change armor
     *
     * @param currHero
     */
    public void changeArmor(Hero currHero) {
        Inventory currInventory = currHero.getInventory();
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < currInventory.size(); i++) {
            if (currInventory.getItemAt(i) instanceof Armor) {
                items.add(currInventory.getItemAt(i));
            }
        }
        if (items.isEmpty()) {
            System.out.println("you dont have any armor.");
            return;
        }
        System.out.println("Please select the armor from the list.");
        PrintUtils.printTable("list", Armor.DESCRIPTION, items);
        System.out.print("please the armor you want:  ");
        int index = ScannerUtil.getInt(0, items.size() - 1);
        Armor chosenArmor = (Armor) items.get(index);
        System.out.println("you make change of " + currHero.getArmor().getName() + " and use " + chosenArmor.getName()+" now");
        System.out.println();
        currHero.getInventory().removeItem(chosenArmor);
        currHero.getInventory().addItem(currHero.getArmor());
        currHero.updateArmor(chosenArmor);
    }

    /**
     * use potion
     *
     * @param currHero
     */
    public void usePotion(Hero currHero) {
        Inventory currInventory = currHero.getInventory();
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < currInventory.size(); i++) {
            if (currInventory.getItemAt(i) instanceof Potion) {
                items.add(currInventory.getItemAt(i));
            }
        }
        if (items.isEmpty()) {
            System.out.println("you dont have any potion.");
            return;
        }
        System.out.println("select the potion you want to use from the list");
        PrintUtils.printTable("equip list", Potion.DESCRIPTION, items);
        System.out.print("select the potion you want to use: ");
        int index = ScannerUtil.getInt(0, items.size() - 1);
        Potion chosenPotion = (Potion) items.get(index);
        System.out.println("you use potion : " + chosenPotion.getName());
        System.out.println();
        currHero.usePotion(chosenPotion);
        currHero.getInventory().removeItem(chosenPotion);
    }


    private void showAllItem(Hero currHero) {
        Inventory currInventory = currHero.getInventory();
        ArrayList<String> strings = new ArrayList<>();
        for (Item item : currInventory.getItems()) {
            strings.add(item.getType()+"/"+item.getName()+"/"+item.getCost());
        }
        PrintUtils.printTable("equip list", "type/name/price", strings);
    }

    /**
     * manage inventory
     *
     * @param currHero
     */
    public void manageInventory(Hero currHero) {
        int actionChoice = chooseAction();
        switch (actionChoice) {
            case (0): {
                // change weapon
                changeWeapon(currHero);
                break;
            }
            case (1): {
                //change armor
                changeArmor(currHero);
                break;
            }
            //use potion
            case (2): {
                usePotion(currHero);
                break;
            }
            case (3): {
                showAllItem(currHero);
                break;
            }
            default: {
                break;
            }
        }
    }



    @Override
    public void launchInterface() {
        System.out.println("Select a hero and check their inventory or switch equip");
        boolean run = true;
        while (run) {
            Hero currHero = chooseHero();
            //manage inventory
            manageInventory(currHero);
            System.out.print("Do you want to check your inventory again? Enter 'Y' or 'N' to choose: ");
            char runChoice = ScannerUtil.getString().charAt(0);
            while (runChoice != 'Y' && runChoice != 'N') {
                System.out.print("Invalid input, enter 'Y' or 'N' to choose : ");
                runChoice = ScannerUtil.getString().charAt(0);
            }
            if (runChoice == 'N') {
                run = false;
            }
        }
    }

}