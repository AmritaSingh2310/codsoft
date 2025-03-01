package codesoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
public NumberGuessingGame() {
}

public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
   Random random = new Random();
   int randomNumber = random.nextInt(100) + 1;
   int attempts = 0;

   boolean playAgain;
   do {
      System.out.println("Welcome to the Number Guessing Game!");
      System.out.println("================================================================================================================");
      System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

      while(true) {
         System.out.print("Please guess your number: ");
         int guess = scanner.nextInt();
         ++attempts;
         if (attempts > 10) {
            System.out.println("your chance limit is over. ");
            System.out.println("================================================================================================================");
            break;
         }

         if (guess < randomNumber) {
            System.out.println("Too low! Try again.");
         } else {
            if (guess <= randomNumber) {
               System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
               break;
            }

            System.out.println("Too high! Try again.");
         }
      }

      System.out.print("\nDo you want to play again? (yes/no): ");
      scanner.nextLine();
      String response = scanner.nextLine();
      playAgain = response.equalsIgnoreCase("yes");
   } while(playAgain);

   System.out.println("Thanks for playing! Goodbye.");
   scanner.close();
}
}
