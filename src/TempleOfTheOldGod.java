package TheTempleoftheOldGod;

import java.util.Scanner;

public class TempleOfTheOldGod {
    public static void main(String[] args) {
        System.out.println("What do you want to do?");

        Scanner userInput = new Scanner;
        String menuCode = userInput.nextLine();

        if(menuCode.equals("/help")){
            System.out.println(/*help command*/);
        }
        else if(menuCode.equals("/interact")){
            System.out.println(/*scan command*/);
        }
        else if(menuCode.equals("/inventory")){
            System.out.println(/*inventory command*/);
        }
        else if(menuCode.equals("/progress")){
            System.out.println(/*progress command*/);
        }
    }

    public static String MainMenu(String menuCode){

    }

    public static void help(){
        commands();
    }

    public static void commands(){
        System.out.println("/help: " + "Gives you a list of possible commands");
        System.out.println("/interact: " + "Gives you a list of possible commands");
        System.out.println("/inventory: " + "Gives you access to the '/view', 'equip', unequip commands");
        System.out.println("/progress: " + "Gives you access to the '/save' and '/load' commands");

    }

}
