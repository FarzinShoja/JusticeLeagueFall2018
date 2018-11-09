package TheTempleoftheOldGod;

import TheTempleoftheOldGod.ReadJSonFile;
import TheTempleoftheOldGod.Room;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ReadJSonFile read = new ReadJSonFile();
        Room r = new Room();
        Room[] roomsHolder = read.rooms;

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

                for (Map.Entry<String, String> m : r.interactionMap.entrySet()) {
                    System.out.println(m.getKey());

                    while (true) {
                        sInteraction = (userInputScanner.nextLine());
                        if (r.interactionMap.containsKey(sInteraction)) {
                            System.out.println(r.interactionMap.get(sInteraction));
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

            //============================
            if (userInputString.equalsIgnoreCase("Examine")) {
                boolean ex = false;

                if (!r.extractRoomMonster(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")) {
                    System.out.println("Type Fight to Battle " + r.extractRoomMonster(currentRoomTitle, roomsHolder));
                    ex = true;
                }
                if (!r.extractRoomItem(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")) {
                    System.out.println("Type Pickup to add The " + r.extractRoomItem(currentRoomTitle, roomsHolder) + "to Inventory");
                    ex = true;
                }

                if (!r.extractRoomPuzzle(currentRoomTitle, roomsHolder).equalsIgnoreCase("None")) {
                    System.out.println("Type Solve to Interact With Puzzle ");
                    ex = true;
                }
                if (ex == false) {
                    System.out.println("Type ExitRoom to view The Exits");
                }
            }

            if (userInputString.equalsIgnoreCase("Fight")) {
                //code in here need to act with monster class

            }

            if (userInputString.equalsIgnoreCase("Pickup")) {
                //code in here need to act with item class

            }

            if (userInputString.equalsIgnoreCase("Puzzle")) {
                //code in here need to act with puzzle class

            }

            if (userInputString.equalsIgnoreCase("ExitRoom")) {

                for (int i = 0; i < r.extractExitRooms(currentRoomTitle, roomsHolder).size(); i++) {
                    String ss = String.valueOf(r.extractExitRooms(currentRoomTitle, roomsHolder).get(i));
                    System.out.println(ss);
                }
            }


            if (userInputString.equalsIgnoreCase("ExitGame")) {
                isGameFinished = true;
            }

            if (userInputString.equalsIgnoreCase("Help")) {
                System.out.println("Type in : ExitGame to close the game.");
                System.out.println("");
            }
        }
    }
}

