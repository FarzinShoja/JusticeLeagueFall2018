package TheTempleoftheOldGod;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {


    ReadJSonFile read = new ReadJSonFile();
    Room r = new Room();
    Room[] roomsHolder = read.rooms;
    Item i = new Item();
    Item[] itemHolder = read.items;
    int itemQuantity = 0;
    private Map<String, Integer> inventoryMap = new LinkedHashMap<>();

    public Map<String, Integer> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Map<String, Integer> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryMap=" + inventoryMap +
                '}';
    }


    public boolean itemsExistInInventory(String itemTitle) {
        boolean itemExist = false;
        if (inventoryMap.containsKey(itemTitle)) {
            itemExist = true;
        } else {
            //Do Nothing
        }

        return itemExist;
    }

    public String addToInventory(String currentRoomItem, Room[] rooms) {
        if (!inventoryMap.isEmpty()) {
            itemQuantity = inventoryMap.get(currentRoomItem);
            for (int j = 0; j < rooms.length; j++) {
                if (!currentRoomItem.equalsIgnoreCase("None")) {
                    inventoryMap.put(r.extractRoomItem(currentRoomItem, roomsHolder), itemQuantity + 1);

                }
                System.out.println(r.extractRoomItem(currentRoomItem, roomsHolder) + " was added to your inventory.");
            }
            return i.getItemTitle();
        } else {
            int itemQuantity = 0;
            for (int j = 0; j < rooms.length; j++) {
                if (!currentRoomItem.equalsIgnoreCase("None")) {
                    inventoryMap.put(r.extractRoomItem(currentRoomItem, roomsHolder), itemQuantity + 1);

                }
            }
            System.out.println(r.extractRoomItem(currentRoomItem, roomsHolder) + " was added to your inventory.");
        }
        return i.getItemTitle();
    }

    public String removeFromInventory(String currentRoomItem, Room[] rooms) {
        Scanner userInput = new Scanner(System.in);
        String itemToRemove = userInput.next();

        if (itemsExistInInventory(itemToRemove)) {
            itemQuantity = inventoryMap.get(currentRoomItem);
            for (int j = 0; j < rooms.length; j++) {
                inventoryMap.put(r.extractRoomItem(currentRoomItem, roomsHolder), itemQuantity - 1);

                if (inventoryMap.containsValue(0)) {
                    inventoryMap.remove(r.extractRoomItem(currentRoomItem, roomsHolder), itemQuantity);
                }
            }
        } else {
            System.out.println("That item is not in your inventory");
        }
        return i.getItemTitle();
    }

    public void checkInventory() {
        if (inventoryMap.size() == 0) {
            System.out.println("There's nothing in your inventory");
        } else {


            System.out.println(inventoryMap);
        }
    }
}




    /*
package TheTempleoftheOldGod;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {


    private Map<String, Integer> inventoryMap = new LinkedHashMap<>();

    public  String addToInventory(String currentRoomTitle, Room[] rooms) {

        int amount = 1;
        String s = "";
        for (int i = 0; i < rooms.length; i++) {

            if (currentRoomTitle.equalsIgnoreCase(rooms[i].getRoomTitle())) {
                s = rooms[i].getRoomItem();
            }
        }
        if (s.isEmpty()) {
            System.out.println("There are no items here");
        } else if (inventoryMap.containsKey(s)) {
            inventoryMap.put(s, inventoryMap.get(s) + 1);

        } else {
            inventoryMap.put(s, 1);
            System.out.println(s + " was added to your inventory");
        }

        return s;


    }

    public String removeFromInventory(Scanner userInput) {
        String item = "";

        if (inventoryMap.size() == 0) {
            System.out.println("There's nothing in your inventory");
        } else {

            item = userInput.nextLine();
            if (inventoryMap.containsKey(item)) {

                inventoryMap.remove(item);
                System.out.println(item + " was dropped");
            }
        }
        return item;
    }

    public void CheckInventory() {
        if (inventoryMap.size() == 0) {
            System.out.println("There's nothing in your inventory");
        } else {


            System.out.println(inventoryMap);
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
*/
