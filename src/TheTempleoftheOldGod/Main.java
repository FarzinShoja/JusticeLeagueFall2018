package TheTempleoftheOldGod;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ReadJSonFile read = new ReadJSonFile();
        Room r = new Room();
        Room[] roomsHolder = read.rooms;
        Item i = new Item();
        Item[] itemHolder = read.items;
        Inventory inventory = new Inventory();
        Monster enemey = new Monster();
        Monster[] monsterHolder = read.monsters;
        Player player = new Player();
        Puzzle p = new Puzzle();
        Puzzle[] puzzleHolder = read.puzzles;


        boolean isGameFinished = false;


        Map<String, Boolean> itemPickedUp = new LinkedHashMap<>();
        Map<String, Boolean> monsterIsDead = new LinkedHashMap<>();

        for (int y = 0; y < roomsHolder.length; y++) {
            if (!roomsHolder[y].getRoomItem().equals("None")) {
                itemPickedUp.put(roomsHolder[y].getRoomTitle(), false);
            }
        }

        for (int y = 0; y < roomsHolder.length; y++) {
            if (!roomsHolder[y].getRoomMons().equals("None")) {
                monsterIsDead.put(roomsHolder[y].getRoomTitle(), false);
            }
        }

        int currentRoomID = 0;
        String currentRoomTitle = " ";
        String currentRoomPuzzle = " ";

        System.out.println(" ");
        System.out.println("------------------ Welcome to The Temple of the OLd God ------------");
        System.out.println(" ");
        System.out.println("------------------------------------------ Type StartGame to Begin ------------");
        System.out.println(" ");
        System.out.println("---------------------------------------------------------- Type Help to View Command ------------");
        System.out.println(" ");

        Scanner userInputScanner = new Scanner(System.in);

        while (isGameFinished != true) {
            System.out.println("UserInputRequired:  ");
            String userInputString = userInputScanner.nextLine();

            if (userInputString.equalsIgnoreCase("StartGame")) {
                currentRoomID = 00;
                currentRoomTitle = r.currentRoomTitle(currentRoomID, roomsHolder);
                inventory.setDefults(itemHolder);
                currentRoomPuzzle = "Rubble";
                currentRoomTitle = r.currentRoomTitle(currentRoomID, roomsHolder);
                System.out.println("Welcome to " + currentRoomTitle + " Room" +
                        "\nRoom Description: " + r.extractRoomDesc(currentRoomTitle, roomsHolder));
                System.out.println("\nType Interact to continue");
            }
            //This if
            if (userInputString.equalsIgnoreCase("Interact")) {
                r.extractRoomInter(currentRoomTitle, roomsHolder);
                String sInteraction = "";

                for (Map.Entry<String, String> m : r.getInteractionMap().entrySet()) {
                    System.out.println(m.getKey());

                    while (true) {
                        sInteraction = (userInputScanner.nextLine());
                        if (r.getInteractionMap().containsKey(sInteraction)) {
                            System.out.println(r.getInteractionMap().get(sInteraction));
                            // r.interactionMap.remove(sInteraction);
                            break;
                        } else {
                            System.out.println("Try again.... , Try Typing the Exactly How it Shows");
                            System.out.println(m.getKey());
                        }
                    }
                }
                if (r.extractRoomDescSecond(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")) {
                    //Do Nothing
                    System.out.println("Type Examine room took look for Monsters/Items/Puzzle ");
                } else {
                    System.out.println("..... " + r.extractRoomDescSecond(currentRoomTitle, roomsHolder));
                    System.out.println("Type Examine room took look for Monsters/Items/Puzzle ");
                }
            }

            if (userInputString.equalsIgnoreCase("Check Inventory")) {
                String inventoryListener;
                while (true) {
                    inventory.checkInventory();
                    System.out.println("Type Equip to Equip a Weapon, Type Consume to use an Item, Type Exit Inventory to Exit ");
                    inventoryListener = (userInputScanner.nextLine());
                    if (inventoryListener.equalsIgnoreCase("Equip")) {
                        System.out.println("Which Weapon Would You Like To Equip, Use the Item ID");
                        String itemToEquip = "";
                        while (true) {
                            itemToEquip = (userInputScanner).nextLine();
                            if (inventory.getInventoryMap().containsKey(itemToEquip)) {
                                inventory.setEqupped(itemToEquip, itemHolder);
                                System.out.println("You have Successfully Equip Weapon");
                                break;
                            } else {
                                System.out.println("Try Typing the Item ID Again Exactly How It Is");
                            }
                        }
                    }

                    if (inventoryListener.equalsIgnoreCase("Consume")) {
                        System.out.println("Which Item Would You Like To Consume, Use the Item ID");
                        String itemToConsume = "";
                        while (true) {
                            itemToConsume = (userInputScanner).nextLine();
                            if (inventory.getInventoryMap().containsKey(itemToConsume)) {
                                player.usedConsumable(inventory.useConsumable(itemToConsume, itemHolder));
                                System.out.println("You have Successfully Consumed This Item");
                                break;
                            } else {
                                System.out.println("Try Typing the Item ID Again Exactly How It Is");
                            }
                        }
                    }
                    if (inventoryListener.equalsIgnoreCase("Exit Inventory")) {
                        break;
                    }
                }
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
            if (userInputString.equalsIgnoreCase("Examine")) {
                boolean ex = false;

                if (!r.extractRoomMonster(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")) {
                    System.out.println(" You Have to Battle " + r.extractRoomMonster(currentRoomTitle, roomsHolder) + " Type Fight to Begin ");
                    ex = true;
                }
                if (!r.extractRoomItem(currentRoomTitle, roomsHolder).equalsIgnoreCase("None") && itemPickedUp.get(currentRoomTitle) == false) {
                    System.out.println("Type Pickup to add The " + r.extractRoomItem(currentRoomTitle, roomsHolder) + " to Inventory, or Type Skip ");
                    ex = true;
                }

                if (!r.extractRoomPuzzle(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")) {
                    System.out.println("Type Solve to Interact With Puzzle ");
                    ex = true;
                }
                if (ex == false) {
                    System.out.println("There Is Nothing In This Room, Type ExitRoom to view The Available Exits");
                }
            }


            if (userInputString.equalsIgnoreCase("Fight")) {
                //code in here need to act with monster class
                System.out.println("You are about to fight " + "\n" + enemey.extractMonsterName(currentRoomTitle, monsterHolder) +
                        "\n Description:  " + enemey.extractMonsterDesc(currentRoomTitle, monsterHolder)
                        + "\n Monster health:  " + enemey.extractMonsterHealth(currentRoomTitle, monsterHolder));
                System.out.println("Now you Know who you fighting against type Begin to start");
                String sBegin;
                while (true) {
                    sBegin = (userInputScanner.nextLine());
                    if (sBegin.equalsIgnoreCase("Begin")) {
                        //Start Fight
                        System.out.println("You are about to fight " + "\n" + enemey.extractMonsterName(currentRoomTitle, monsterHolder));
                        break;
                    }
                }

            }

            if (userInputString.equalsIgnoreCase("Pickup") && itemPickedUp.get(currentRoomTitle) == false) {
                //code in here need to act with item class
                String itemID = r.extractRoomItem(currentRoomTitle, roomsHolder);
                inventory.addToInventory(itemID, itemHolder);
                itemPickedUp.put(currentRoomTitle, true);
            } else if (userInputString.equalsIgnoreCase("Skip")) {
                System.out.println("You Didn't add the Item to Your Inventory Type ExitRoom to show the Available Exits");
            } else {
                //Do Nothings
            }

            if (userInputString.equalsIgnoreCase("Puzzle")) {
                //code in here need to act with puzzle class
                p.extractPuzzleInter(currentRoomPuzzle, puzzleHolder);
                String qInteraction = "";

                for (Map.Entry<String, String> m : p.getInteractionMap().entrySet()) {
                    System.out.println(m.getKey());

                    while (true) {
                        qInteraction = (userInputScanner.nextLine());
                        if (r.getInteractionMap().containsKey(qInteraction)) {
                            System.out.println(p.getInteractionMap().get(qInteraction));
                            // r.interactionMap.remove(sInteraction);
                            break;
                        } else {
                            System.out.println("Try again.... , Try Typing the Exactly How it Shows");
                            System.out.println(m.getKey());
                        }
                    }
                }
            }

            //User Will Use This Command to Get The Exit Rooms
            if (userInputString.equalsIgnoreCase("ExitRoom")) {
                r.extractExitRooms(currentRoomTitle, roomsHolder);
                for (Map.Entry<String, String> m : r.getExitRoomMap().entrySet()) {
                    System.out.println(m.getKey() + " : " + m.getValue());
                }
                //===================================

                while (true) {
                    System.out.println("Please Type Room you like to Enter:  ");
                    String userExitInput = userInputScanner.nextLine();
                    if (r.getExitRoomMap().containsKey(userExitInput)) {
                        System.out.println("You have Moved From " + currentRoomTitle + " to " + userExitInput);
                        currentRoomID = r.extractRoomID(userExitInput, roomsHolder);
                        currentRoomTitle = r.currentRoomTitle(currentRoomID, roomsHolder);
                        System.out.println("\nRoom Description: " + r.extractRoomDesc(currentRoomTitle, roomsHolder));
                        System.out.println("\nType Interact to continue");
                        break;
                    } else {
                        System.out.println("Try again");
                    }
                }
            }

            if (userInputString.equalsIgnoreCase("ExitGame")) {
                isGameFinished = true;
            }

            if (userInputString.equalsIgnoreCase("Help")) {
                System.out.println("Type 'ExitGame to close the game.");
                System.out.println();
            }
        }
    }
}

