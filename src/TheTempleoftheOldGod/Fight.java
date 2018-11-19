package TheTempleoftheOldGod;

import java.util.Scanner;


public class fight {

    Monster monster = new Monster();
    Player player = new Player();
    public int PlayerHealth = player.getPlayerHealth();
    public String currentMainWeapon = player.getPlayerMainGun();
    public String currentHeavyWeapon = player.getPlayerHeavyWeapon();]monsters)
    public String currentSideArmWeapon = player.getPlayerSideArmWeapon();
    Item item = new Item();
    Room room = new Room();
    public int MonsterHealth = monster.extractMonsterHealth(room.getRoomTitle(), Monster[

    public static void main(String[] args) {

        combat();
    }

    public void playerTurn() {
        Scanner userInput = new Scanner(System.in);
        String playerCommand = userInput.next();

        boolean isPlayerTurn = true;
        while (isPlayerTurn == true) {
            if (playerCommand.equalsIgnoreCase("attack")) {
                if (playerCommand.equalsIgnoreCase("main")) {
                    System.out.println("You hit " + monster.getMonsterName() + " for " + item.getItemDamage() + " health.");
                } else if (playerCommand.equalsIgnoreCase("sidearm")) {
                    System.out.println("You hit " + monster.getMonsterName() + " for " + item.getItemDamage() + " health.");
                }
            } else if (playerCommand.equalsIgnoreCase("heavy")) {
                {
                    System.out.println("You hit " + monster.getMonsterName() + " for " + item.getItemDamage() + " health.");
                }
            }
        }
        isPlayerTurn = false;
    }

    public void monsterTurn() {

        boolean isMonsterTurn = true;
        while (isMonsterTurn == true) {

        }
        isMonsterTurn = false;
    }

    public void combat() {
        boolean isFightOngoing = true;
        System.out.println("You Have Encountered" + monster.getMonsterName());
        while (isFightOngoing = true) {
            playerTurn();
            monsterTurn();
        }
    }
}
