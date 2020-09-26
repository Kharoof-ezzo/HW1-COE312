package SoftwareEngineering.HW1;

import java.util.Scanner;

public class PotionsClassroom extends Hogwards implements Interactions {

    static int x = 0;
    static int count = 0;

    PotionsClassroom() {
        this.countclass++;
        System.out.println("Your current score is: " + this.score);
        System.out.println("Welcome to the Potions Classroom where you can make magical potions.");
        String exit = "mischief managed"; // Exit phrase
        boolean validchoice = false;
        Scanner obj = new Scanner(System.in);
        // a loop until the player enters the correct choice
        this.c = obj.nextLine();
        while ((!validchoice) || (!this.c.equals(exit))) {
            if ((this.c.contains("Talk") || this.c.contains("talk")) && (this.c.contains("Snape") || this.c.contains("snape"))) {
                validchoice = true;
                talk();
            } else if ((this.c.contains("Talk") || this.c.contains("talk")) && !(this.c.contains("Snape") || this.c.contains("snape"))) {
                validchoice = true;
                System.out.println("The character is not available to speak to at the Potions classroom." +
                        "\nTry again: ");
            } else if ((this.c.contains("Use") || this.c.contains("use")) && (this.c.contains("Cauldron") || this.c.contains("cauldron"))) {
                validchoice = true;
                use1();
            } else if ((this.c.contains("Drink") || this.c.contains("drink")) && (this.c.contains("Potion") || this.c.contains("potion"))) {
                validchoice = true;
                use2();
            } else if ((this.c.contains("Use") || this.c.contains("use")) && !(this.c.contains("Cauldron") || this.c.contains("cauldron"))) {
                System.out.println("The object is not available to use at the Potions Classroom." +
                        "\nTry again: ");
            } else if ((this.c.contains("Drink") || this.c.contains("drink")) && !(this.c.contains("Potion") || this.c.contains("Potion"))) {
                System.out.println("The object is not available to drink at the Potions Classroom." +
                        "\nTry again: ");
            } else if (this.c.contains("Look") || this.c.contains("look")) {
                look();
                validchoice = true;
            } else {
                System.out.println("Invalid option please try again:");
            }
            this.c = obj.nextLine();
        }
    }

    @Override
    public void look() {
        System.out.println("Potions is one of the core subjects that first year students are required to\n" +
                "study. In the potions class there is Professor Snape who teaches the subject. The Potions Classroom\n" +
                "is full of equipments like the cauldron, and materials that you can use the better the affect your potion has\n" +
                "on you the higher your score.");
    }

    @Override
    void next() {
        System.out.println("Were to next (Library west or Dining hall north): ");

        Scanner obj = new Scanner(System.in);

        boolean validchoice = false;

        while (!validchoice) {
            String c = obj.nextLine();
            if (c.contains("Dining") || c.contains("dining") || c.contains("North") || c.contains("north")) {
                validchoice = true;
                DiningHall diningHall = new DiningHall();
            } else if (c.contains("Library") || c.contains("library") || c.contains("west") || c.contains("West")) {
                validchoice = true;
                Library library = new Library();

            } else {

                System.out.println("Invalid option please try again:");

            }
        }
    }

    @Override
    public void talk() {
        System.out.println("\"I can teach you how to bottle fame, brew glory, even stopper death — if you \n" +
                "are not as big a bunch of dunderheads as I usually have to teach.\" -Professor Snape");
    }

    @Override
    public void use1() {
        System.out.println("The cauldron is preparing the potion now.....");
        x = ((int) (Math.random() * 5)) + 1;
        switch (x) {
            case 1:
                System.out.println("You have gained 10 points for making the \"Amortentia\" potion (Love potion)");
                score += 10;
                break;

            case 2:
                System.out.println("You have gained 20 points for making the \"Confusing Concoction\" potion (Confusion potion)");
                score += 20;
                break;

            case 3:
                System.out.println("You have gained 30 points for making the \"Draught of Peace\" potion (Comfort potion)");
                score += 30;
                break;

            case 4:
                System.out.println("You have gained 40 points for making the \"Draught of Living Death\" potion (Sleep potion)");
                score += 40;
                break;

            case 5:
                System.out.println("You have gained 50 points for reading the book about \"Polyjuice Potiona\" potion (Disguise potion)");
                score += 50;
                break;

        }
    }

    @Override
    public void use2() {
        if (count >= 3) {
            System.out.println("You have drank too many potions, you are not allowed to drink more");
            System.out.println();
            Scanner obj = new Scanner(System.in);
            boolean validchoice = false;
            while (!validchoice) {
                System.out.println("Do you want to go to another room? ");
                this.c = obj.nextLine();
                if (this.c.contains("yes") || this.c.contains("Yes")) {
                    validchoice = true;
                    next();
                } else if (this.c.contains("no") || this.c.contains("No")) {
                    if (this.countclass >= 3)
                        System.out.println("Repeat the magic word three times to exit the map.");
                    else if (this.countclass == 2)
                        System.out.println("Repeat the magic word two times to exit the map.");
                    else if (this.countclass == 1)
                        System.out.println("Repeat the magic word once to exit the map.");
                    validchoice = true;
                } else {
                    System.out.println("Invalid command option please try again");
                    System.out.println();
                }
            }

        } else {
            switch (x) {
                case 0:
                    System.out.println("You did not prepare a potion to drink");
                    break;
                case 1:
                    System.out.println("Wow the potion Made you fall in love");
                    count++;
                    break;

                case 2:
                    System.out.println("Wow the potion Made you doubt in reality");
                    count++;
                    break;

                case 3:
                    System.out.println("Wow the potion Made you more comfortable");
                    count++;
                    break;

                case 4:
                    System.out.println("Wow the potion Made you sleep for 24 hours!!");
                    count++;
                    break;

                case 5:
                    System.out.println("Wow the potion Made you disguise as Harry Potter");
                    count++;
                    break;

            }
        }
    }
}
