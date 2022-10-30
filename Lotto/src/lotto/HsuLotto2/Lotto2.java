/*
Caroline Hsu - 8/24/2021
The program is Lotto2, where users play a game to guess a number. The users
can input a number from 100-999 and the program generates 100 random numbers
between 100-999. If the number guessed is one of the 100 random numbers 
generated, the user wins. However, if the user does not guess one of those
numbers, the user loses. The user can decide to continue playing or not 
and if they decide to quit, the program will show the win and loss count.
Lotto has been upgraded to Lotto2. This program uses binary search and 
selection or bubble sort to be more efficient in the long run. 

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

  binary search method pre-conditions - 
    the incoming list must be in sorted order
  method of binary search receives the array list (sorted) and the target
  declare left and right values (according to list but left will always be 0
  because arrays start at 0 for counting) and right is 1 less than array length
  declare middle value
  while loop for if the left value is less than or equal to the right
    middle is equal to left + right / 2
    if statement for if the target equals the list at the middle value
      return true
    else if the target is less than the list at the middle value (looks left)
      move the right boundary to one less than middle
    else (looks right of the middle)
      move the left boundary to one plus the middle 
  return false
  binary search method post-conditions - 
    the return statement must be either true or false
    the number must either be found or not be found

  bubble sort method pre-conditions
    method gets passed correct int array list (correct data type too)
  method of bubble sort receives the array list (no target needed just sorting)
    declare done boolean as false to enter while loop
      while (done equals false)
        set done to true for when you start the for loop
        for loop to (declare "king" at array list; king must be 1 less than 
                     length of list; k++)
          if statement for if the king at random value of array is greater than
          the one next to it
            swap the values of array list with the king and the king+1 value
            set done to false to continue loop
  bubble sort method post-conditions
    method does not need to return anything to main method but they will be 
    sorted from least to greatest

  selection sort method pre-conditions
    method gets passed the correct int array list (correct data type too)
  method of selection sort receives the array list (no target just sorting)
  declare the int best for marker
  for loop for when the "king" is 0; k is less than list length - 1 (must 
  less because of queen moving; k++)
    initialize best at king position
    for loop for starting queen position at 1 more than king; less than array
    length; queen++)
      if statement for if the list at value queen is less than the value
      at the best (queen searches for better value)
        set the best to q position
    swap the list, king, and best values
  selectionSort method gets passed the correct int array list
    method does not need to return anything to main method but they will be 
    sorted from least to greatest

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

public class Lotto2
{

  public static void main(String[] args)
  {
    // declare scanner for input
    Scanner input = new Scanner(System.in);
    // declare lower and upper bounds for random no. generator
    final int LOWER_BOUND = 100;
    final int UPPER_BOUND = 999;
    // list length of 100 (array size)
    final int LIST_LENGTH = 100;
    // counts losses and wins for the user
    int winCount = 0;
    int lossCount = 0;
    // user number input
    int userNumber;
    // declares char for answer if the user wants to continue
    char answer;
    // declare boolean for receiving the binary search method
    boolean response;
    // declare array for storing the random numbers (size 100)
    int randomNumber[] = new int[100];

    // do while loop for if the user wants to repeat 
    do
    {
      // for loop to randomize the number array all the way from 0-99 (100 #'s)
      for (int i = 0; i < LIST_LENGTH; i++)
      {
        // random number generator copied and pasted 
        randomNumber[i] = LOWER_BOUND + (int) (Math.random()
            * (UPPER_BOUND - LOWER_BOUND + 1));
      }
      // two different sorting methods takes the array and sorts
      bubbleSort(randomNumber);
      // selectionSort(randomNumber);

      // ask the user to guess a number between 100 and 999 and takes the 
      // input 
      System.out.println("Guess a number between 100 and 999. You will win if "
          + "you choose 1 of the 100 numbers generated between the bounds.\n"
          + "Choose a whole number: ");
      userNumber = input.nextInt();
      // puts the response through the binary search (takes array and number)
      response = binarySearch(randomNumber, userNumber);
      /*
      sends the random number array and user input to linear search method
      response is a boolean of true or false
      response = linearSearch(randomNumber, userNumber);
       */

      // if boolean response is true from method you win and winCount goes up
      if (response == true)
      {
        System.out.println("You won!");
        winCount++;
      }
      // else if for if the boolean response is false from method you lose
      // and the lose count goes up
      else if (response == false)
      {
        System.out.println("You did not win.");
        lossCount++;
      }

      input.nextLine(); // dummy next line
      // ask the user if they would like to continue playing
      System.out.println("Would you like to continue playing? If yes, reply"
          + " with y or Y to continue: ");
      answer = input.nextLine().charAt(0); // get user response as char
    } while ((answer == 'y') || (answer == 'Y'));
    /* repeat the loop if answer is yes */

    /* if the answer is no, the do while loop will stop and the results will
    appear (number of wins with the win count and number of losses with the
    loss count) */
    System.out.println("Thank you for playing! Your results are here:\n"
        + "Number of Wins: " + winCount + "\n"
        + "Number of Losses: " + lossCount);
  }

  // binary search program efficient search (divide and conquer) recieves
  // number array and number input
  public static boolean binarySearch(int[] randomNumberArray, int numberInput)
  {
    // declare boundaries
    int left = 0;
    int right = randomNumberArray.length - 1;
    int middle;

    // while the left boundary is less than or equal to right
    while (left <= right)
    {
      // middle value between left and right
      middle = (left + right) / 2;
      // if the number input matches the number array at the middle value
      if (numberInput == randomNumberArray[middle])
      {
        // return true if number is found
        return true;
      }
      // else if statement for if the number input is less than the array at 
      // the middle value
      else if (numberInput < randomNumberArray[middle])
      {
        // move the right boundary
        right = middle - 1;
      }
      // else statement for if the other if and else if statement don't fit
      else
      {
        // move the left boundary
        left = middle + 1;
      }
    }
    // return false if number not found
    return false;
  }

  // bubble sort with booleans
  public static void bubbleSort(int[] randomNumberArray)
  {
    // set default to false
    boolean done = false;

    // while loop for if the boolean is false
    while (done == false)
    {
      // automatically set it to true
      done = true;
      // for loop for king at 0 and must be one less than the length of array
      for (int k = 0; k < randomNumberArray.length - 1; k++)
      {
        // if statement for if the array at value king is greater than the
        // value at king + 1 (next value in list)
        if (randomNumberArray[k] > randomNumberArray[k + 1])
        {
          // swap the neighboring numbers
          swap(randomNumberArray, k, k + 1);
          // and set done to false so it can loop again
          done = false;
        }
      }
    }
  }

  // selection sort picks best value for unsorted elements of the array (0-end)
  public static void selectionSort(int[] randomNumberArray)
  {
    // declare best for marker
    // best is smallest number
    int best;
    // for loop for when the k(ing) is at position 0 and is 1 less than the 
    // array length
    for (int k = 0; k < randomNumberArray.length - 1; k++)
    {
      // set best = king
      best = k;
      // for loop for queen, queen starts at one more than king 
      for (int q = k + 1; q < randomNumberArray.length; q++)
      {
        // if statement for if the array at q is less than the array at best
        if (randomNumberArray[q] < randomNumberArray[best])
        {
          // set values
          best = q;
        }
      }
      // swap the values
      swap(randomNumberArray, k, best);
    }
  }

  // swap method to switch
  public static void swap(int[] randomNumberArray, int i, int j)
  {
    // declare temp for placeholder
    int temp; 
    // set array at i equal to temp
    temp = randomNumberArray[i];
    // make array at j = array at i
    randomNumberArray[i] = randomNumberArray[j];
    // make temp value the array value at j
    randomNumberArray[j] = temp;
  }

  /* linear search method receives the random number array (generated by
  program in main method) and receives the user input (number guessed)
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
   */
}
