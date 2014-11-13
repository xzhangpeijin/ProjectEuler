package completed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem22 {
  private String[] names;

  public Problem22() {
    getData();
    getTotal();
  }

  private void getData() {
    Scanner in = null;
    try {
      in = new Scanner(new File("Problem22.txt"));
    } catch (FileNotFoundException ex) {
      System.out.println("Better Frequency File Not Found");
      System.exit(1);
    }
    String temp = in.nextLine();
    names = temp.split(",");
    for (int x = 0; x < names.length; x++)
      names[x] = names[x].substring(1, names[x].length() - 1);
    Arrays.sort(names);
  }

  private void getTotal() {
    int total = 0;
    for (int x = 0; x < names.length; x++) {
      int value = 0;
      for (int y = 0; y < names[x].length(); y++) {
        value += names[x].charAt(y) - 64;
      }
      total += value * (x + 1);
    }
    System.out.println(total);
  }
}
