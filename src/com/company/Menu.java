package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner (System.in);

    //menu to prompt uer for Library options
    public void startMenu(){

        try {

            System.out.println("What would you like to do?" +
                    "\n1. Add a game to the library" +
                    "\n2. Remove a game from the library" +
                    "\n3. View what is currently in the library" +
                    "\n4. Check out a game" +
                    "\n5/ Check in a game" +
                    "\n6. View checked out games" +
                    "\n7. Exit the program");

            switch (input.nextInt()) {
                case 1:
                    //Add a game
                    break;
                case 2:
                    //Remove a game
                    break;
                case 3:
                    //View games in library
                    break;
                case 4:
                    //Check out a game
                    break;
                case 5:
                    //Check in a game
                    break;
                case 6:
                    //View checked out games
                    break;
                case 7:
                    //Exit program
                    System.out.println("Thank you for using the Video Game Library!");
                    System.exit(0);
                    break;
                default:
                    //Exit program
                    System.out.println("That's not a valid entry. Please pick a number between 1-7/");
                    startMenu();
                    break;

            }
        } catch (InputMismatchException ime) {
            System.out.println(ime.toString());
            input.nextLine();
            System.out.println("That's not a valid entry. Please pick a number between 1-7.");
            startMenu();
        }
    }

}
