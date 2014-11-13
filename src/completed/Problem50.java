package completed;

import java.util.ArrayList;

public class Problem50 {
  public ArrayList<Integer> primes = genPrimes(1000000);

  public Problem50() {
    int longest = 1;
    for (int x = 0; x < primes.size(); x++) {
      longest = longestString(x, longest);
    }
  }

  public int longestString(int a, int b) {
    int longest = b;
    int length = 1;
    int sum = primes.get(a);
    while (sum < 1000000 && a + length + 1 < primes.size()) {
      if (primes.contains(sum) && length > longest) {
        longest = length;
        System.out.println(sum);
      }
      sum += primes.get(a + length);
      length++;
    }
    return longest;
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
    new Problem50();
  }

}