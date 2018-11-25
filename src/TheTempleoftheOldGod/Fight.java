/*
package TheTempleoftheOldGod;


import java.util.Random;
import java.util.Scanner;


public class Fight {

    public String currentHeavyWeapon = player.getPlayerHeavyWeapon();
    Monster monster;
    Player player = new Player();

    private int monsterHealth = 45;

    private int playerHealth = 8;
    public String currentMainWeapon = player.getPlayerMainGun();

    public void Fight() {

    }
    public String currentSideArmWeapon = player.getPlayerSideArmWeapon();
    Item item = new Item();
    Room room = new Room();

    
*/
/*Player turn: The player types "attack", then they choose whether to use main, heavy, or sidearm.
The monster loses the amount of health that the weapon deals, then the player turn ends
 *//*


    public void playerTurn(String monsterName, String currentItemTitle) {
        boolean isPlayerTurn = true;
        monsterHealth = monster.extractMonsterHealth(monsterName, );
        int mainDmg = item.extractItemDamage(currentItemTitle, );
        int sidearmDmg = item.extractItemDamage(currentItemTitle, items);

        int heavyDmg = item.extractItemDamage(currentItemTitle, items);


        Scanner userInput = new Scanner(System.in);
        String playerCommand = userInput.next();
        while (isPlayerTurn == true) {
            if (playerCommand.equalsIgnoreCase("attack")) {
                if (playerCommand.equalsIgnoreCase("main")) {
                    monsterHealth -= mainDmg;
                    System.out.println("You hit " + monster.getMonsterName() + " for " + item.getItemDamage() + " health.");
                } else if (playerCommand.equalsIgnoreCase("sidearm")) {
                    monsterHealth -= sidearmDmg;
                    System.out.println("You hit " + monster.getMonsterName() + " for " + item.getItemDamage() + " health.");
                } else if (playerCommand.equalsIgnoreCase("heavy")) {
                    monsterHealth -= heavyDmg;
                    System.out.println("You hit " + monster.getMonsterName() + " for " + item.getItemDamage() + " health.");

                }
            }

            isPlayerTurn = false;
        }

    }

    */
/*Monster turn: 1 or 2 is randomly generated, whatever is generated corresponds to the type of
    attack the monster will do. The player will lose the amount of health that the monster deals
     *//*

    public void monsterTurn() {
        Random random = new Random();
        int attackChance = random.nextInt(1 - 2);
        boolean isMonsterTurn = true;
        while (isMonsterTurn == true) {
            if (attackChance == 1) {
                playerHealth -= monster.getMonsterLightDmg();
                System.out.println(monster.getmonsterLightDesc());
                System.out.println(monster.getMonsterName() + " hit you for " + monster.getMonsterLightDmg());
            } else if (attackChance == 2) {
                playerTurn();
                playerHealth -= monster.getMonsterHeavyDmg();
                System.out.println(monster.getMonsterHeavyDesc());
                System.out.println(monster.getMonsterName() + " hit you for " + monster.getMonsterHeavyDmg());
            }
        }
        isMonsterTurn = false;
    }

    */
/*public void combat() {
        boolean isFightOngoing = true;
        System.out.println("You Have Encountered" + monster.getMonsterName());

        while (isFightOngoing == true) {
            playerTurn();
            monsterTurn();

        }
        if(playerHealth <= 0|| monsterHealth <= 0){
        isFightOngoing = false;
        }


        }


    }*//*


}*/
