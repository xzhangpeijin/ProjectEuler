package Completed;

import java.util.ArrayList;

public class Problem41 {
  // public ArrayList<Integer> primes = genPrimes(100000000);

  public Problem41() {
    ArrayList<Integer> pandig = new ArrayList<Integer>();
    for (int x = 7000000; x < 8000000; x++) {
      if (isPandigital(x))
        pandig.add(x);
    }
    for (int x = 0; x < pandig.size(); x++)
      if (isPrime(pandig.get(x)))
        System.out.println(pandig.get(x));
  }

  public boolean isPrime(int a) {
    if (a % 2 == 0 || a % 3 == 0)
      return false;
    for (int x = 1; x <= Math.pow(a, 0.5) / 6; x++) {
      if (a % (6 * x + 1) == 0)
        return false;
      if (a % (6 * x - 1) == 0)
        return false;
    }
    return true;
  }

  public ArrayList<Integer> genPrimes(int a) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    int[] num = new int[a];
    for (int x = 0; x < a; x++)
      num[x] = x + 1;
    for (int x = 0; x < a; x++) {
      if (num[x] != 1) {
        result.add(num[x]);
        int sum = num[x];
        while (sum <= a) {
          num[sum - 1] = 1;
          sum += result.get(result.size() - 1);
        }
      }
    }
    return result;
  }

  public boolean isPandigital(int a) {
    ArrayList<Integer> digits = new ArrayList<Integer>();
    for (int x = 1; x <= String.valueOf(a).length(); x++)
      digits.add(x);
    while (a > 0) {
      digits.remove(new Integer(a % 10));
      a /= 10;
    }
    if (digits.size() > 0)
      return false;
    return true;
  }

  public static void main(String[] args) {
    new Problem41();
  }
}