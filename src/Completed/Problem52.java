package Completed;

import java.util.ArrayList;

public class Problem52 {
  public Problem52() {
    int num = 1;
    boolean found = false;
    while (!found) {
      while (!isDistinct(num))
        num++;
      int[] possible = new int[6];
      for (int x = 0; x < 6; x++)
        possible[x] = num * (x + 1);

      if (isValid(possible)) {
        found = true;
        System.out.println(num);
      }

      num++;
      if (String.valueOf(6 * num).length() > String.valueOf(num).length())
        num = (int) Math.pow(10, String.valueOf(num).length());
    }
  }

  public boolean isDistinct(int num) {
    ArrayList<Integer> digits = new ArrayList<Integer>();
    while (num > 0) {
      if (digits.contains(num % 10))
        return false;
      digits.add(num % 10);
      num /= 10;
    }
    return true;
  }

  public boolean isValid(int[] a) {
    ArrayList<Integer> digits = new ArrayList<Integer>();
    int num = a[0];
    while (num > 0) {
      digits.add(num % 10);
      num /= 10;
    }
    for (int x = 1; x < 6; x++) {
      ArrayList<Integer> tempdigits = new ArrayList<Integer>();
      for (int y = 0; y < digits.size(); y++)
        tempdigits.add(new Integer(digits.get(y)));
      int temp = a[x];
      while (temp > 0) {
        tempdigits.remove(new Integer(temp % 10));
        temp /= 10;
      }
      if (tempdigits.size() != 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    new Problem52();
  }
}
