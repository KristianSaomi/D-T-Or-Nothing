package org.example;

import java.util.Random;
import java.util.Scanner;

public class TrippleOrNothing {
    private int startingPoints = 10;
    private boolean isStillPlaying = true;
    private int currentPoints = startingPoints;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        printIntroduction();
        askUserToContinue();

        while(this.isStillPlaying) {
            printTryToTripple();

            if (shouldTripple()) {
                tripleCurrent();
                congrats();
                askUserToContinue();
            } else {
                printLost();
                break;
            }
        }
    }

    private void printLost() {
        System.out.println("Damn, you lost " +
                "You lost with " + this.currentPoints);
    }

    private void congrats() {
        System.out.println("Congrats! " + "You now have "
        + this.currentPoints + " points!");
    }

    private void tripleCurrent() {
        this.currentPoints = this.currentPoints * 2;
    }

    private boolean shouldTripple() {
        return this.random.nextInt(2) == 0;
    }

    private void printTryToTripple() {
        System.out.println("Lets try to tripple!");
    }

    private void askUserToContinue() {
        System.out.println("Would you like to try tripple your bet?");
        this.isStillPlaying = scanner.nextLine().equalsIgnoreCase("YES");
        if(this.isStillPlaying == false) {
            System.out.println("Fine then, you ended with " + this.currentPoints);
        }
    }

    private void printIntroduction() {
        System.out.println("Lets play Tripple or Nothing!"
        + "you will start of with: " + startingPoints);
    }
}


