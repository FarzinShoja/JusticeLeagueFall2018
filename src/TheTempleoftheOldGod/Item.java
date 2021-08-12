package TheTempleoftheOldGod;

public class Item {
    private String itemID;
    private String itemTitle;
    private String itemDesc;
    private String itemType;
    private String itemEquippable;
    private String itemUsable;
    private String itemDamage;
    private String itemHealAmount;
    private String itemInfectionAmount;
    private String itemAmmo;

    public String getItemID() {

        return itemID;
    }

    public void setItemID(String itemID) {

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

    public String getItemEquippable() {
        return itemEquippable;
    }

    public void setItemEquippable(String itemEquippable) {
        this.itemEquippable = itemEquippable;
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
                ", itemEquippable='" + itemEquippable + '\'' +
                ", itemUsable='" + itemUsable + '\'' +
                ", itemDamage='" + itemDamage + '\'' +
                ", itemHealAmount='" + itemHealAmount + '\'' +
                ", itemInfectionAmount='" + itemInfectionAmount + '\'' +
                ", itemAmmo='" + itemAmmo + '\'' +
                '}';
    }

}
