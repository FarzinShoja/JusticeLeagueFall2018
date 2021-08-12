package TheTempleoftheOldGod;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    @SuppressWarnings("LoopConditionNotUpdatedInsideLoop")
    public static void main(String[] args) {
        ReadJSonFile read = new ReadJSonFile();
        Room r = new Room();
        Room[] roomsHolder = read.rooms;
        Item[] itemHolder = read.items;
        Inventory inventory = new Inventory();
        Monster enemy = new Monster();
        Monster[] monsterHolder = read.monsters;
        Player player = new Player();
        Puzzle puzzle = new Puzzle();

        boolean isGameFinished = false;
        boolean collectedAllKeys = false;


        Map<String, Boolean> itemPickedUp = new LinkedHashMap<>();
        Map<String, Boolean> monsterIsDead = new LinkedHashMap<>();
        Map<String, Boolean> interactionIsDone = new LinkedHashMap<>();


        for (Room room : roomsHolder) {
            itemPickedUp.put(room.getRoomTitle(), false);
        }


        for (Room room : roomsHolder) {
            monsterIsDead.put(room.getRoomTitle(), false);
        }


        for (Room room : roomsHolder) {
            interactionIsDone.put(room.getRoomTitle(), false);
        }


        int currentRoomID;
        String currentRoomTitle = " ";


        System.out.println(" ");
        System.out.println("------------------ Welcome to The Temple of the OLd God ------------");
        System.out.println(" ");
        System.out.println("------------------------------------------ Type StartGame to Begin ------------");
        System.out.println(" ");
        System.out.println("---------------------------------------------------------- Type Help to View Command ------------");
        System.out.println(" ");

        Scanner userInputScanner = new Scanner(System.in);

        while (!isGameFinished) {

            if (inventory.getInventoryMap().containsKey("IT6") &&
                    inventory.getInventoryMap().get("IT6").get(3).equals("3")) {
                collectedAllKeys = true;
            }


            System.out.println("UserInputRequired:  ");
            String userInputString = userInputScanner.nextLine();

            if (userInputString.equalsIgnoreCase("StartGame")) {
                currentRoomID = 0;
                currentRoomTitle = r.currentRoomTitle(currentRoomID, roomsHolder);
                inventory.setDefaults(itemHolder);


                System.out.println("Welcome to → " + currentRoomTitle + " Room" +
                        "\n⌂⌂⌂ Room Description ⌂⌂⌂  " + r.extractRoomDesc(currentRoomTitle, roomsHolder));
                System.out.println("\nType Interact to continue");
            }
            //This if
            if (userInputString.equalsIgnoreCase("Interact")) {
                r.extractRoomInter(currentRoomTitle, roomsHolder);
                String sInteraction;

                for (Map.Entry<String, String> m : r.getInteractionMap().entrySet()) {
                    System.out.println(m.getKey());

                    while (true) {
                        sInteraction = (userInputScanner.nextLine());
                        if (r.getInteractionMap().containsKey(sInteraction)) {
                            System.out.println(r.getInteractionMap().get(sInteraction));
                            break;
                        } else {
                            System.out.println("Try again.... , Try Typing the Exactly How it Shows");
                            System.out.println(m.getKey());
                        }
                    }
                }
                puzzle.getPuzzle(currentRoomTitle);
                if (r.extractRoomDescSecond(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")
                        && (!currentRoomTitle.equals("OldGodRoom"))) {
                    //Do Nothing
                    System.out.println("Type Examine to Scan The Room for Monsters || Items ");
                } else if (!currentRoomTitle.equals("OldGodRoom") &&
                        !r.extractRoomDescSecond(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")) {
                    System.out.println("..... " + r.extractRoomDescSecond(currentRoomTitle, roomsHolder));
                    System.out.println("Type Examine to Scan The Room for Monsters || Items ");
                }
                interactionIsDone.put(currentRoomTitle, true);
            }
            if (userInputString.equalsIgnoreCase("Examine") && !monsterIsDead.get(currentRoomTitle) && interactionIsDone.get(currentRoomTitle)) {
                checkExamine(r, roomsHolder, itemPickedUp, monsterIsDead, currentRoomTitle);
            } else if (userInputString.equalsIgnoreCase("Examine") && !r.extractRoomMonster(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")
                    && interactionIsDone.get(currentRoomTitle)) {
                checkExamine(r, roomsHolder, itemPickedUp, monsterIsDead, currentRoomTitle);
            }

            if (userInputString.equalsIgnoreCase("Fight") && !monsterIsDead.get(currentRoomTitle) && interactionIsDone.get(currentRoomTitle)) {
                //code in here need to act with monster class
                System.out.println("You are about to fight " + "\n" + enemy.extractMonsterName(currentRoomTitle, monsterHolder) +
                        " Known As " + enemy.extractMonsterSecondName(currentRoomTitle, monsterHolder) +
                        "\n ▬▬▬▬▬▬ Description:  " + enemy.extractMonsterDesc(currentRoomTitle, monsterHolder) +
                        "\n ▬▬▬ Monster Heavy DMG:  " + enemy.extractMonsterHeavyDmg(currentRoomTitle, monsterHolder) +
                        "\n ▬▬▬ Monster Light DMG:  " + enemy.extractMonsterLightDmg(currentRoomTitle, monsterHolder) +
                        "\n ▬▬ Monster Health:  " + enemy.extractMonsterHealth(currentRoomTitle, monsterHolder));
                System.out.println("Now you Know who is the Chose One Choose Your Weapon && Remember YOU CAN'T RUNAWAY From THIS");
                System.out.println();

                String sChoose;
                int mH = enemy.extractMonsterHealth(currentRoomTitle, monsterHolder);

                inventory.getEquippedPrintOut();
                System.out.println("☼☼☼☼☼ Shield " + " Quantity " + player.getPlayerShield());
                while (true) {
                    sChoose = (userInputScanner.nextLine());

                    if (!inventory.getEquippedMap().containsKey(sChoose) && !sChoose.equalsIgnoreCase("Shield")) {

                        System.out.println("^^^^^CHECK YOUR SPELLING DUDE^^^^^");

                    } else if (sChoose.equalsIgnoreCase("Shield") && player.getPlayerShield() <= 0) {
                        System.out.println("^^^^^YOU ARE JUST GREEDY NOW YOU HAVE NO SHIELD LEFT TO USE^^^^^");
                        inventory.getEquippedPrintOut();
                        System.out.println("☼☼☼☼☼ Shield " + " Amount " + player.getPlayerShield());

                    } else if (player.isAlive() && mH != 0 && !sChoose.equalsIgnoreCase("Shield")) {
                        player.takeDMG(enemy.giveDMG(currentRoomTitle, monsterHolder));
                        mH = enemy.takeDMG(player.giveDMG(sChoose, inventory), mH);
                        System.out.println("Player Infection ♥ " + player.getPlayerInfection());
                        player.isDead();
                    } else if (player.isAlive() && mH != 0 && sChoose.equalsIgnoreCase("Shield")) {
                        System.out.println("^^^^^YOU HAVE BLOCK THE MONSTER ATTACK^^^^^");
                        inventory.getEquippedPrintOut();
                        String sCounterAttack = (userInputScanner.nextLine());
                        mH = enemy.takeDMG(player.giveDMG(sCounterAttack, inventory), mH);
                        player.blockDMG();
                        inventory.getEquippedPrintOut();
                        System.out.println("☼☼☼☼☼ Shield " + " Amount " + player.getPlayerShield());
                        System.out.println("Player Infection ♥ " + player.getPlayerInfection());
                    }

                    if (mH <= 0 && !player.isAlive()) {
                        System.out.println("^^^^^YOU HAVE KILLED THE MONSTER BUT YOU HAVE DIED AS WELL^^^^^");
                        isGameFinished = true;
                        break;
                    } else if (!player.isAlive()) {
                        System.out.println("^^^^^YOU ARE DEAD^^^^^");
                        isGameFinished = true;
                        break;
                    } else if (mH <= 0) {
                        System.out.println("^^^^^YOU HAVE KILLED THE MONSTER^^^^^");
                        System.out.println("Examine The Room for Items Since You Have Killed The Monster");
                        monsterIsDead.put(currentRoomTitle, true);
                        break;
                    }
                }
            }

            if (userInputString.equalsIgnoreCase("Pickup") && !itemPickedUp.get(currentRoomTitle)
                    && interactionIsDone.get(currentRoomTitle)) {
                //code in here need to act with item class
                String itemID = r.extractRoomItem(currentRoomTitle, roomsHolder);
                inventory.addToInventory(itemID, itemHolder);
                itemPickedUp.put(currentRoomTitle, true);
            } else if (userInputString.equalsIgnoreCase("Skip")) {
                System.out.println("You Didn't add the Item to Your Inventory Type ExitRoom to show the Available Exits");
            }


            if (userInputString.equalsIgnoreCase("Check Inventory")) {
                String inventoryListener;
                do {
                    inventory.checkInventory();
                    System.out.println("Type Equip to Equip a Weapon, Type Consume to use an Item, Type Exit Inventory to Exit ");
                    inventoryListener = (userInputScanner.nextLine());


                    if (inventoryListener.equalsIgnoreCase("Equip")) {
                        String itemToEquip;
                        while (true) {
                            System.out.println("Which Weapon Would You Like To Equip, Use the Item ID");
                            inventory.checkInventory();
                            itemToEquip = (userInputScanner).nextLine();
                            String itemEquipHolder = inventory.useEquip(itemToEquip, itemHolder);
                            if (itemToEquip.equalsIgnoreCase("nvm")) {
                                System.out.println("------------YOU HAVE EXITED THE EQUIP INTERACTION------------");
                                break;
                            } else if (itemEquipHolder.equals("")) {
                                System.out.println("♠♠♠♠♠♠♠♠♠♠♠♠ This Item Is Not Equippable, Or Does not Exist In Your Inventory");
                                System.out.println("♠♠♠♠♠♠ Try Typing the Item ID Again Exactly How It Is");
                                System.out.println("♠♠♠ Type in NVM to exit Equip Interaction.\n");
                            } else if (inventory.getInventoryMap().containsKey(itemToEquip)) {
                                inventory.setEquipped(itemToEquip, itemHolder);
                                System.out.println("You have Successfully Equip Weapon");
                                break;
                            }
                        }
                    }

                    if (inventoryListener.equalsIgnoreCase("Consume")) {
                        String itemToConsume;
                        while (true) {
                            System.out.println("Which Item Would You Like To Consume, Use the Item ID");
                            inventory.checkInventory();
                            itemToConsume = (userInputScanner).nextLine();
                            String itemConsumeHolder = inventory.useConsumable(itemToConsume, itemHolder);

                            if (itemToConsume.equalsIgnoreCase("nvm")) {
                                System.out.println("------------YOU HAVE EXITED THE CONSUME INTERACTION------------");
                                break;
                            } else if (itemConsumeHolder.equals("")) {
                                System.out.println("♠♠♠♠♠♠♠♠♠♠♠♠ This Item Is Not Consumable, Or Does not Exist In Your Inventory");
                                System.out.println("♠♠♠♠♠♠ Try Typing the Item ID Again Exactly How It Is");
                                System.out.println("♠♠♠ Type in NVM to exit Consume Interaction.\n");
                            } else if (inventory.getInventoryMap().containsKey(itemToConsume)) {
                                player.usedConsumable(inventory.useConsumable(itemToConsume, itemHolder));
                                System.out.println("You have Successfully Consumed This Item");
                                inventory.removeFromInventory(itemToConsume);
                                break;
                            }
                        }
                    }

                } while (!inventoryListener.equalsIgnoreCase("Exit Inventory"));

            }


            if (userInputString.equalsIgnoreCase("Drop Item")) {
                inventory.checkInventoryForDrop();
                System.out.println("Type the Item ID to remove it from inventory, if you changed yor mind Type Skip");
                String sDrop;
                while (true) {
                    sDrop = (userInputScanner.nextLine());
                    if (inventory.getInventoryMap().containsKey(sDrop)) {
                        inventory.removeFromInventory(sDrop);
                        System.out.println("You have Successfully Removed the Item From Your Inventory");
                        break;
                    } else if (sDrop.equalsIgnoreCase("Skip")) {
                        System.out.println("You Didn't Remove Anything from Your Inventory");
                        break;
                    } else {
                        System.out.println("Check Your Item ID...");
                    }
                }
            }
            //============================

            if (userInputString.equalsIgnoreCase("ExitRoom") && interactionIsDone.get(currentRoomTitle)) {
                boolean continueExitRooms = true;

                if (!currentRoomTitle.equals("FinalHall")) {
                    r.extractExitRooms(currentRoomTitle, roomsHolder);
                    for (Map.Entry<String, String> m : r.getExitRoomMap().entrySet()) {
                        System.out.println(m.getKey() + " : " + m.getValue());
                    }
                } else if (collectedAllKeys) {
                    r.extractExitRooms(currentRoomTitle, roomsHolder);
                    for (Map.Entry<String, String> m : r.getExitRoomMap().entrySet()) {
                        System.out.println(m.getKey() + " : " + m.getValue());
                    }
                } else {
                    System.out.println("Check Your Inventory You Need To Have All Three Keys' to Access the Last Room");
                    continueExitRooms = false;
                }


                //===================================

                while (continueExitRooms) {
                    System.out.println("Please Type Room you like to Enter:  ");
                    String userExitInput = userInputScanner.nextLine();
                    if (r.getExitRoomMap().containsKey(userExitInput)) {
                        System.out.println("You have Moved From " + currentRoomTitle + " → " + userExitInput);
                        currentRoomID = r.extractRoomID(userExitInput, roomsHolder);
                        currentRoomTitle = r.currentRoomTitle(currentRoomID, roomsHolder);
                        System.out.println("⌂⌂⌂ Room Description ⌂⌂⌂ " + r.extractRoomDesc(currentRoomTitle, roomsHolder));
                        System.out.println("\nType Interact to continue");
                        break;
                    } else {
                        System.out.println("Try again");
                    }
                }
            }

            if (currentRoomTitle.equals("OldGodRoom") && interactionIsDone.get(currentRoomTitle)) {
                isGameFinished = true;
            }

            if (userInputString.equalsIgnoreCase("ExitGame")) {
                isGameFinished = true;
            }

            if (userInputString.equalsIgnoreCase("Help")) {
                System.out.println("******************LIST OF AVAILABLE COMMENDS******************");
                System.out.println("Type 'Check Inventory to check the Inventory");
                System.out.println("Type 'Drop Item to Drop item from Your Inventory, You Can Also Use 'Skip to exit out Drop Item Interaction");
                System.out.println("Type 'ExitGame to close the game.");
                System.out.println();
            }
        }
    }

    private static void checkExamine(Room r, Room[] roomsHolder, Map<String, Boolean> itemPickedUp, Map<String, Boolean> monsterIsDead, String currentRoomTitle) {
        boolean ex = false;

        if (!r.extractRoomMonster(currentRoomTitle, roomsHolder).equalsIgnoreCase("None") && !monsterIsDead.get(currentRoomTitle)) {
            System.out.println(" You Have to Battle " + r.extractRoomMonster(currentRoomTitle, roomsHolder) + " Type Fight to Begin ");
            ex = true;
        } else if (!r.extractRoomItem(currentRoomTitle, roomsHolder).equalsIgnoreCase("None") &&
                !itemPickedUp.get(currentRoomTitle)) {
            System.out.println(" Type Pickup to add The " + r.extractRoomItem(currentRoomTitle, roomsHolder) + " to Inventory, or Type Skip ");
            ex = true;
        }

        if (!ex) {
            System.out.println("There Is Nothing In This Room, Type ExitRoom to view The Available Exits");
        }
    }
}