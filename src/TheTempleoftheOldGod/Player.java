package TheTempleoftheOldGod;

import java.util.ArrayList;

public class Player {
    private String playerName;
    private int playerHealth;
    private int playerShield;
    private int playerInfection;
    private ArrayList<String> playerMainGun;
    private ArrayList<String> playerHeavyWeapon;
    private ArrayList<String> playerSideArmWeapon;
    private boolean isAlive = true;

    public Player() {
        this.playerHealth = 50;
        this.playerInfection = 0;
        this.playerShield = 1;
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

    public int getPlayerInfection() {
        return playerInfection;
    }

    public void setPlayerInfection(int playerInfection) {
        this.playerInfection = playerInfection;
    }

    public ArrayList<String> getPlayerMainGun() {
        return playerMainGun;
    }

    public void setPlayerMainGun(ArrayList<String> playerMainGun) {
        this.playerMainGun = playerMainGun;
    }

    public ArrayList<String> getPlayerHeavyWeapon() {
        return playerHeavyWeapon;
    }

    public void setPlayerHeavyWeapon(ArrayList<String> playerHeavyWeapon) {
        this.playerHeavyWeapon = playerHeavyWeapon;
    }

    public ArrayList<String> getPlayerSideArmWeapon() {
        return playerSideArmWeapon;
    }

    public void setPlayerSideArmWeapon(ArrayList<String> playerSideArmWeapon) {
        this.playerSideArmWeapon = playerSideArmWeapon;
    }


    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerHealth=" + playerHealth +
                ", playerShield=" + playerShield +
                ", playerInfection=" + playerInfection +
                ", playerMainGun=" + playerMainGun +
                ", playerHeavyWeapon=" + playerHeavyWeapon +
                ", playerSideArmWeapon=" + playerSideArmWeapon +
                '}';
    }

    public void isDead(Player player) {
        if ((player.getPlayerHealth() <= 0) || (player.playerInfection == 100)) {
            isAlive = false;
        }
    }

    public void usedConsumable(String str) {
        String[] parts = str.split("#");
        String part1 = parts[0];
        String part2 = parts[1];
        if (part1.equals("H")) {
            playerHealth += Integer.parseInt(part2);
            if (playerHealth > 100) {
                playerHealth = 100;
            }
            System.out.println("The Player Health Is Now :" + playerHealth);
        }

        if (part1.equals("I")) {
            playerInfection += Integer.parseInt(part2);
            if (playerInfection < 0) {
                playerInfection = 0;
            }
            if (playerInfection >= 100) {
                isAlive = false;
            }
            System.out.println("The Player Infection Is Now :" + playerInfection);
        }
        if (part1.equals("S")) {
            playerShield += Integer.parseInt(part2);
            System.out.println("The Player Shield Charges Is Now at:" + playerShield);
        }

    }
}