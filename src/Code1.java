/**
 * Yicheng Jiang Coding Activity 1 - Making API Calls
 */

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class Code1 {
  //Create a static variable favour to store the favourite cities.
  public static ArrayList<String> favour = new ArrayList<String>();
  //Create the limits for update favourite cities.
  public static int LIMIT = 3;
  //Check if user want to end the code.
  public static boolean FLAG = true;
  //Track number of favourite cities.
  public static int num = 0;

  /**
   * Drive code with the user interface and interact with their favourite.
   *
   * @param args user inputs
   */
  public static void main(String[] args) {
    //welcoming and command help
    System.out.println("*************************************************************************");
    System.out.println("*                     Welcome the OpenWeather API                       *");
    System.out.println("*         Type 1 for checking the current weather of the city           *");
    System.out.println("*         Type 2 for adding cities to your favourite list               *");
    System.out.println("*         Type 3 for deleting cities from your favourite list           *");
    System.out.println("*         Type 4 for checking your favourite list                       *");
    System.out.println("*         Type 5 for close the program                                  *");
    System.out.println("*************************************************************************");
    //keep the interface running
    while (FLAG) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Please enter you command: ");
      String userInput = sc.next();

      //command loop
      switch (userInput) {
        case "1":
          System.out.println("Please type in the city name: ");
          String cityName = sc.next();
          check(cityName);
          break;

        case "2":
          System.out.println("Please remember the maximum number of cities you can add is 3.");
          System.out.println("Please how many cities you want to add this time: ");
          int length = sc.nextInt();
          while (length > LIMIT) {
            System.out.println("Please type in a number within limit: ");
            length = sc.nextInt();
          }
          // create an int array to save user input
          String[] input = new String[length];
          System.out.println("Please type in the cities your want to add: ");
          // loop over array to save user input
          System.out.println("Please enter the cities(type enter to separate): ");
          for (int i = 0; i < length; i++) {
            String cities = sc.next();
            // covert the string input to int
            input[i] = cities;
          }
          addCity(input);
          break;

        case "3":
          System.out.println("Please remember the maximum number of cities you can update is 3.");

          //delete the city
          System.out.println("Please how many cities you want to update this time: ");
          int length2 = sc.nextInt();
          while (length2 > LIMIT) {
            System.out.println("Please type in a number within limit: ");
            length = sc.nextInt();
          }
          // create an int array to save user input
          String[] input2 = new String[length2];
          System.out.println("Please type in the cities your want to delete: ");
          // loop over array to save user input
          System.out.println("Please enter the cities(type enter to separate): ");
          for (int i = 0; i < length2; i++) {
            String cities = sc.next();
            // covert the string input to int
            input2[i] = cities;
          }

          //add the city
          // create an int array to save user input
          String[] input3 = new String[length2];
          System.out.println("Please type in the cities your want to add: ");
          // loop over array to save user input
          System.out.println("Please enter the cities(type enter to separate): ");
          for (int i = 0; i < length2; i++) {
            String cities = sc.next();
            // covert the string input to int
            input3[i] = cities;
          }
          updateCity(input2, input3);
          break;

        case "4":
          listFavouriteCities();
          System.out.println();
          break;

        case "5":
          System.out.print("See you again!");
          FLAG = false;
          break;

        default:
          System.out.println("Please type in the right command.");
          continue;
      }
    }
  }

  /**
   * Check function to print the current weather details of the city.
   *
   * @param city the name of the city user want to check
   */
  public static void check(String city) {
    String LOCATION = city.toLowerCase();
    String API_KEY = "1661712e57e071ff5464c44baa52ab2c";
    String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION +
            "&appid=" + API_KEY;


  }

  /**
   * Adding the city to user's favourite list with limits of 3.
   *
   * @param cities the array of city names
   */
  public static void addCity(String[] cities) {
    for (int i = 0; i < cities.length; i++) {
      favour.add(num + i, cities[i]);
    }
    num += cities.length;
  }

  /**
   * Print the favourite city list.
   */
  public static void listFavouriteCities() {
    System.out.println("Your favourite cites are: ");
    System.out.print(favour);
  }


  /**
   * Deleting the city to user's favourite list with limits of 3.
   *
   * @param cities the array of city names
   */
  public static void updateCity(String[] deletes, String[] cities) {
    for (String delete : deletes) {
      int position = favour.indexOf(delete);
      if (position != -1) favour.remove(position);
    }
    num -= deletes.length;
    addCity(cities);
  }
}