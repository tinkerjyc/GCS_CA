/**
 * Yicheng Jiang Coding Activity 2 - Pseudocode to code
 **/

import java.util.Arrays;
import java.util.Scanner;
public class Code2 {
  /**
   * Drive code with the user input int array interface.
   * @param args user inputs
   */
  public static void main(String[] args) {

    // taking String array input from user
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter length of int array");
    int length = sc.nextInt();

    // create an int array to save user input
    int[] input = new int[length];

    // loop over array to save user input
    System.out.println("Please enter array elements");
    for (int i = 0; i < length; i++) {
      String userInput = sc.next();
      // covert the string input to int
      input[i] = Integer.parseInt(userInput);
    }

    sc.close();

    int output = sortAndFindMedian(input);

    System.out.println("The median of the array input from user is : ");
    // System.out.println(Arrays.toString(input));
    System.out.println(output);

  }


  /**
   * Coding based on the pseudocode to find the median of a sorted array.
   * @param numbers an array of int
   * @return the median of the input array
   */
  public static int sortAndFindMedian(int[] numbers) {
    sort(numbers);
    int n = numbers.length;
    if (n % 2 == 0) {
      return (numbers[n / 2 - 1] + numbers[n / 2]) / 2;
    } else {
      return numbers[n / 2];
    }
  }

  /**
   * Merge sort
   * @param numbers an array of int
   */
  public static void sort(int[] numbers) {
    // i is sorting times
    for (int i = 0; i < numbers.length - 1; i++) {
      // number of sort comparisons
      for (int j = 0; j < numbers.length - 1; j++) {
        if (numbers[j] > numbers[j + 1]) {
          int tmp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = tmp;
        }
      }
    }
  }

}