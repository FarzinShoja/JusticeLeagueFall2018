package TheTempleoftheOldGod;


import java.util.Random;

public class Monster {


    private int monsterID;
    private String monsterName;
    private String monsterSecondName;
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

    public String getMonsterSecondName() {
        return monsterSecondName;
    }

    public void setMonsterSecondName(String monsterSecondName) {
        this.monsterSecondName = monsterSecondName;
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

    public String getMonsterLightDesc() {
        return monsterLightDesc;
    }

    public void setMonsterLightDesc(String monsterLightDesc) {
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
                ", monsterSecondName='" + monsterSecondName + '\'' +
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

    public String extractMonsterName(String currentMonsterRoom, Monster[] monsters) {
        String s = "";
        for (Monster monster : monsters) {
            if (currentMonsterRoom.equalsIgnoreCase(monster.getMonsterRoom())) {
                s = monster.getMonsterName();
            }
        }
        return s;
    }

    public String extractMonsterSecondName(String currentMonsterRoom, Monster[] monsters) {
        String s = "";
        for (Monster monster : monsters) {
            if (currentMonsterRoom.equalsIgnoreCase(monster.getMonsterRoom())) {
                s = monster.getMonsterSecondName();
            }
        }
        return s;
    }

    public String extractMonsterDesc(String currentMonsterRoom, Monster[] monsters) {
        String s = "";
        for (Monster monster : monsters) {
            if (currentMonsterRoom.equalsIgnoreCase(monster.getMonsterRoom())) {
                s = monster.getMonsterDesc();
            }
        }
        return s;
    }

    public int extractMonsterLightDmg(String currentMonsterRoom, Monster[] monsters) {
        int s = 0;
        for (Monster monster : monsters) {
            if (currentMonsterRoom.equalsIgnoreCase(monster.getMonsterRoom())) {
                s = monster.getMonsterLightDmg();
            }

        }
        return s;
    }


    public int extractMonsterHeavyDmg(String currentMonsterRoom, Monster[] monsters) {
        int s = 0;
        for (Monster monster : monsters) {
            if (currentMonsterRoom.equalsIgnoreCase(monster.getMonsterRoom())) {
                s = monster.getMonsterHeavyDmg();
            }

        }
        return s;
    }


    public int extractMonsterHealth(String currentMonsterRoom, Monster[] monsters) {
        int s = 0;
        for (Monster monster : monsters) {
            if (currentMonsterRoom.equalsIgnoreCase(monster.getMonsterRoom())) {
                s = monster.getMonsterHealth();
            }

        }
        return s;
    }

    public int giveDMG(String currentMonsterRoom, Monster[] monsters) {
        int dmg = 0;
        Random random = new Random();
        for (Monster monster : monsters) {
            if (currentMonsterRoom.equalsIgnoreCase(monster.getMonsterRoom())) {
                if (random.nextBoolean()) {
                    dmg = monster.getMonsterHeavyDmg();
                } else
                    dmg = monster.getMonsterLightDmg();

            }
        }

        return dmg;
    }


    public int takeDMG(int dmg, int monsterHealth) {
        int mH = monsterHealth - dmg;
        if (mH < 0) {
            mH = 0;
        }
        System.out.println("Monster ♥ " + mH);
        return mH;

    }

}
