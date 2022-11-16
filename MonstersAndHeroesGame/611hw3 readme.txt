# CS611-<Assignment 3>
## <Haijun He>
---------------------------------------------------------------------------
<Student Name>   Haijun He
<Student Email>  haijunhe@bu.edu
<Student BUID>   U92947496

## Files
---------------------------------------------------------------------------
EntityFactory.java: A factory interface that contains methods getOneEntity(), getSomeEntity(), getAllEntity() to create entity
MonsterFactory.java: A factory class that implements interface EntityFactory to create monsters that match the level of the heroes and number of the team hero.
Game.java: An abstract class that contains methods launchGame() and playGame() to launch the game and play it.
HerosAndMonstersGame.java: a class that extends Game.java override the method in Game.java and contains the game rules and print out the message.
AbstractGroup.java: which contains group of entity and their attributes.
AccessibleSpace.java is an abstract that extends cell class and contains the accessible space for hero and the symbol of hero
Armor.java: a class that contains the attributes of the armor
BattleSpace.java: a class that contains the any space in the map
BattleUI.java: a class that contains every action in the battle including chooseSpell(), useSpell(), attackMonster() etc and print out the messages.
Cell.java: a boardCell class that represents each space in the map and contains attributes symbol, reachable, position, type and some setter, getter methods.
Dragon.java: is a dragon class extends monster class.
ExoSkeleton: is a exoSkeleton class extends monster class.
spirit.java: is a spirit class extends monster class.
Entity.java: is an abstract entity class that contains attributes of the entity 
Hero.java: a hero class extends the entity class, contains attributes of hero, and some getter and setter methods.
EntityFactory.java: is a factory class contains methods getOneEntity(), getSomeEntity(), and getAllEntity() to get entites.
FireSpell.java: is a fire spell class that extends spell class.
IceSpell.java: is a ice spell class that extends spell class.
LightningSpell.java: is a lightning spell class that extends spell class.
Game.java: is a Game class used to start the game.
HeroesAndMonstersGame.java: extends the Game class and it is used to launch the game of Heroes and monsters.
HeroGroup.java: a class that extends AbstractGroup class and it contains a list of hero to form a team.
InaccessibleSpace.java: an inaccessible space class that extends Cell class.
Inventory.java: an inventory class that is the inventory of heroes and market, contains method randomizeInventory() to randomly create inventory, addItem(), removeItem() etc to take action on inventory.
Item.java: an abstract class item contains the attributes of items: name, price level etc and some getter and setter methods.
Main.java: main class to run the game.
MarketSpace.java: MarketSpace class extends the Cell class.
MarketUI: is a class of market that you can take actions in the markets, contains method butItem(), sellItem() etc.
Monster.java: a monster class that extends entity class, contains attributes of monsters and some getter and setter methods.
MonsterGroup.java: a subclass of AbstractGroup class that is the team monsters in the battle
Paladin.java: a Paladin class that extends hero class.
Sorcerer.java: a Sorcerer class that extends hero class.
Warrior.java: a Warrior class that extends hero class.
Potion.java: a potion class that extends Item class.
PrintUtils.java: a util class help to print the map and the table out
ReadTxtUtil.java: a util class to Read txt file and export it to string arraylist.
ReadFilesUtil.java: a util class that read all the file that is given, contains methods ListOfHeroes(),ListOfMonsters(),ListOfItems() to get heroes, monsters, items on the file.
ScannerUtil.java: is a scanner utility class. It encapsulates getInt, getString method and catch the exception.
SpaceMap.java: a class that used to generate a new map.
Spell.java: a spell class that extends weapon class, contains the attributes of the spell and some getter methods etc.
UserInterface.java: An abstract class UserInterface to print out the interface when needed.
UserInventoryUI: a class that used to take action for each hero's inventory, including methods takeAction(), changeWeapon(), changeArmor() etc to take action in inventory
Weapon.java: a weapon class that extends Item class, contains some attributes of weapon such as: name, damage, price, level.



## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory after unzipping the files
2. Run the following instructions:
<Example below>
javac *.java
java Main

