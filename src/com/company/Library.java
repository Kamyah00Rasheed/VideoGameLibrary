package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Library {

    private Scanner input = new Scanner (System.in);
    private List<Game> gamesLibrary = new ArrayList<Game>();
    private List<Game> checkedOutGames = new ArrayList<Game>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    private Menu menu;


    public Library(Menu menu) {
        this.menu = menu;
    }

    public void removeGame(int index){
        if (gamesLibrary.isEmpty()){
            System.out.println("There are no games in your library, add a game to be able to remove.");
        } else {
        gamesLibrary.remove(index);
        System.out.println("This game has been removed fro your library."); }

        menu.startMenu();
    }

    public void addGame(){
        System.out.println("What is the title of your game?");
        String title = input.nextLine();
        System.out.println("What type of game is this?");
        String type = input.nextLine();
        System.out.println("What is the game's ID Number?");
        int idNumber = input.nextInt();
        input.nextLine();
        Game game = new Game(title, type, idNumber);
        gamesLibrary.add(game);
        System.out.println("You have added " +game.getTitle() + " to your library, this game can now be checked out. \n");
        menu.startMenu();
    }

    public void listGamesInLibrary(String location) {
        if (gamesLibrary.isEmpty()){
            System.out.println("There are no games in your library.");
        } else {

            int index = 1;
            for (Game inLibrary : gamesLibrary) {

                System.out.println(index++ + ": " + inLibrary.getTitle());
            }
        }
        if (location.equals("inLibrary")) {
            menu.startMenu();
        }


    }
    public void checkOutGame(int index){

        if(gamesLibrary.isEmpty()){
            System.out.println("There are no games in your library, add some games to be able to check out.");
        } else {
            Game game = gamesLibrary.get(index);

            //Create an instance of the calendar object
            Calendar calendar = Calendar.getInstance();
            //Ad 7 dayd to the current date
            String dueDate = dateFormat.format(calendar.getTime());
            //Uses the line above to set a due date in the future
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            //Tell user what their due date is
            System.out.println(game.getTitle() + " is due on " + dueDate);
            //set dueDate for this game
            game.setDueDate(dueDate);
            //Add game to checked out list
            checkedOutGames.add(game);
            //Remove game from Library
            gamesLibrary.remove(game);
        }
        menu.startMenu();
    }
    public void checkInGame (int index) {

        Game game = checkedOutGames.get(index);
        gamesLibrary.add(game);

        try {
            Calendar calendar = Calendar.getInstance();
            if (dateFormat.parse(dateFormat.format(calendar.getTime())).before(dateFormat.parse(game.getDueDate()))) {
                System.out.println("Thanks for turning your game in on time!");
            } else {
                System.out.println("Shame on you! You were late turning in a game! :(");
            }
        } catch(ParseException pe){
            //we will leave this empty since we don'1t really need to do anything if we catch this exception
        }
        checkedOutGames.remove(game);
        menu.startMenu();
        //get game using index from checked out games

    }

    public void listCheckedOut(String location){

        if (checkedOutGames.isEmpty()){
            System.out.println("There are no games currently checked out.");
            menu.startMenu();
        } else {
            int index = 0;
            for (Game game: checkedOutGames){
                System.out.println(++index + ": " +game.getTitle());
            }
        }
        if (location.equals("viewCheckedOut")){
            menu.startMenu();
        }
    }
}
