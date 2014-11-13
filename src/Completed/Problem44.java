package Completed;

import java.util.ArrayList;

public class Problem44 {
  public ArrayList<Integer> pent = genPent(100000);

  public Problem44() {
    for (int x = 0; x < pent.size(); x++) {
      System.out.println(pent.get(x));
      if (isValid(x)) {
        x = pent.size();
      }
    }
  }

  public boolean isValid(int a) {
    int num = pent.get(a);
    for (int x = a - 1; x > 0; x--) {
      int sum = num + pent.get(x);
      int diff = num - pent.get(x);
      if (isPent(sum) && isPent(diff)) {
        System.out.println(diff);
        return true;
      }
    }
    return false;

  }

  public boolean isPent(int a) {
    double temp = (Math.pow(24 * a + 1.0, 0.5) + 1) / 6.0;
    if (temp - (int) (temp) == 0)
      return true;
    return false;
  }

  public ArrayList<Integer> genPent(int a) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int x = 1; x <= a; x++)
      result.add(x * (3 * x - 1) / 2);
    return result;
  }

  public static void main(String[] args) {
    new Problem44();
  }
}