package Completed;

import java.util.ArrayList;

public class Problem23 {
  private ArrayList<Integer> abundant = new ArrayList<Integer>();

  public Problem23() {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int x = 1; x <= 28123; x++) {
      numbers.add(new Integer(x));
      if (x < sumFactors(x))
        abundant.add(x);
    }

    for (int x = 0; x < abundant.size(); x++) {
      for (int y = x; y < abundant.size(); y++) {
        int sum = abundant.get(x).intValue() + abundant.get(y).intValue();
        if (sum > 28123)
          y = abundant.size();
        if (numbers.contains(new Integer(sum)))
          numbers.remove(new Integer(sum));

        System.out.println(x + " " + y);
      }
    }

    int total = 0;
    for (int x = 0; x < numbers.size(); x++)
      total += numbers.get(x).intValue();
    System.out.println(total);
  }

  private int sumFactors(int a) {
    int total = 0;
    for (int x = 1; x <= Math.pow(a, 0.5); x++) {
      if (a % x == 0)
        total += a / x + x;
      if (x == Math.pow(a, 0.5))
        total -= x;
    }
    return total - a;
  }
}
