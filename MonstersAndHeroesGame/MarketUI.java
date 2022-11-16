import java.util.ArrayList;

/**
 * market
 * class of market that you can take actions in the markets
 */
public class MarketUI extends UserInterface {

    Inventory stock;

    public MarketUI(HeroGroup heroGroup, MarketSpace mCell) {
        this.heroGroup = heroGroup;
        stock = mCell.getStock();
    }

    public int chooseAction() {
        System.out.println("select an item from the list");
        System.out.println("0. buy \n 1. sell");
        System.out.print("Please make a choice: ");

        return ScannerUtil.getInt(0,1);
    }

    public void buyItem() {
        System.out.println("Welcome to the market, you can buy items here");
        String description = "name / type";
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < stock.size() ; i++) {
            if (stock.getItemAt(i) != null) {
                strings.add(stock.getItemAt(i).getName() + " / " + stock.getItemAt(i).getType());
            }
        }
        PrintUtils.printTable("Item List",description,strings);
        boolean purchased = false;
        while (!purchased) {
            System.out.print("Please select an item to get more information: ");
            int index = ScannerUtil.getInt(0,stock.size()-1);
            Item itemToDisplay = stock.getItemAt(index);
            PrintUtils.printTable("message info",itemToDisplay.description(),itemToDisplay);
            System.out.print("Do you want to buy it?(Y/N)?(to quit is 'q'): ");
            char purchaseChoice = ScannerUtil.getString().charAt(0);
            while (purchaseChoice != 'Y' && purchaseChoice != 'N' && purchaseChoice != 'Q') {
                System.out.print("invalid input, please enter 'Y' or 'N' (buy or not, to quit is 'q'): ");
                purchaseChoice = ScannerUtil.getString().charAt(0);
            }
            if (purchaseChoice == 'N') {
                System.out.println("you choose not to buy it, please check list above and select another one you want to look at.");
            }
            else if (purchaseChoice == 'Q') {
                return;
            }
            else {
                Hero buyer = chooseHero();
                if (buyer.getLevel() < itemToDisplay.getMinLevel()) {
                    System.out.println("You didn't meet the minimum level required.");
                    return;
                }
                if (buyer.getWallet() < itemToDisplay.getCost()) {
                    System.out.println("you dont have enough money.");
                    return;
                }
                if (buyer.getInventory().isFull()) {
                    System.out.println("Inventory is full，please sell something first.");
                    return;
                }
                System.out.println("You successfully purchase " + itemToDisplay.getName() + "\n");
                buyer.updateWallet(buyer.getWallet() - itemToDisplay.getCost());
                buyer.getInventory().addItem(itemToDisplay);
                stock.removeItem(itemToDisplay);
                purchased = true;
            }
        }
    }

    /**
     * sell item
     * @return
     */
    public void sellItem() {
        System.out.println("Welcome to the market, you can sell item here, you can choose which hero to take action，and select the item you want to sell");
        Hero hero = chooseHero();
        if (hero.getInventory().getItems().size()==0){
            System.out.println("There is no item you can sell, please buy item first");
            return;
        }
        System.out.println("Select the item you want to sell");
        ArrayList<String> strings = new ArrayList<>();
        for (Item item : hero.getInventory().getItems()) {
            strings.add( item.getName() + " / " + item.getType() + " / " + item.getCost() * 0.5);
        }

        PrintUtils.printTable(hero.getName() + " item List"," Name / Type / cost",strings);
        System.out.print("Do you want to sell one of it?(Y / N): ");
        char sellChoice = ScannerUtil.getString().charAt(0);
        while (sellChoice != 'Y' && sellChoice != 'N') {
            System.out.print("Invalid input, please enter 'Y' or 'N' (buy or not): ");
            sellChoice = ScannerUtil.getString().charAt(0);
        }
        if (sellChoice == 'N') {
            System.out.println("you choose not to sell your item.");
        } else {
            System.out.print("please select the item you want to sell: ");
            int index = ScannerUtil.getInt(0, hero.getInventory().size() - 1);
            Item itemToSell = hero.getInventory().getItemAt(index);
            int cost = itemToSell.getCost();
            hero.updateWallet(hero.getWallet() + cost);
            stock.addItem(itemToSell);
            hero.getInventory().removeItem(itemToSell);
            System.out.println("You successfully sell item : " + itemToSell.getName() + "\n");
        }
    }

    public void shopOperations() {
        int actionChoice = chooseAction();
        switch (actionChoice) {
            case (0): {
                buyItem();
                break;
            }
            case (1): {
                sellItem();
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public void launchInterface() {
        System.out.println("Welcome to the market，you can buy item here and you can sell it for 50% off with the original price");
        boolean run = true;
        while (run) {
            shopOperations();
            System.out.print("Do you want to enter the market again? Please enter 'Y' or 'N': ");
            char runChoice = ScannerUtil.getString().charAt(0);
            while (runChoice != 'Y' && runChoice != 'N') {
                System.out.print("Invalid enter。please enter 'Y' or 'N': ");
                runChoice = ScannerUtil.getString().charAt(0);
            }
            if (runChoice == 'N') {
                run = false;
            }
        }   
    }
}