## Input/Output Example
---------------------------------------------------------------------------
output:
welcome to 《Heroes and monsters》
how many heroes you want to use?(1 - 3): input:1
output:
please select 1 different hero.
**************************The order you choose them will be the order for them to fight**************************

***************************************************************************************************************************************
*                                                        Hero List Information                                                        *
***************************************************************************************************************************************
* NO *  Type      *  Name                 *  Level  *  HP   *  Mana  *  Strength  *  agility  *  dexterity  *  Wallet  *  Experience  *
***************************************************************************************************************************************
*  0 *  Warrior   *  Gaerdal_Ironhand     *  1      *  100  *  100   *  700       *  500      *  600        *  1354    *  7           *
*  1 *  Warrior   *  Sehanine_Monnbow     *  1      *  100  *  600   *  700       *  800      *  500        *  2500    *  8           *
*  2 *  Warrior   *  Muamman_Duathall     *  1      *  100  *  300   *  900       *  500      *  750        *  2546    *  6           *
*  3 *  Warrior   *  Flandal_Steelskin    *  1      *  100  *  200   *  750       *  650      *  700        *  2500    *  7           *
*  4 *  Warrior   *  Undefeated_Yoj       *  1      *  100  *  400   *  800       *  400      *  700        *  2500    *  7           *
*  5 *  Warrior   *  Eunoia_Cyn           *  1      *  100  *  400   *  700       *  800      *  600        *  2500    *  6           *
*  6 *  Sorcerer  *  Rillifane_Rallathil  *  1      *  100  *  1300  *  750       *  450      *  500        *  2500    *  9           *
*  7 *  Sorcerer  *  Segojan_Earthcaller  *  1      *  100  *  900   *  800       *  500      *  650        *  2500    *  5           *
*  8 *  Sorcerer  *  Reign_Havoc          *  1      *  100  *  800   *  800       *  800      *  800        *  2500    *  8           *
*  9 *  Sorcerer  *  Reverie_Ashels       *  1      *  100  *  900   *  800       *  700      *  400        *  2500    *  7           *
* 10 *  Sorcerer  *  Kalabar              *  1      *  100  *  800   *  850       *  400      *  600        *  2500    *  6           *
* 11 *  Sorcerer  *  Skye_Soar            *  1      *  100  *  1000  *  700       *  400      *  500        *  2500    *  5           *
* 12 *  Paladin   *  Parzival             *  1      *  100  *  300   *  750       *  650      *  700        *  2500    *  9           *
* 13 *  Paladin   *  Sehanine_Moonbow     *  1      *  100  *  300   *  750       *  700      *  700        *  2500    *  9           *
* 14 *  Paladin   *  Skoraeus_Stonebones  *  1      *  100  *  250   *  650       *  600      *  350        *  2500    *  4           *
* 15 *  Paladin   *  Garl_Glittergold     *  1      *  100  *  100   *  600       *  500      *  400        *  2500    *  5           *
* 16 *  Paladin   *  Amaryllis_Astra      *  1      *  100  *  500   *  500       *  500      *  500        *  2500    *  5           *
* 17 *  Paladin   *  Caliber_Heist        *  1      *  100  *  400   *  400       *  400      *  400        *  2500    *  8           *
***************************************************************************************************************************************
Please enter the NO of the hero, then press enter until you select 1 different hero
input:0
output:
Add Gaerdal_Ironhand    to your team
your team information: 
HeroGroup@3159c4b8
***********************************************************************************************************************************
*                                                     your hero group list:                                                       *
***********************************************************************************************************************************
* NO *  Type     *  Name              *  Level  *  HP   *  Mana  *  Strength  *  agility  *  dexterity  *  Wallet  *  Experience  *
***********************************************************************************************************************************
*  0 *  Warrior  *  Gaerdal_Ironhand  *  1      *  100  *  100   *  700       *  500      *  600        *  1354    *  7           *
***********************************************************************************************************************************
===========================================================================================================================================
Welcome to《Hero and Monsters》
you can move in the map，'X' is inaccessible space，'M' is market，'_'free space
you can enter 'w', 'a', 's','d' to move your team,which means 'up','left','down','right'
you can enter 'e' to check your team's information
you can enter 'i' to check inventory
when you in the space of market，enter 'm' to enter the market
you can enter 'q' to quit the game
if you want to show this information again, enter'h' to print the help message
have a good game!
===========================================================================================================================================

 Map information！ 

