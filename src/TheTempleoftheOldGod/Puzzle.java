package TheTempleoftheOldGod;

import java.util.Scanner;

public class Puzzle {


    Scanner puzzleInputScanner = new Scanner(System.in);


    public void getPuzzle(String currentRoomTitle) {


        if (currentRoomTitle.equalsIgnoreCase("Outside")) {
            System.out.println("So What Should You DO With Ship That Contains Missie and Block Path");
            while (true) {
                String puzzleInputString = puzzleInputScanner.nextLine();
                if (puzzleInputString.equalsIgnoreCase("Fire")) {
                    System.out.println("the missiles into the rubble, clearing the way into the Temple");
                    break;
                } else {
                    System.out.println("Try Again");
                }
            }

        }


        if (currentRoomTitle.equalsIgnoreCase("PuzzleRoom1")) {
            System.out.println("Maybe You Use one Of Your Weapons to Melt the Ice ");
            System.out.println(" 'Extra Vehicular Assault Rifle, 'Flamethrower, 'The Clyde-15 ");
            while (true) {
                String puzzleInputString = puzzleInputScanner.nextLine();
                if (puzzleInputString.equalsIgnoreCase("Flamethrower")) {
                    System.out.println("Nice Job, by Examining the Room you should be able to see a reward for solving this puzzle");
                    break;
                } else {
                    System.out.println("Try Again");
                }
            }
        }

        if (currentRoomTitle.equalsIgnoreCase("PuzzleRoom2")) {
            System.out.println("Within me is a great artifact of our Most Holy, prove you Worth by answering this question, “What is the Esteemed name of the Great One’s Servants");
            while (true) {
                String puzzleInputString = puzzleInputScanner.nextLine();
                if (puzzleInputString.equalsIgnoreCase("The Chosen")) {
                    System.out.println("Nice Job, by Examining the Room you should be able to see a reward for solving this puzzle");
                    break;
                } else {
                    System.out.println("Try Again");
                }
            }
        }


        if (currentRoomTitle.equalsIgnoreCase("PuzzleRoom3")) {
            System.out.println("Numbers arise on the screen, they appear to be binary “0101, 1010, 0110 , “Input the correct number in base 10");
            while (true) {
                String puzzleInputString = puzzleInputScanner.nextLine();
                if (puzzleInputString.equalsIgnoreCase("5, 10, 6")) {
                    System.out.println("Nice Job, by Examining the Room you should be able to see a reward for solving this puzzle");
                    break;
                } else {
                    System.out.println("Try Again");
                }
            }
        }


    }
}