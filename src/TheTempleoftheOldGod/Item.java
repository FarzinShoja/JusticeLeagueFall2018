package TheTempleoftheOldGod;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Item {

    private int ItemID;
    private String allItemTitles;
    private String itemTitle;
    private String itemDesc;
    private String itemType;
    private String itemEquipable;
    private String itemUsable;
    private String itemDamage;
    private String itemHealAmount;
    private String itemInfectionAmount;
    private String itemAmmo;

    public Item() {

    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public String getAllItemTitles() {
        return allItemTitles;
    }

    public void setAllItemTitles(String allItemTitles) {
        this.allItemTitles = allItemTitles;
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

    private void setItemAmmo(String itemAmmo) {
        this.itemAmmo = itemAmmo;
    }

    public void readItemJson() throws Exception{
        String str  = FileUtils.readFileToString(new File("res/Items.json"), StandardCharsets.UTF_8);
        ObjectMapper oM1 = new ObjectMapper();
        Item[] items = oM1.readValue(str,Item[].class);
    }
    public void testDeserialization() throws Exception {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Item Title");
            String read = sc.next();

        }

    }
}

