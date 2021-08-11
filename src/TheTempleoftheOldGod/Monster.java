package TheTempleoftheOldGod;


public class Monster {


    Player player = new Player();

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
    private boolean isAlive = true;


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

    public String getMonsterSecondName() {
        return monsterSecondName;
    }

    public void setMonsterSecondName(String monsterSecondName) {
        this.monsterSecondName = monsterSecondName;
    }

    public String getMonsterLightDesc() {
        return monsterLightDesc;
    }

    public void setMonsterLightDesc(String monsterLightDesc) {
        this.monsterLightDesc = monsterLightDesc;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    @Override
    public String toString() {
        return "Monster{" +
                "player=" + player +
                ", monsterID=" + monsterID +
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
                ", isAlive=" + isAlive +
                '}';
    }

    public String extractMonsterName(String currentMonsterRoom, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterRoom.equalsIgnoreCase(monsters[i].getMonsterRoom())) {
                s = monsters[i].getMonsterName();
            }
        }
        return s;
    }

    public String extractMonsterSecondName(String currentMonsterRoom, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterRoom.equalsIgnoreCase(monsters[i].getMonsterRoom())) {
                s = monsters[i].getMonsterSecondName();
            }
        }
        return s;
    }

    public String extractMonsterDesc(String currentMonsterRoom, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterRoom.equalsIgnoreCase(monsters[i].getMonsterRoom())) {
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

    public int extractMonsterLightDmg(String currentMonsterName, Monster[] monsters) {
        int s = 0;
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterLightDmg();
            }

        }
        return s;
    }

    public String extractMonsterLightDesc(String currentMonsterName, Monster[] monsters) {
        String s = "";
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterName.equalsIgnoreCase(monsters[i].getMonsterName())) {
                s = monsters[i].getMonsterLightDesc();
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

    public int extractMonsterHealth(String currentMonsterRoom, Monster[] monsters) {
        int s = 0;
        for (int i = 0; i < monsters.length; i++) {
            if (currentMonsterRoom.equalsIgnoreCase(monsters[i].getMonsterRoom())) {
                s = monsters[i].getMonsterHealth();
            }

        }
        return s;
    }

    public void monsterTakeDMG(int damage) {
        monsterHealth -= damage;
        if (monsterHealth < 0) {
            monsterHealth = 0;
        }
    }

    public void monsterGiveDMG(int damage) {
        player.setPlayerHealth(-(damage));
    }

    public void monsterIsDead(Monster monster) {
        if ((monster.getMonsterHealth() <= 0)) {
            isAlive = false;
        }
    }

}
