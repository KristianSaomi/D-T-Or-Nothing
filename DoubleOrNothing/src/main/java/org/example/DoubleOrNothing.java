package org.example;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothing {
    private static int startPoints = 10;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private int current = startPoints;
    private boolean isStillPlaying = true;
    private boolean restartNow = false;

    public void playGame() {
        printWelcome();
        askUserToContinue();

        while (this.isStillPlaying) {
            printTryToDouble();

            if(shouldDouble()) {
                doubleCurrent();
                printCongrats();
                askUserToContinue();
            } else {
                printLost();
                restartAfterLost();
                return;
            }
        }

    }



    private void printWelcome() {
        System.out.println("Let´s play Double or nothing. " +
                "We´ll start you off with " + startPoints + " points\n");
    }
    private void printTryToDouble() {
        System.out.println("Let´s try to double it!");
    }
    private void printCongrats() {
        System.out.println("Congrats! You now have " +
                this.current + " points \n");
    }
    private void printLost() {
        System.out.println("Uh oh. You´ve lost. " +
                "No points for you");
    }
    private void printWalkawayMessage() {
        System.out.println("Congrats! " );
    }
    private boolean shouldDouble() {
        return this.random.nextInt(2) == 0;
    }
    private void doubleCurrent() {
        this.current = this.current * 2;
    }
    protected void askUserToContinue() {
        System.out.println("Would you like to continue? " +
                "and try to double your winnings?");
                this.isStillPlaying = this.scanner.nextLine().equalsIgnoreCase("YES");
    }

    protected void restartAfterLost() {
        System.out.println("Would you like to restart? "
        + "Type yes to restart");
         var answer = this.scanner.nextLine().equalsIgnoreCase("YES");
        if(answer == true) {
            playGame();
        } else {
            System.out.println("Thanks for playing");
        }
    }
}
