package TheTempleoftheOldGod;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {


    ReadJSonFile read = new ReadJSonFile();
    Room r = new Room();
    Room[] roomsHolder = read.rooms;
    Item i = new Item();
    Item[] itemHolder = read.items;
    int itemQuantity = 0;

    private Map<String, ArrayList<String>> inventoryMap = new LinkedHashMap<>();

    public Map<String, ArrayList<String>> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Map<String, ArrayList<String>> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryMap=" + inventoryMap +
                '}';
    }

    public void addToInventory(String itemID, Item[] items) {
        if (inventoryMap.containsKey(itemID)) {
            ArrayList<String> itemInfo = inventoryMap.get(itemID);
            int itemQuantity = Integer.parseInt(itemInfo.get(3));
            itemQuantity++;
            itemInfo.set(3, String.valueOf(itemQuantity));
            inventoryMap.put(itemID, itemInfo);
            System.out.println("You have Added Another " + itemInfo.get(0) + " to You Inventory");
        } else {
            for (int i = 0; i < items.length; i++) {
                if (items[i].getItemID().equalsIgnoreCase(itemID)) {
                    ArrayList<String> itemInfo = new ArrayList<>();
                    itemInfo.add(items[i].getItemTitle());
                    itemInfo.add(items[i].getItemDesc());
                    itemInfo.add(items[i].getItemType());
                    itemInfo.add("1");
                    inventoryMap.put(itemID, itemInfo);
                    System.out.println("You have Added " + items[i].getItemTitle() + " to You Inventory");

                }
            }
        }
    }

    public void removeFromInventory(String itemID) {
        ArrayList<String> itemInfo = inventoryMap.get(itemID);
        int itemQuantity = Integer.parseInt(itemInfo.get(3));
        if (itemQuantity > 1) {
            itemQuantity--;
            itemInfo.set(3, String.valueOf(itemQuantity));
            inventoryMap.put(itemID, itemInfo);
        } else {
            inventoryMap.remove(itemID);
        }
    }

    public void checkInventory() {
        if (inventoryMap.size() == 0) {
            System.out.println("There's nothing in your inventory");
        } else {
            for (Map.Entry<String, ArrayList<String>> entry : inventoryMap.entrySet()) {
                String itemID = entry.getKey();
                ArrayList value = entry.getValue();
                System.out.println("You have " + itemID + " " + value.get(0) + ": " + value.get(1) + " is" + value.get(2) + " at this amount  " + value.get(3));
            }
        }
    }

    public void checkInventoryForDrop() {
        if (inventoryMap.size() == 0) {
            System.out.println("There's nothing in your inventory");
        } else {
            for (Map.Entry<String, ArrayList<String>> entry : inventoryMap.entrySet()) {
                String itemID = entry.getKey();
                ArrayList value = entry.getValue();
                System.out.println(itemID + value.get(0) + " x" + value.get(3));
            }
        }
    }



}