/*
Caroline Hsu - 8/16/2021
The program is Lotto, where users play a game to guess a number. The users
can input a number from 100-999 and the program generates 100 random numbers
between 100-999. If the number guessed is one of the 100 random numbers 
generated, the user wins. However, if the user does not guess one of those
numbers, the user loses. The user can decide to continue playing or not 
and if they decide to quit, the program will show the win and loss count.

  linear search method pre-conditions - 
    the random number generator must pass all the numbers to the method
    the user input must be a number passed from main method
  linear search method receives the randomNo array and userNo and returns 
  boolean
  declare list length of 100
  declare boolean 
    loop based search uses array and looks at first and continues until the 
    target is found or until the end of the array is reached
  start a for loop with counter
    if statement for if the counter equals the userNo
      boolean is true
    else statement 
      boolean is false
  return the boolean to main method
  linear search method post-conditions
    the return statement must be either true or false
    the number must either be found or not be found

  main method preconditions - 
    the user must enter a whole number 
    the user must enter a char y or Y if they would like to play again
    the program must be passing the correct data types (int to int, int[] to
    int[]), and the variables must be declared correctly
  declare variables - upper and lower bounds, array of 100, number input,
  length of array, win and loss count, boolean for response from linear 
  search method, and scanner

  do while loop for when the users want to repeat the game
    generate random numbers between 100-999 and store them in the randomNo array
          with method given 
    println asks user to guess a number between 100-999
    user inputs the number and stores it
    sends the inputted number and array to the linear search method
    linear search method returns a boolean
    if statement for if the boolean is true
      you won println comes and win count goes up
    else if statement for if the boolean is false
      you lost println comes and loss count goes up
  ask the user if they would like to play again
  use y or Y to continue the game; if they enter another char, the loop exits
  print the results of win and loss count
  main method post-conditions - 
    the win count must be correct
    the loss count must be correct
 */

package lotto;

// import scanner from API
import java.util.Scanner;

public class Lotto
{

  public static void main(String[] args)
  {
    // declare scanner for input
    Scanner input = new Scanner(System.in);
    // declare lower and upper bounds for random no. generator
    int lowerBound = 100;
    int upperBound = 999;
    // list length of 100 (array size)
    int listLength = 100;
    // counts losses and wins for the user
    int winCount = 0;
    int lossCount = 0;
    // user number input
    int userNumber;
    // declares char for answer if the user wants to continue
    char answer;
    // declare boolean for receiving the linear search method
    boolean response = false;
    // declare array for storing the random numbers (size 100)
    int randomNumber[] = new int[100];

    // do while loop for if the user wants to repeat 
    do
    {
      // for loop to randomize the number array all the way from 0-99 (100 #'s)
      for (int i = 0; i < listLength; i++)
      {
        // random number generator copied and pasted 
        randomNumber[i] = lowerBound + (int) (Math.random()
            * (upperBound - lowerBound + 1));
      }
      // ask the user to guess a number between 100 and 999 and takes the 
      // input 
      System.out.println("Guess a number between 100 and 999. You will win if "
          + "you choose 1 of the 100 numbers generated between the bounds.\n"
          + "Choose a whole number: ");
      userNumber = input.nextInt();
      
      // sends the random number array and user input to linear search method
      // response is a boolean of true or false
      response = linearSearch(randomNumber, userNumber);
      
      // if boolean response is true from method you win and winCount goes up
      if (response == true)
      {
        System.out.println("You won!");
        winCount++;
      }
      // else if for if the boolean response is false from method you lose
      // and the lose count goes up
      else if(response == false)
      {
        System.out.println("You did not win.");
        lossCount++;
      }
      
      input.nextLine(); // dummy next line
      // ask the user if they would like to continue playing
      System.out.println("Would you like to continue playing? If yes, reply"
          + " with y or Y to continue: ");
      answer = input.nextLine().charAt(0); // get user response as char
    } while ((answer == 'y') || (answer == 'Y')); /* repeat the loop if answer 
    is yes */
    
    /* if the answer is no, the do while loop will stop and the results will
    appear (number of wins with the win count and number of losses with the
    loss count) */
    System.out.println("Thank you for playing! Your results are here:\n"
        + "Number of Wins: " + winCount + "\n"
        + "Number of Losses: " + lossCount);

  }
  
  /* linear search method receives the random number array (generated by
  program in main method) and receives the user input (number guessed)*/
  public static boolean linearSearch(int[] randomNumberArray, int numberInput)
  {
    // declare list length of 100 (size of random number array)
    // and declare boolean for true or false return to main method
    int listLength = 100;
    boolean returnValue = true;
    
    // for loop with counter at 0, counter is less than the list length of 100,
    // adds one to counter
    for(int i = 0; i < listLength; i++)
    {
      // if statement for if the user no. input is equal to the random number 
      // array at counter 
      if (numberInput == randomNumberArray[i])
      {
        // set boolean as true
        returnValue = true;
      }
      // else statement for if the user no. input is not equal
      else
      {
        // set boolean as false
        returnValue = false;
      }
    }
    // return the boolean returnValue with the set true or false
    return returnValue;
  }

}
