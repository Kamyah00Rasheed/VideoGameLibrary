package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner (System.in);
    private Library library = new Library(this);

    //menu to prompt uer for Library options
    public void startMenu(){

        try {

            System.out.println("What would you like to do?" +
                    "\n1. Add a game to the library" +
                    "\n2. Remove a game from the library" +
                    "\n3. View what is currently in the library" +
                    "\n4. Check out a game" +
                    "\n5. Check in a game" +
                    "\n6. View checked out games" +
                    "\n7. Exit the program");

            switch (input.nextInt()) {
                case 1:
                    input.nextLine();
                    //Add a game
                    System.out.println("You have chosen to add a game.");
                    library.addGame();
                    break;
                case 2:
                    System.out.println("Which game would you like to remove?");
                    library.listGamesInLibrary("forRemoval");
                    library.removeGame(input.nextInt() - 1);
                    //Remove a game
                    break;
                case 3:
                    input.nextLine();
                    //View games in library
                    library.listGamesInLibrary("inLibrary");
                    System.out.println("\n");
                    break;
                case 4:
                    input.nextLine();
                    //Check out a game
                    System.out.println("You have chosen to check out a game" +
                            "\nHere is a list of all games available to check out:");
                    library.listGamesInLibrary("checkOut");
                    System.out.println("Choose a number for the game you would like:");
                    library.checkOutGame(input.nextInt() - 1);
                    break;
                case 5:
                    input.nextLine();
                    //Check in a game
                    System.out.println("WHat game are you checking in?");
                    library.listCheckedOut("CheckIn");
                    library.checkInGame(input.nextInt() -1);
                    break;
                case 6:
                    library.listCheckedOut("viewCheckedOut");
                    //View checked out games
                    break;
                case 7:
                    //Exit program
                    System.out.println("Thank you for using the Video Game Library!");
                    System.exit(0);
                    break;
                default:
                    //Exit program
                    System.out.println("That's not a valid entry. Please pick a number between 1-7.");
                    startMenu();
                    break;

            }
        } catch (InputMismatchException ime) {
            System.out.println(ime.toString());
            input.nextLine();
            System.out.println("That's not a valid entry. Please pick a number between 1-7.");
            startMenu();
        } catch (IndexOutOfBoundsException ioobe){

            input.nextLine();
            System.out.println("You have not entered a correct number. Taking you back to the main menu!");
            startMenu();
        }
    }

}
