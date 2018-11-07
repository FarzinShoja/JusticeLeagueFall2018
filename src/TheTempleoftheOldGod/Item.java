package TheTempleoftheOldGod;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Item {
    private int itemID;
    private String itemTitle;
    private String itemDesc;
    private String itemType;
    private String itemEquipable;
    private String itemUsable;
    private String itemDamage;
    private String itemHealAmount;
    private String itemInfectionAmount;
    private String itemAmmo;

    public static class ReadItemJson {
        public Item[] items;

        public void readItemJson() throws Exception {
            String str1 = FileUtils.readFileToString(new File("res/Items.json"), StandardCharsets.UTF_8);
            ObjectMapper om1 = new ObjectMapper();
            items = om1.readValue(str1, Item[].class);
        }

        public ReadItemJson() {
            try {
                readItemJson();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemEquipable() {
        return itemEquipable;
    }

    public void setItemEquipable(String itemEquipable) {
        this.itemEquipable = itemEquipable;
    }

    public String getItemUsable() {
        return itemUsable;
    }

    public void setItemUsable(String itemUsable) {
        this.itemUsable = itemUsable;
    }

    public String getItemDamage() {
        return itemDamage;
    }

    public void setItemDamage(String itemDamage) {
        this.itemDamage = itemDamage;
    }

    public String getItemHealAmount() {
        return itemHealAmount;
    }

    public void setItemHealAmount(String itemHealAmount) {
        this.itemHealAmount = itemHealAmount;
    }

    public String getItemInfectionAmount() {
        return itemInfectionAmount;
    }

    public void setItemInfectionAmount(String itemInfectionAmount) {
        this.itemInfectionAmount = itemInfectionAmount;
    }

    public String getItemAmmo() {
        return itemAmmo;
    }

    public void setItemAmmo(String itemAmmo) {
        this.itemAmmo = itemAmmo;
    }

    @Override
    public String toString() {
        return "item{" +
                "itemID=" + itemID +
                ", itemTitle='" + itemTitle + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemEquipable='" + itemEquipable + '\'' +
                ", itemUsable='" + itemUsable + '\'' +
                ", itemDamage='" + itemDamage + '\'' +
                ", itemHealAmount='" + itemHealAmount + '\'' +
                ", itemInfectionAmount='" + itemInfectionAmount + '\'' +
                ", itemAmmo='" + itemAmmo + '\'' +
                '}';
    }

    public static ArrayList extractAllItemTitles(Item[] items) {
        ArrayList titleList = new ArrayList();
        for (int i = 0; i < items.length; i++) {
            titleList.add(items[i].getItemTitle());
        }
        return titleList;
    }

    public String extractItemDesc(String currentItemTitle, Item[] items) {
        String s = "";
        for (int i = 0; i < items.length; i++) {
            if (currentItemTitle.equalsIgnoreCase(items[i].getItemTitle())) {
                s = items[i].getItemDesc();
            }
        }
        return s;
    }

    public String extractItemType(String currentItemTitle, Item[] items) {
        String s = "";
        for (int i = 0; i < items.length; i++) {
            if (currentItemTitle.equalsIgnoreCase(items[i].getItemTitle())) {
                s = items[i].getItemType();
            }
        }
        return s;
    }

    public boolean extractItemEquipable(String currentItemTitle, Item[] items) {
        boolean s = true;
        for (int i = 0; i < items.length; i++) {
            if (currentItemTitle.equalsIgnoreCase(items[i].getItemTitle())) {
                s = Boolean.parseBoolean(items[i].getItemEquipable());
            }
        }
        return s;
    }
    public boolean extractItemUsabable(String currentItemTitle, Item[] items) {
        boolean s = true;
        for (int i = 0; i < items.length; i++) {
            if (currentItemTitle.equalsIgnoreCase(items[i].getItemTitle())) {
                s = Boolean.parseBoolean(items[i].getItemEquipable());
            }
        }
        return s;
    }
    public int extractItemDamage(String currentItemTitle, Item[] items) {
        int s = 0;
        for (int i = 0; i < items.length; i++) {
            if (currentItemTitle.equalsIgnoreCase(items[i].getItemTitle())) {
                s = Integer.parseInt(items[i].getItemDamage());
            }

        }
        return s;
    }
    public int extractItemHealAmount(String currentItemTitle, Item[] items) {
        int s = 0;
        for (int i = 0; i < items.length; i++) {
            if (currentItemTitle.equalsIgnoreCase(items[i].getItemTitle())) {
                s = Integer.parseInt(items[i].getItemHealAmount());
            }

        }
        return s;
    }
    public int extractInfectionAmount(String currentItemTitle, Item[] items) {
        int s = 0;
        for (int i = 0; i < items.length; i++) {
            if (currentItemTitle.equalsIgnoreCase(items[i].getItemTitle())) {
                s = Integer.parseInt(items[i].getItemInfectionAmount());
            }

        }
        return s;
    }
    public int extractItemAmmo(String currentItemTitle, Item[] items) {
        int s = 0;
        for (int i = 0; i < items.length; i++) {
            if (currentItemTitle.equalsIgnoreCase(items[i].getItemTitle())) {
                s = Integer.parseInt(items[i].getItemAmmo());
            }

        }
        return s;
    }

    public static void main(String[] args) {
        ReadItemJson read = new ReadItemJson();
        Item r = new Item();
        Item[] itemsHolder = read.items;

        System.out.println(r.extractItemDamage("key", itemsHolder));
    }

}
