package completed;

import java.util.ArrayList;

public class Problem37 {
  public ArrayList<Integer> primes = genPrimes(1000000);

  public Problem37() {
    int sum = 0;
    for (int x = 4; x < primes.size(); x++) {
      if (isTrunc(primes.get(x))) {
        sum += primes.get(x);
        System.out.println(sum);
      }
    }
  }

  public boolean isTrunc(int a) {
    int temp = a;
    while (temp > 0) {
      if (!primes.contains(temp))
        return false;
      temp /= 10;
    }

    temp = a;
    while (temp > 0) {
      if (!primes.contains(temp))
        return false;
      temp = (int) (temp % Math.pow(10, String.valueOf(temp).length() - 1));
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

  public static void main(String[] args) {
    new Problem37();
  }
}
