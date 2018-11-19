package TheTempleoftheOldGod;

public class Player {
    private String playerName;
    private int playerHealth;
    private int playerMaxHealth;
    private int playerShield;
    private int playerInfection;
    private String playerMainGun;
    private String playerHeavyWeapon;
    private String playerSideArmWeapon;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public int getPlayerShield() {
        return playerShield;
    }

    public void setPlayerShield(int playerShield) {
        this.playerShield = playerShield;
    }

    public int getPlayerInfection() {
        return playerInfection;
    }

    public void setPlayerInfection(int playerInfection) {
        this.playerInfection = playerInfection;
    }

    public String getPlayerMainGun() {
        return playerMainGun;
    }

    public void setPlayerMainGun(String playerMainGun) {
        this.playerMainGun = playerMainGun;
    }

    public String getPlayerHeavyWeapon() {
        return playerHeavyWeapon;
    }

    public void setPlayerHeavyWeapon(String playerHeavyWeapon) {
        this.playerHeavyWeapon = playerHeavyWeapon;
    }

    public String getPlayerSideArmWeapon() {
        return playerSideArmWeapon;
    }

    public void setPlayerSideArmWeapon(String playerSideArmWeapon) {
        this.playerSideArmWeapon = playerSideArmWeapon;
    }

    public boolean isAlive() {
        return playerHealth > 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerHealth=" + playerHealth +
                ", playerMaxHealth=" + playerMaxHealth +
                ", playerShield=" + playerShield +
                ", playerInfection=" + playerInfection +
                ", playerMainGun='" + playerMainGun + '\'' +
                ", playerHeavyWeapon='" + playerHeavyWeapon + '\'' +
                ", playerSideArmWeapon='" + playerSideArmWeapon + '\'' +
                '}';
    }

    public boolean isDead(Player player) {
        if ((player.getPlayerHealth() <= 0) && (player.playerInfection == 100)) {
            return true;
        } else return player.getPlayerHealth() <= 0;
    }

    public void newPlayerHealth() {
        playerHealth = 50;
    }

    public void newPlayerMaxHealth() {
        playerMaxHealth = 100;
    }

    public void newPlayerSheild() {
        playerShield = 1;
    }

    public void newPlayerInfection() {
        playerInfection = 0;
    }

    public void newPlayerHeavyWeapon() {
    }
}