*************************************************
*                Cell Info List                 *
-------------------------------------------------
|  H  |     |     |     |  X  |     |  M  |     |
-------------------------------------------------
|     |     |     |     |     |  X  |     |     |
-------------------------------------------------
|     |     |     |  X  |     |  X  |  X  |     |
-------------------------------------------------
|     |     |  M  |     |  X  |     |  X  |     |
-------------------------------------------------
|     |     |     |  M  |  X  |  X  |     |     |
-------------------------------------------------
|     |     |  M  |     |     |     |     |     |
-------------------------------------------------
|     |     |     |     |     |     |  X  |     |
-------------------------------------------------
|     |     |     |  X  |     |     |  M  |  X  |
-------------------------------------------------
where do you want to move? enter h to show the rule: input:d
output:
*************************************************
*                Cell Info List                 *
-------------------------------------------------
|     |  H  |     |     |  X  |     |  M  |     |
-------------------------------------------------
|     |     |     |     |     |  X  |     |     |
-------------------------------------------------
|     |     |     |  X  |     |  X  |  X  |     |
-------------------------------------------------
|     |     |  M  |     |  X  |     |  X  |     |
-------------------------------------------------
|     |     |     |  M  |  X  |  X  |     |     |
-------------------------------------------------
|     |     |  M  |     |     |     |     |     |
-------------------------------------------------
|     |     |     |     |     |     |  X  |     |
-------------------------------------------------
|     |     |     |  X  |     |     |  M  |  X  |
-------------------------------------------------
where do you want to move? enter h to show the rule: input:s
output:
There are some monsters here!
***********************************************************************************************************************************
*                                                           Hero stats                                                            *
***********************************************************************************************************************************
* NO *  Type     *  Name              *  Level  *  HP   *  Mana  *  Strength  *  agility  *  dexterity  *  Wallet  *  Experience  *
***********************************************************************************************************************************
*  0 *  Warrior  *  Gaerdal_Ironhand  *  1      *  100  *  100   *  700       *  500      *  600        *  1354    *  7           *
***********************************************************************************************************************************
********************************************************************************************
*                                      Monster stats                                       *
********************************************************************************************
* NO *  Type    *  Name          *  level  *  HP   *  damage  *  defense  *  dodge chance  *
********************************************************************************************
*  0 *  Dragon  *  Natsunomeryu  *  1      *  100  *  100     *  200      *  10            *
********************************************************************************************
select hero that take action:
***********************************************************************************************************************************
*                                                           Hero stats                                                            *
***********************************************************************************************************************************
* NO *  Type     *  Name              *  Level  *  HP   *  Mana  *  Strength  *  agility  *  dexterity  *  Wallet  *  Experience  *
***********************************************************************************************************************************
*  0 *  Warrior  *  Gaerdal_Ironhand  *  1      *  100  *  100   *  700       *  500      *  600        *  1354    *  7           *
***********************************************************************************************************************************
0
select the monster you want to take action to:
********************************************************************************************
*                                      Monster stats                                       *
********************************************************************************************
* NO *  Type    *  Name          *  level  *  HP   *  damage  *  defense  *  dodge chance  *
********************************************************************************************
*  0 *  Dragon  *  Natsunomeryu  *  1      *  100  *  100     *  200      *  10            *
********************************************************************************************
input:0
output:
you can take following action:
0. attack
1. use spell
2. inventory
please select: 
input:0
output:
========================================================
=============Hero Gaerdal_Ironhand   ----->Natsunomeryu 	caused damage: 700.0
========================================================
==================================Hero Gaerdal_Ironhand     kill the monster: Natsunomeryu 	!==================================
Monsters are all dead！
===================After battle information===========================
***********************************************************************************************************************************
*                                                           Hero stats                                                            *
***********************************************************************************************************************************
* NO *  Type     *  Name              *  Level  *  HP   *  Mana  *  Strength  *  agility  *  dexterity  *  Wallet  *  Experience  *
***********************************************************************************************************************************
*  0 *  Warrior  *  Gaerdal_Ironhand  *  1      *  110  *  110   *  700       *  500      *  600        *  1454    *  8           *
***********************************************************************************************************************************
====================================================
*************************************************
*                Cell Info List                 *
-------------------------------------------------
|     |     |     |     |  X  |     |  M  |     |
-------------------------------------------------
|     |  H  |     |     |     |  X  |     |     |
-------------------------------------------------
|     |     |     |  X  |     |  X  |  X  |     |
-------------------------------------------------
|     |     |  M  |     |  X  |     |  X  |     |
-------------------------------------------------
|     |     |     |  M  |  X  |  X  |     |     |
-------------------------------------------------
|     |     |  M  |     |     |     |     |     |
-------------------------------------------------
|     |     |     |     |     |     |  X  |     |
-------------------------------------------------
|     |     |     |  X  |     |     |  M  |  X  |
-------------------------------------------------
where do you want to move? enter h to show the rule: 
.
.
.
.
.
output:
*************************************************
*                Cell Info List                 *
-------------------------------------------------
|     |     |     |     |  X  |     |  M  |     |
-------------------------------------------------
|     |     |     |     |     |  X  |     |     |
-------------------------------------------------
|     |     |     |  X  |     |  X  |  X  |     |
-------------------------------------------------
|     |     |  H  |     |  X  |     |  X  |     |
-------------------------------------------------
|     |     |     |  M  |  X  |  X  |     |     |
-------------------------------------------------
|     |     |  M  |     |     |     |     |     |
-------------------------------------------------
|     |     |     |     |     |     |  X  |     |
-------------------------------------------------
|     |     |     |  X  |     |     |  M  |  X  |
-------------------------------------------------
where do you want to move? enter h to show the rule: input:m
output:
Welcome to the market，you can buy item here and you can sell it for 50% off with the original price
select an item from the list
0. buy 
 1. sell
