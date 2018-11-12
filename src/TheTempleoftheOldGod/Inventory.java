package TheTempleoftheOldGod;

import TheTempleoftheOldGod.Main;
import TheTempleoftheOldGod.ReadJSonFile;
import TheTempleoftheOldGod.Room;

import java.util.HashMap;
import java.util.Scanner;

public class Inventory {


    public static HashMap<String, Integer> inventory = new HashMap<>();

    public static String addToInventory(String currentRoomTitle, Room[] rooms) {

        int amount = 1;
        String s = "";
        for (int i = 0; i < rooms.length; i++) {

            if (currentRoomTitle.equalsIgnoreCase(rooms[i].getRoomTitle())) {
                s = rooms[i].getRoomItem();
            }
        }
        if (s.isEmpty()) {
            System.out.println("There are no items here");
        } else if (inventory.containsKey(s)) {
            inventory.put(s, inventory.get(s) + 1);

        } else {
            inventory.put(s, 1);
            System.out.println(s + " was added to your inventory");
        }

        return s;


    }

    public static String removeFromInventory(Scanner userInput) {
        String item = "";

        if (inventory.size() == 0) {
            System.out.println("There's nothing in your inventory");
        } else {

            item = userInput.nextLine();
            if (inventory.containsKey(item)) {

                inventory.remove(item);
                System.out.println(item + " was dropped");
            }
        }
        return item;
    }

    public static void CheckInventory() {
        if (inventory.size() == 0) {
            System.out.println("There's nothing in your inventory");
        } else {


            System.out.println(inventory);
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ReadJSonFile read = new ReadJSonFile();
        Room r = new Room();
        Room[] roomsHolder = read.rooms;

        addToInventory("PuzzleRoom1", roomsHolder);
        CheckInventory();
        addToInventory("PuzzleRoom1", roomsHolder);
        CheckInventory();


    }
}
