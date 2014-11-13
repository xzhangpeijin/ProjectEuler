package completed;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem49 {
  public ArrayList<Integer> primes = genPrimes(10000);

  public Problem49() {
    while (primes.get(0) < 1000)
      primes.remove(0);

    ArrayList<Integer> done = new ArrayList<Integer>();
    for (int x = 0; x < primes.size(); x++) {
      ArrayList<Integer> temp = primePer(primes.get(x));
      if (temp.size() >= 3) {
        int[] per = new int[3];
        for (int a = 0; a < temp.size(); a++) {
          for (int b = 0; b < temp.size(); b++) {
            if (a != b) {
              for (int c = 0; c < temp.size(); c++) {
                if (a != c && b != c) {
                  per[0] = temp.get(a);
                  per[1] = temp.get(b);
                  per[2] = temp.get(c);
                  if (isArith(per) && !done.contains(per[0])) {
                    done.add(per[0]);
                    System.out.println(per[0] + "" + per[1] + "" + per[2]);
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public boolean isArith(int[] a) {
    Arrays.sort(a);
    if (a[2] - a[1] == a[1] - a[0] && a[2] - a[1] != 0)
      return true;
    return false;
  }

  public ArrayList<Integer> primePer(int x) {
    ArrayList<Integer> perprimes = new ArrayList<Integer>();
    int[] digits = new int[4];
    digits[0] = x / 1000;
    digits[1] = (x / 100) % 10;
    digits[2] = (x / 10) % 10;
    digits[3] = x % 10;

    for (int a = 0; a < 4; a++)
      for (int b = 0; b < 4; b++)
        if (a != b)
          for (int c = 0; c < 4; c++)
            if (a != c && b != c)
              for (int d = 0; d < 4; d++)
                if (a != d && b != d && c != d)
                  if (primes.contains(1000 * digits[a] + 100 * digits[b] + 10
                      * digits[c] + digits[d]))
                    perprimes.add(1000 * digits[a] + 100 * digits[b] + 10
                        * digits[c] + digits[d]);
    return perprimes;
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

  public static void main(String[] args) {
    new Problem49();
  }
}
