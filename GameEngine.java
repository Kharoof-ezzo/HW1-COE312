package SoftwareEngineering.HW1;

import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {


        //Introducing the player to the game
        System.out.println("\"Messrs Moony, Wormtail, Padfoot and Prongs Purveyors of Aids " +
                "\nto magical Mischief-Makers are proud to present THE MARAUDER'S MAP\"" +
                "\n\nSay the magic phrase to reveal the map.");

        Scanner obj = new Scanner(System.in);

        // a loop until the player enters the correct choice
        while (!obj.nextLine().equals("I solemnly swear that I am up for no good")) {
            System.out.println("Those are not the correct words try again: ");
        }
        //Offering the player places and halls to go to
        System.out.println("Welcome to the Entrance of the school of wizards Hogwarts! ." +
                "\n\nYou are now at the doors of Hogwarts. The door on the north leads to \n" +
                "the dining hall, the door to the east leads to the Potions classroom, and\n" +
                "the door to the west leads to the Library.\n");

        boolean validchoice = false; // a flag or boolean to check the validity of the options
        String exit = "mischief managed"; // Exit phrase
        // a loop until the player enters the correct choice
        System.out.println("So were you want to go: ");
        String c = obj.nextLine();
        int score = 0;
        while (!validchoice) {
            if (c.contains("Dining") || c.contains("dining") || c.contains("north") || c.contains("North")) {
                DiningHall diningHall = new DiningHall();
                validchoice = true;
                score = diningHall.score;
            } else if (c.contains("Library") || c.contains("library") || c.contains("west") || c.contains("West")) {
                Library library = new Library();
                validchoice = true;
                score = library.score;
            } else if (c.contains("Potions") || c.contains("potions") || c.contains("east") || c.contains("East")) {
                PotionsClassroom potionsclassroom = new PotionsClassroom();
                validchoice = true;
                score = potionsclassroom.score;
            } else if (c.equals(exit)) {
                validchoice = true;
            } else {
                System.out.println("Invalid option please try again:");
                System.out.println();
                System.out.println("So were you want to go: ");
                c = obj.nextLine();
            }
        }

        System.out.println("Your score is: " + score);
        System.out.println("Goodbye, I hope you had fun :)");
    }
}
