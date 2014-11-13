package Completed;

import java.util.ArrayList;

public class Problem26 {
  private int longestrepeat = 0, index = 0;

  public Problem26() {
    for (int x = 1; x < 1000; x++) {
      genRepeat(x);
    }
    System.out.println(longestrepeat + " " + index);
  }

  public void genRepeat(int b) {
    int remainder = 1;
    ArrayList<Integer> remainders = new ArrayList<Integer>();
    boolean repeat = true;
    while (repeat) {
      remainder *= Math.pow(10,
          String.valueOf(b).length() - String.valueOf(remainder).length() + 1);
      remainder = remainder % b;
      if (remainders.contains(new Integer(remainder))) {
        repeat = false;
        int length = remainders.size()
            - remainders.indexOf(new Integer(remainder));
        if (length > longestrepeat) {
          longestrepeat = length;
          index = b;
        }
        System.out.println(b + " " + length);
      } else
        remainders.add(new Integer(remainder));
    }
  }
}
