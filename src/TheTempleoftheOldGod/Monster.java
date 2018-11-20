package TheTempleoftheOldGod;

import java.util.ArrayList;

public class Monster {

    private int monsterID;
    private String monsterName;
    private String chosenName;
    private String monsterDesc;
    private String monsterRoom;
    private String monsterItem;
    private int monsterHealth;
    private int monsterLightDmg;
    private String monsterLightDesc;
    private int monsterHeavyDmg;
    private String monsterHeavyDesc;

    public Monster() {

    }

    public static ArrayList<String> extractAllMonsterNames(Monster[] monsters) {
        ArrayList<String> nameList = new ArrayList<>();
        for (Monster monster : monsters) {
            nameList.add(monster.getMonsterName());
        }
        return nameList;
    }

    public int getMonsterID() {
        return monsterID;
    }

    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getChosenName() {
        return chosenName;
    }

    public void setChosenName(String chosenName) {
        this.chosenName = chosenName;
    }

    public String getMonsterDesc() {
        return monsterDesc;
    }

    public void setMonsterDesc(String monsterDesc) {
        this.monsterDesc = monsterDesc;
    }

    public String getMonsterRoom() {
        return monsterRoom;
    }

    public void setMonsterRoom(String monsterRoom) {
        this.monsterRoom = monsterRoom;
    }

    public String getMonsterItem() {
        return monsterItem;
    }

    public void setMonsterItem(String monsterItem) {
        this.monsterItem = monsterItem;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public int getMonsterLightDmg() {
        return monsterLightDmg;
    }

    public void setMonsterLightDmg(int monsterLightDmg) {
        this.monsterLightDmg = monsterLightDmg;
    }

    public String getmonsterLightDesc() {
        return monsterLightDesc;
    }

    public void setmonsterLightDesc(String monsterLightDesc) {
        this.monsterLightDesc = monsterLightDesc;
    }

    public int getMonsterHeavyDmg() {
        return monsterHeavyDmg;
    }

    public void setMonsterHeavyDmg(int monsterHeavyDmg) {
        this.monsterHeavyDmg = monsterHeavyDmg;
    }

    public String getMonsterHeavyDesc() {
        return monsterHeavyDesc;
    }

    public void setMonsterHeavyDesc(String monsterHeavyDesc) {
        this.monsterHeavyDesc = monsterHeavyDesc;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monsterID=" + monsterID +
                ", monsterName='" + monsterName + '\'' +
                ", chosenName='" + chosenName + '\'' +
                ", monsterDesc='" + monsterDesc + '\'' +
                ", monsterRoom='" + monsterRoom + '\'' +
                ", monsterItem='" + monsterItem + '\'' +
                ", monsterHealth=" + monsterHealth +
                ", monsterLightDmg=" + monsterLightDmg +
                ", monsterLightDesc='" + monsterLightDesc + '\'' +
                ", monsterHeavyDmg=" + monsterHeavyDmg +
                ", monsterHeavyDesc='" + monsterHeavyDesc + '\'' +
                '}';
    }

    public String extractMonsterName(String currentMonsterName, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterName();
            }
        }
        return s;
    }

    public String extractChosenName(String currentMonsterName, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getChosenName();
            }
        }
        return s;
    }

    public String extractMonsterDesc(String currentMonsterName, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterDesc();
            }
        }
        return s;
    }

    public String extractMonsterRoom(String currentMonsterName, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterRoom();
            }
        }
        return s;
    }

    public String extractMonsterItem(String currentMonsterName, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterItem();
            }
        }
        return s;
    }

    public int extractMonsterHealth(String currentMonsterName, Monster[] monsters) {
        int s = 0;
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterHealth();
            }

        }
        return s;
    }

    public int extractMonsterLightDmg(String currentMonsterName, Monster[] monsters) {
        int s = 0;
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterLightDmg();
            }

        }
        return s;
    }

    public String extractmonsterLightDesc(String currentMonsterName, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getmonsterLightDesc();
            }
        }
        return s;
    }

    public int extractMonsterHeavyDmg(String currentMonsterName, Monster[] monsters) {
        int s = 0;
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterHeavyDmg();
            }

        }
        return s;
    }

    public String extractMonsterHeavyDesc(String currentMonsterName, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterHeavyDesc();
            }
        }
        return s;
    }
}
