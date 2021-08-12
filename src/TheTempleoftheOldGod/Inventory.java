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
                System.out.println(itemID + " " + value.get(0) + " x→ " + value.get(3));
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

    public void setDefaults(Item[] items) {
        String[] def = {"IT7", "IT8", "IT9"};
        for (int i = 2; i >= 0; i--) {
            ArrayList<String> itemDefaults = new ArrayList<>();
            String str = def[i];
            String s = "";
            for (int x = 0; x < items.length; x++) {
                if (items[x].getItemID().equals(str)) {
                    itemDefaults.clear();
                    itemDefaults.add(items[x].getItemID());
                    itemDefaults.add(items[x].getItemTitle());
                    itemDefaults.add(items[x].getItemDesc());
                    itemDefaults.add(items[x].getItemType());
                    itemDefaults.add(items[x].getItemEquippable());
                    itemDefaults.add(items[x].getItemUsable());
                    itemDefaults.add(items[x].getItemDamage());
                    itemDefaults.add(items[x].getItemHealAmount());
                    itemDefaults.add(items[x].getItemInfectionAmount());
                    itemDefaults.add(items[x].getItemAmmo());
                    s = items[x].getItemType();
                }
            }
            equippedMap.put(s, itemDefaults);
        }
    }

    public void setEquipped(String itemID, Item[] items) {
        ArrayList<String> itemInfo = new ArrayList<>();
        String itemType = "";
        for (Item item : items) {
            if (item.getItemID().equalsIgnoreCase(itemID)
                    && item.getItemEquippable().equals("true")) {
                itemInfo.add(item.getItemID());
                itemInfo.add(item.getItemTitle());
                itemInfo.add(item.getItemDesc());
                itemInfo.add(item.getItemType());
                itemInfo.add(item.getItemEquippable());
                itemInfo.add(item.getItemUsable());
                itemInfo.add(item.getItemDamage());
                itemInfo.add(item.getItemHealAmount());
                itemInfo.add(item.getItemInfectionAmount());
                itemInfo.add(item.getItemAmmo());
                itemType = item.getItemType();

                //Takes Item from Equipped by Type then adds in inventory Map
                ArrayList<String> itemHolder = equippedMap.get(itemType);
                ArrayList<String> newInventoryItem = new ArrayList<>();
                newInventoryItem.add(itemHolder.get(1));
                newInventoryItem.add(itemHolder.get(2));
                newInventoryItem.add(itemHolder.get(3));
                newInventoryItem.add("1");
                inventoryMap.put(itemHolder.get(0), newInventoryItem);

                equippedMap.remove(itemType);


                //Adding new Item by Type to Equipped Map
                equippedMap.put(itemType, itemInfo);

                inventoryMap.remove(itemID);
            }
        }
    }

    public String useConsumable(String itemID, Item[] items) {
        String itemHolder = "";
        for (Item item : items) {
            if (item.getItemID().equalsIgnoreCase(itemID)
                    && item.getItemType().equalsIgnoreCase("consumable")) {

                if (!item.getItemHealAmount().equalsIgnoreCase("0")) {
                    itemHolder = "H#" + item.getItemHealAmount();

                }
                if (!item.getItemInfectionAmount().equalsIgnoreCase("0")) {
                    itemHolder = "I#" + item.getItemInfectionAmount();

                }
                if (!item.getItemAmmo().equalsIgnoreCase("0")) {
                    itemHolder = "S#" + item.getItemAmmo();

                }

            }

        }
        return itemHolder;
    }

    public String useEquip(String itemID, Item[] items) {
        String itemHolder = "";
        for (Item item : items) {
            if (item.getItemID().equalsIgnoreCase(itemID)
                    && item.getItemEquippable().equalsIgnoreCase("true")) {
                itemHolder = "YES";
            }
        }
        return itemHolder;
    }

    public void getEquippedPrintOut() {
        if (equippedMap.size() == 0) {
            System.out.println("There's nothing in your inventory");
        } else {
            System.out.println(" ╤╤╤╤╤╤╤╤╤╤╤╤ Choose Your Weapon ╤╤╤╤╤╤╤╤╤╤╤╤");
            for (Map.Entry<String, ArrayList<String>> entry : equippedMap.entrySet()) {
                String itemType = entry.getKey();
                ArrayList value = entry.getValue();
                System.out.println("☼☼☼☼☼ " + itemType + "  " + value.get(1) + " \nDamage: " + value.get(6) + " \nInfection Point: " + value.get(8));
            }
        }
    }

}