Please make a choice: input:0
output:
Welcome to the market, you can buy items here
*****************************************
*               Item List               *
*****************************************
* NO *  name              *  type       *
*****************************************
*  0 *  Breastplate       *  Armor      *
*  1 *  Hell_Storm        *  Fire       *
*  2 *  Flame_Tornado     *  Fire       *
*  3 *  Ice_Blade         *  Ice        *
*  4 *  Arctic_Storm      *  Ice        *
*  5 *  Lightning_Dagger  *  Lightning  *
*  6 *  Magic_Potion      *  Potion     *
*  7 *  Luck_Elixir       *  Potion     *
*  8 *  Healing_Potion    *  Potion     *
*  9 *  Mermaid_Tears     *  Potion     *
* 10 *  Strength_Potion   *  Potion     *
* 11 *  Scythe            *  Weapon     *
* 12 *  Bow               *  Weapon     *
* 13 *  Dagger            *  Weapon     *
* 14 *  Axe               *  Weapon     *
*****************************************
Please select an item to get more information: input:13
output:
****************************************************
*                   message info                   *
****************************************************
* NO *  Weapon Name  *  cost  *  level  *  damage  *
****************************************************
*  0 *  Dagger       *  200   *  1      *  250     *
****************************************************
Do you want to buy it?(Y/N)?(to quit is 'q')): input:Y
output:
***********************************************************************************************************************************
*                                                       All Hero List Info                                                        *
***********************************************************************************************************************************
* NO *  Type     *  Name              *  Level  *  HP   *  Mana  *  Strength  *  agility  *  dexterity  *  Wallet  *  Experience  *
***********************************************************************************************************************************
*  0 *  Warrior  *  Gaerdal_Ironhand  *  1      *  110  *  110   *  700       *  500      *  600        *  1454    *  8           *
***********************************************************************************************************************************
please select your hero: input:0
output:
You successfully purchase Dagger      

