package TheTempleoftheOldGod;

import java.util.ArrayList;
import java.util.Arrays;
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

        boolean isGameFinished = false;
        int currentRoomID = 0;
        String currentRoomTitle = " ";
        boolean roomDes = false;

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
                inventory.checkInventory();
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
                if (!r.extractRoomItem(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")) {
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

            }

            if (userInputString.equalsIgnoreCase("Pickup")) {
                //code in here need to act with item class
                String itemID = r.extractRoomItem(currentRoomTitle, roomsHolder);
                inventory.addToInventory(itemID, itemHolder);
            } else if (userInputString.equalsIgnoreCase("Skip")) {
                System.out.println("You Didn't add the Item to Your Inventory Type ExitRoom to show the Available Exits");
            } else {
                //Do Nothings
            }

            if (userInputString.equalsIgnoreCase("Puzzle")) {
                //code in here need to act with puzzle class
                System.out.println(Arrays.toString(itemHolder));
                System.out.println("------" + Arrays.toString(roomsHolder));
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

