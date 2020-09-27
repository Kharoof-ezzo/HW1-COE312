package SoftwareEngineering.HW1;

import java.util.Scanner;

public class DiningHall extends Hogwards implements Interactions {
    String hat;

    static int count = 0;

    DiningHall() {
        this.countclass++;
        System.out.println("Your current score is: " + this.score);
        System.out.println("Welcome to the Dinning Hall take your seat.");
        String exit = "mischief managed"; // Exit phrase
        boolean validchoice = false;
        Scanner obj = new Scanner(System.in);
        // a loop until the player enters the correct choice
        this.c = obj.nextLine();
        while ((!validchoice) || (!this.c.equals(exit))) {
            if ((this.c.contains("Talk") || this.c.contains("talk")) && (this.c.contains("Dumbledore") || this.c.contains("dumbledore"))) {
                validchoice = true;
                talk();
            } else if ((this.c.contains("Talk") || this.c.contains("talk")) && !(this.c.contains("Dumbledore") || this.c.contains("dumbledore"))) {
                System.out.println("The character is not available to speak to at the dining hall." +
                        "\nTry again: ");
            } else if ((this.c.contains("Use") || this.c.contains("use")) && (this.c.contains("Hat") || this.c.contains("hat"))) {
                validchoice = true;
                use1();
            } else if ((this.c.contains("Use") || this.c.contains("use")) && !(this.c.contains("Hat") || this.c.contains("hat"))) {
                System.out.println("The object is not available to use to at the dining hall." +
                        "\nTry again: ");
            } else if ((this.c.contains("Eat") || this.c.contains("eat")) && (this.c.contains("Food") || this.c.contains("food"))) {
                validchoice = true;
                use2();
            } else if ((this.c.contains("Eat") || this.c.contains("eat")) && !(this.c.contains("Food") || this.c.contains("food"))) {
                System.out.println("The object is not available to eat to at the dining hall." +
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
        System.out.println("The Dining Hall is the biggest open area inside Hogwarts. In the dining hall,\n" +
                "Professor Dumbledore is welcoming new students, and sorting them into one of the houses\n" +
                "(Gryffindor, Hufflepuff, Ravenclaw and Slytherin). \n" +
                "Talk to professor Dumbledore to get more points.");
    }

    @Override
    void next() {
        System.out.println("Were to next (Library west or Potions Classroom east): ");

        Scanner obj = new Scanner(System.in);

        boolean validchoice = false;

        while (!validchoice) {
            String c = obj.nextLine();
            if (c.contains("Library") || c.contains("library") || c.contains("west") || c.contains("West")) {
                validchoice = true;
                Library library = new Library();
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
        if (this.hat != null) {
            System.out.println("\"Congratulations for joining the " + hat + " house.\" -Albus Dumbledore");
        } else {
            System.out.println("\"Welcome to the dining hall! Interact with the sorting hat to be sorted\n" +
                    "into a house, then enjoy the food served in the hall.\"");
        }
        score += 40;
    }

    @Override
    public void use1() {
        if (hat == null) {
            int x = ((int) (Math.random() * 4)) + 1;
            switch (x) {
                case 1:
                    hat = "Gryffindor";
                    System.out.println(hat + "!");
                    System.out.println("You have gained 80 points for joining Gryffindor!!");
                    score += 80;
                    break;

                case 2:
                    hat = "Hufflepuff";
                    System.out.println(hat + "!");
                    System.out.println("You have gained 60 points for joining Hufflepuff!!");
                    score += 60;
                    break;

                case 3:
                    hat = "Ravenclaw";
                    System.out.println(hat + "!");
                    System.out.println("You have gained 70 points for joining Ravenclaw!!");
                    score += 70;
                    break;

                case 4:
                    hat = "Slytherin";
                    System.out.println(hat + "!");
                    System.out.println("You have gained 60 points for joining Slytherin!!");
                    score += 60;
                    break;

            }
        } else
            System.out.println("You are already in the " + hat + " house you cannot switch your house" +
                    "\ntry eating the delicious food on the dining table.");
    }

    @Override
    public void use2() {
        if (count == 3) {
            System.out.println("You will become fat if you ate too much.");
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
            count += 1;
            System.out.println("Humm....Humm...Delicious!!!!!!");
            System.out.println("You have gained 50 more points for eating Hogwards delicious food.");
            score += 50;
        }
    }
}
