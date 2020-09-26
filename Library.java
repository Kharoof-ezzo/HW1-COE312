package SoftwareEngineering.HW1;

import java.util.Scanner;

public class Library extends Hogwards implements Interactions {
    static int count = 0;

    Library() {
        this.countclass++;
        System.out.println("Your current score is: " + this.score);
        System.out.println("Welcome to the Library take a book to read.");
        String exit = "mischief managed"; // Exit phrase
        boolean validchoice = false;
        Scanner obj = new Scanner(System.in);
        // a loop until the player enters the correct choice
        this.c = obj.nextLine();
        while ((!validchoice) || (!this.c.equals(exit))) {
            if ((this.c.contains("Talk") || this.c.contains("talk")) && (this.c.contains("Hermione") || this.c.contains("hermione"))) {
                validchoice = true;
                talk();
            } else if ((this.c.contains("Talk") || this.c.contains("talk")) && !(this.c.contains("Hermione") || this.c.contains("hermione"))) {
                System.out.println("The character is not available to speak to at the Library." +
                        "\nTry again: ");
            } else if ((this.c.contains("Use") || this.c.contains("use")) && (this.c.contains("Quill") || this.c.contains("quill"))) {
                validchoice = true;
                use2();
            } else if ((this.c.contains("Read") || this.c.contains("read")) && (this.c.contains("Book") || this.c.contains("book"))) {
                validchoice = true;
                use1();
            } else if ((this.c.contains("Use") || this.c.contains("use")) && !(this.c.contains("Quill") || this.c.contains("quill"))) {
                System.out.println("The object is not available to use at the Library." +
                        "\nTry again: ");
            } else if ((this.c.contains("Read") || this.c.contains("read")) && !(this.c.contains("Book") || this.c.contains("book"))) {
                System.out.println("The object is not available to read at the Library." +
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
        System.out.println("Since the academic year starts, students spend a lot of their time in the school library.\n" +
                "Amongst those students Hermione is helping new students with their subjects. " +
                "\nIn the library, there are many books the more you read the more points you get.");
    }

    @Override
    void next() {
        System.out.println("Were to next (Dining hall north or Potions Classroom east): ");

        Scanner obj = new Scanner(System.in);

        boolean validchoice = false;

        while (!validchoice) {
            String c = obj.nextLine();
            if (c.contains("Dining") || c.contains("dining") || c.contains("north") || c.contains("North")) {
                validchoice = true;
                DiningHall library = new DiningHall();
            } else if (c.contains("Potions") || c.contains("potions") || c.contains("east") || c.contains("East")) {
                validchoice = true;
                PotionsClassroom potionsclassroom = new PotionsClassroom();
            } else {

                System.out.println("Invalid option please try again:");

            }
        }
    }


    @Override
    public void talk() {

        System.out.println("\"Books! And cleverness! There are more important things! — Friendship! And Bravery!\" -Hermione Granger");

    }

    @Override
    public void use1() {
        if (count <= 3) {
            int x = ((int) (Math.random() * 8)) + 1;
            switch (x) {
                case 1:
                    System.out.println("You have gained 10 points for reading the book about \"Avada Kedavra\" spell");
                    score += 10;
                    count++;
                    break;

                case 2:
                    System.out.println("You have gained 20 points for reading the book about \"Accio\" spell");
                    score += 20;
                    count++;
                    break;

                case 3:
                    System.out.println("You have gained 30 points for reading the book about \"Expecto Patronum\" spell");
                    score += 30;
                    count++;
                    break;

                case 4:
                    System.out.println("You have gained 40 points for reading the book about \"Expelliarmus\" spell");
                    score += 40;
                    count++;
                    break;

                case 5:
                    System.out.println("You have gained 50 points for reading the book about \"Wingardium Leviosa\" spell");
                    score += 50;
                    count++;
                    break;

                case 6:
                    System.out.println("You have gained 60 points for reading the book about \"Lumos\" spell");
                    score += 60;
                    count++;
                    break;
                case 7:
                    System.out.println("You have gained 70 points for reading the book about \"Alohomora\" spell");
                    score += 70;
                    count++;
                    break;
                case 8:
                    System.out.println("You have gained 80 points for reading the book about \"Sectumsempra\" spell");
                    score += 80;
                    count++;
                    break;

            }
        } else {
            System.out.println("Good job You have read 4 books, take some rest.");
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
        }
    }

    @Override
    public void use2() {

        System.out.println("A note has been written.");

    }
}
