package TheTempleoftheOldGod;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {

    private Map<String, ArrayList<String>> inventoryMap = new LinkedHashMap<>();
    private Map<String, ArrayList<String>> equippedMap = new LinkedHashMap<>();


    public Map<String, ArrayList<String>> getEquippedMap() {
        return equippedMap;
    }

    public void setEquippedMap(Map<String, ArrayList<String>> equippedMap) {
        this.equippedMap = equippedMap;
    }

    public Map<String, ArrayList<String>> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Map<String, ArrayList<String>> inventoryMap) {
        this.inventoryMap = inventoryMap;
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
                System.out.println("You have " + itemID + " " + value.get(0) + "\n ^ Description:  " +
                        value.get(1) + " \n ^^ Type: " + value.get(2) + "\n ^^^ Quantity:  " + value.get(3));
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
                System.out.println(itemID + " " + value.get(0) + " x" + value.get(3));
            }
        }
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryMap=" + inventoryMap +
                ", equipped=" + equippedMap +
                '}';
    }

    public void setDefults(Item[] items) {
        String[] def = {"IT7", "IT8", "IT9"};
        for (int i = 2; i >= 0; i--) {
            ArrayList<String> itemDefult = new ArrayList<>();
            String str = def[i];
            String s = "";
            for (int x = 0; x < items.length; x++) {
                if (items[x].getItemID().equals(str)) {
                    itemDefult.clear();
                    itemDefult.add(items[x].getItemID());
                    itemDefult.add(items[x].getItemTitle());
                    itemDefult.add(items[x].getItemDesc());
                    itemDefult.add(items[x].getItemType());
                    itemDefult.add(items[x].getitemEquippable());
                    itemDefult.add(items[x].getItemUsable());
                    itemDefult.add(items[x].getItemDamage());
                    itemDefult.add(items[x].getItemHealAmount());
                    itemDefult.add(items[x].getItemInfectionAmount());
                    itemDefult.add(items[x].getItemAmmo());

                    s = items[x].getItemType();
                }
            }
            equippedMap.put(s, itemDefult);
        }
    }

    public void setEqupped(String itemID, Item[] items) {
        ArrayList<String> itemInfo = new ArrayList<>();
        String itemType = "";
        for (int x = 0; x < items.length; x++) {
            if (items[x].getItemID().equalsIgnoreCase(itemID)
                    && items[x].getitemEquippable().equalsIgnoreCase("true")) {
                itemInfo.add(items[x].getItemID());
                itemInfo.add(items[x].getItemTitle());
                itemInfo.add(items[x].getItemDesc());
                itemInfo.add(items[x].getItemType());
                itemInfo.add(items[x].getitemEquippable());
                itemInfo.add(items[x].getItemUsable());
                itemInfo.add(items[x].getItemDamage());
                itemInfo.add(items[x].getItemHealAmount());
                itemInfo.add(items[x].getItemInfectionAmount());
                itemInfo.add(items[x].getItemAmmo());
                itemType = items[x].getItemType();

                //Takes Item from Equpped by Type then adds in inventory Map
                ArrayList<String> itemHolder = equippedMap.get(itemType);
                ArrayList<String> newInventoryItem = new ArrayList<>();
                newInventoryItem.add(itemHolder.get(1));
                newInventoryItem.add(itemHolder.get(2));
                newInventoryItem.add(itemHolder.get(3));
                newInventoryItem.add("1");
                inventoryMap.put(itemHolder.get(0), newInventoryItem);

                equippedMap.remove(itemType);


                //Adding new Item by Type to Equpped Map
                equippedMap.put(itemType, itemInfo);

                inventoryMap.remove(itemID);
            }
        }
    }

    public String useConsumable(String itemID, Item[] items) {
        String itemHolder = "";
        for (int x = 0; x < items.length; x++) {
            if (items[x].getItemID().equalsIgnoreCase(itemID)
                    && items[x].getItemType().equalsIgnoreCase("consumable")) {

                if (!items[x].getItemHealAmount().equalsIgnoreCase("0")) {
                    itemHolder = "H#" + items[x].getItemHealAmount();
                    removeFromInventory(itemID);

                }
                if (!items[x].getItemInfectionAmount().equalsIgnoreCase("0")) {
                    itemHolder = "I#" + items[x].getItemInfectionAmount();
                    removeFromInventory(itemID);
                }
                if (!items[x].getItemAmmo().equalsIgnoreCase("0")) {
                    itemHolder = "S#" + items[x].getItemAmmo();
                    removeFromInventory(itemID);
                }

            }

        }
        return itemHolder;
    }


}