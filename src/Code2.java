import java.util.Arrays;
import java.util.Scanner;

public class Code2 {
  public static void main(String[] args) {

    // taking String array input from user
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter length of String array");
    int length = sc.nextInt();

    // create a String array to save user input
    String[] input = new String[length];

    // loop over array to save user input
    System.out.println("Please enter array elements");
    for (int i = 0; i < length; i++) {
      String userInput = sc.next();
      input[i] = userInput;
    }

    // testing the taking correct
    //System.out.println("The String array input from user is : ");
    //System.out.println(Arrays.toString(input));

    sc.close();
  }

}