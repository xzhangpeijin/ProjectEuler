package Completed;

import java.util.ArrayList;

public class Problem40 {
  public Problem40() {
    boolean done = false;
    int num = 1;
    int length = 0;
    ArrayList<Integer> indecies = new ArrayList<Integer>();
    for (int x = 1; x <= 6; x++)
      indecies.add((int) Math.pow(10, x));
    int product = 1;
    while (!done) {
      length += String.valueOf(num).length();
      if (length >= indecies.get(0)) {
        int diff = length - indecies.get(0);
        product *= (num % (int) (Math.pow(10, diff + 1)))
            / (int) (Math.pow(10, diff));
        indecies.remove(0);
        if (indecies.size() == 0)
          done = true;
      }
      num++;
    }
    System.out.println(product);
  }

  public static void main(String[] args) {
    new Problem40();
  }
}
