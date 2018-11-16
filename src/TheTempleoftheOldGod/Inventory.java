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

    public void addToInventory(String currentRoomItem, Room[] rooms) {
        String itemName = r.extractRoomItem(currentRoomItem, roomsHolder);
        int itemQuantity = 1;
        if (!currentRoomItem.equalsIgnoreCase("None")) {
            inventoryMap.put(itemName, itemQuantity);
            System.out.println(r.extractRoomItem(currentRoomItem, roomsHolder) + " was added to your inventory.");
        }
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

    public String removeFromInventory(String currentRoomItem, Room[] rooms) {
        Scanner userInput = new Scanner(System.in);
        String itemToRemove = userInput.next();

        if (itemsExistInInventory(itemToRemove)) {
            itemQuantity = inventoryMap.get(itemToRemove);
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
            for (Map.Entry<String, Integer> entry : inventoryMap.entrySet()) {
                String name = entry.getKey().toString();
                Integer value = entry.getValue();
                System.out.println("You have " + name + " at this amount " + value);
            }
        }
    }


}