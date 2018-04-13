package UtilArrayFunctions;

/**
 * @author Neelesh Rambally
 * @date 12/04/2018
 *
 * The below code could have also been accomplished by NOT using built in java functions , however I
 * have chose to use the built in functions to accomplish the required functions which I feel is
 * more efficient and less time consuming.
 *
 * To Sort the arrays I've used the built in Collections.sort() method With Java 8 this is
 * implemented via "TimSort" which is a hybrid of MegaSort and InsertionSort for objects and
 * QuickSort for primitive elements.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {

  //Find all the numbers when user provides input
  public static ArrayList<String> formatInput(String input) {
    input = input.replaceAll("[^-?0-9]+", " ");
    input = input.replaceAll("\\|", "");
    ArrayList<String> arr = new ArrayList<String>(Arrays.asList(input.trim().split(" ")));
    return arr;
  }

  //Sorts the array ignoring pipe characters
  public static ArrayList<Integer> simpleSort(ArrayList<String> arr) {
    ArrayList<Integer> listInt = new ArrayList<Integer>();
    for (String i : arr) {
      try {
        listInt.add(Integer.parseInt(i));
      } catch (NumberFormatException a) {
        System.out.println(a);
      }
    }
    Collections.sort(listInt);
    return listInt;
  }

  //Find Frequency of each number in array
  public static Map<String, Long> getFrequencies(ArrayList<String> arr) {
    Map<String, Long> counts = arr.stream()
        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    return counts;
    /*
     * This works as follows:
     * -Get the first element of the ARRAY
     * -Add it to a MAP as a KEY
     * -Use the KEY to search the ARRAY and find all occurrences of the key
     * -Repeat for each element
     * Since its a map , it wont have duplicate keys
     * */
  }

  //Sort each row of a 2D array , displaying each row
  public static void sortComplex(String list) {
    ArrayList<ArrayList> twoDList = new ArrayList<ArrayList>();
    if (list.contains("|")) {
      String[] rows = list.split("\\|");
      for (String i : rows) {
        twoDList.add(simpleSort(new ArrayList<String>(Arrays.asList(i.trim().split("\\s+")))));
      }
      for (ArrayList j : twoDList) {
        System.out.println(j);
      }
    } else {
      System.out.println(formatInput(list));
    }
  }

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    String numeric = new String();
    Scanner kb = new Scanner(System.in);

    System.out.println("Please enter some numeric values | to show array \n ");
    numeric = kb.nextLine();

    list = formatInput(numeric);
    System.out.println("Output 1: " + simpleSort(list));
    System.out.println("Below Output in format Element = Number Of Occurences ");
    System.out.println("Output 2: " + getFrequencies(list));
    System.out.println("Output 3:" + simpleSort(list));
    System.out.println("Output 4:");sortComplex(numeric);
  }
}