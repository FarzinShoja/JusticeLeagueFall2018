package TheTempleoftheOldGod;

public class Player {
    private String playerName;
    private int playerHealth;
    private int playerMaxHealth;
    private int playerShield;
    private int playerHeavyDamage;
    private int playerLowDamage;
    private int playerInfection;
    private String playerMainGun;
    private String playerHeavyWeapon;
    private String playerSideArmWeapon;
    private boolean playerIsDead;

    public Player() {
        playerHealth = playerMaxHealth;
    }

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

    public int getPlayerShield() {
        return playerShield;
    }

    public void setPlayerShield(int playerShield) {
        this.playerShield = playerShield;
    }

    public int getPlayerHeavyDamage() {
        return playerHeavyDamage;
    }

    public void setPlayerHeavyDamage(int playerHeavyDamage) {
        this.playerHeavyDamage = playerHeavyDamage;
    }

    public int getPlayerLowDamage() {
        return playerLowDamage;
    }

    public void setPlayerLowDamage(int playerLowDamage) {
        this.playerLowDamage = playerLowDamage;
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

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerHealth=" + playerHealth +
                ", playerShield=" + playerShield +
                ", playerHeavyDamage=" + playerHeavyDamage +
                ", playerLowDamage=" + playerLowDamage +
                ", playerMainGun='" + playerMainGun + '\'' +
                ", playerHeavyWeapon='" + playerHeavyWeapon + '\'' +
                ", playerSideArmWeapon='" + playerSideArmWeapon + '\'' +
                '}';
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public int getPlayerInfection() {
        return playerInfection;
    }

    public void setPlayerInfection(int playerInfection) {
        this.playerInfection = playerInfection;
    }

    public boolean isAlive() {
        return playerHealth > 0;
    }

    public boolean isDead() {
        return playerHealth < 0;
    }

    public void newPlayerHealth() {
        playerHealth = 50;
    }

    public void newPlayerMaxHealth() {
        playerMaxHealth = 100;
    }

}
