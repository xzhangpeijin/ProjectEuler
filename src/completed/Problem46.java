package completed;

import java.util.ArrayList;

public class Problem46 {
  public ArrayList<Integer> primes = genPrimes(10000000);

  public Problem46() {
    for (int x = 1; x < 5000000; x++) {
      int a = 2 * x + 1;
      if (!primes.contains(a)) {
        int square = 1;
        while (!primes.contains((int) (a - 2 * Math.pow(square, 2)))) {
          square++;
          if (a - 2 * Math.pow(square, 2) < 1) {
            System.out.println(a);
            x = 5000000;
            break;
          }
        }
      }
    }
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
    new Problem46();
  }
}