Do you want to enter the market again? Please enter 'Y' or 'N': input:Y
output:
select an item from the list
0. buy 
 1. sell
Please make a choice: input:1
output:
Welcome to the market, you can sell item here, you can choose which hero to take action，and select the item you want to sell
***********************************************************************************************************************************
*                                                       All Hero List Info                                                        *
***********************************************************************************************************************************
* NO *  Type     *  Name              *  Level  *  HP   *  Mana  *  Strength  *  agility  *  dexterity  *  Wallet  *  Experience  *
***********************************************************************************************************************************
*  0 *  Warrior  *  Gaerdal_Ironhand  *  1      *  110  *  110   *  700       *  500      *  600        *  1254    *  8           *
***********************************************************************************************************************************
please select your hero: input:0
output:
Select the item you want to sell
**************************************
*   Gaerdal_Ironhand    item List    *
**************************************
* NO *  Name    *  Type    *  cost   *
**************************************
*  0 *  Dagger  *  Weapon  *  100.0  *
**************************************
Do you want to sell one of it?(Y / N): input:Y
output:
please select the item you want to sell: input:0
output:
You successfully sell item : Dagger      

Do you want to enter the market again? Please enter 'Y' or 'N': input:Y
output:
select an item from the list
0. buy 
 1. sell
Please make a choice: input:0
output:
Welcome to the market, you can buy items here
*****************************************
*               Item List               *
*****************************************
* NO *  name              *  type       *
*****************************************
*  0 *  Breastplate       *  Armor      *
*  1 *  Hell_Storm        *  Fire       *
*  2 *  Flame_Tornado     *  Fire       *
*  3 *  Ice_Blade         *  Ice        *
*  4 *  Arctic_Storm      *  Ice        *
*  5 *  Lightning_Dagger  *  Lightning  *
*  6 *  Magic_Potion      *  Potion     *
*  7 *  Luck_Elixir       *  Potion     *
*  8 *  Healing_Potion    *  Potion     *
*  9 *  Mermaid_Tears     *  Potion     *
* 10 *  Strength_Potion   *  Potion     *
* 11 *  Scythe            *  Weapon     *
* 12 *  Bow               *  Weapon     *
* 13 *  Axe               *  Weapon     *
* 14 *  Dagger            *  Weapon     *
*****************************************
Please select an item to get more information:input: 14
output:
****************************************************
*                   message info                   *
****************************************************
* NO *  Weapon Name  *  cost  *  level  *  damage  *
****************************************************
*  0 *  Dagger       *  200   *  1      *  250     *
****************************************************
Do you want to buy it?(Y/N)?(to quit is 'q')): iput:Y
***********************************************************************************************************************************
*                                                       All Hero List Info                                                        *
***********************************************************************************************************************************
* NO *  Type     *  Name              *  Level  *  HP   *  Mana  *  Strength  *  agility  *  dexterity  *  Wallet  *  Experience  *
***********************************************************************************************************************************
*  0 *  Warrior  *  Gaerdal_Ironhand  *  1      *  110  *  110   *  700       *  500      *  600        *  1454    *  8           *
***********************************************************************************************************************************
please select your hero: 0
You successfully purchase Dagger      
Do you want to enter the market again? Please enter 'Y' or 'N': N
*************************************************
*                Cell Info List                 *
-------------------------------------------------
|     |     |     |     |  X  |     |  M  |     |
-------------------------------------------------
|     |     |     |     |     |  X  |     |     |
-------------------------------------------------
|     |     |     |  X  |     |  X  |  X  |     |
-------------------------------------------------
|     |     |  H  |     |  X  |     |  X  |     |
-------------------------------------------------
|     |     |     |  M  |  X  |  X  |     |     |
-------------------------------------------------
|     |     |  M  |     |     |     |     |     |
-------------------------------------------------
|     |     |     |     |     |     |  X  |     |
-------------------------------------------------
|     |     |     |  X  |     |     |  M  |  X  |
-------------------------------------------------
where do you want to move? enter h to show the rule: 
.
.
.