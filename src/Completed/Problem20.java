package Completed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem20 {
  private ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();

  public Problem20() {
    getData();
    System.out.println(longestRoute(0, 0));
  }

  private void getData() {
    Scanner in = null;
    try {
      in = new Scanner(new File("Problem20.txt"));
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      System.exit(1);
    }
    while (in.hasNextLine()) {
      ArrayList<Integer> temp = new ArrayList<Integer>();
      String[] numbers = in.nextLine().split(" ");
      for (int x = 0; x < numbers.length; x++)
        temp.add(new Integer(numbers[x]));
      tree.add(temp);
    }
  }

  private int longestRoute(int a, int b) {
    int length = tree.get(a).get(b).intValue();
    if (a != tree.size() - 1)
      return Math.max(longestRoute(a + 1, b), longestRoute(a + 1, b + 1))
          + length;
    else
      return length;
  }
}
