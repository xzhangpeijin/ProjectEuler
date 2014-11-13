package Completed;

import java.util.ArrayList;

public class Problem27 {
  public ArrayList<Integer> primes = genPrimes(10000);

  public Problem27() {
    int maxlength = 0;
    ArrayList<Integer> sprimes = genPrimes(1000);
    int num = sprimes.size();
    for (int x = 0; x < num; x++)
      sprimes.add(sprimes.get(x) * -1);
    ArrayList<Integer> sodds = new ArrayList<Integer>();
    for (int x = 0; x < 500; x++) {
      sodds.add(2 * x + 1);
      sodds.add(-2 * x - 1);
    }
    for (int a = 0; a < sprimes.size(); a++) {
      for (int b = 0; b < sodds.size(); b++) {
        int index = maxlength + 1;
        int sum = (int) (Math.pow(index, 2) + index * sodds.get(b) + sprimes
            .get(a));
        if (isPrime(sum)) {
          index--;
          while (isPrime(sum) && index != 0) {
            index--;
            sum = (int) (Math.pow(index, 2) + index * sodds.get(b) + sprimes
                .get(a));
          }
          if (index == 0) {
            index = maxlength + 2;
            while (isPrime(sum)) {
              index++;
              sum = (int) (Math.pow(index, 2) + index * sodds.get(b) + sprimes
                  .get(a));
            }
            maxlength = index - 1;
            System.out.println(sprimes.get(a) * sodds.get(b));
          }
        }
      }
    }
  }

  public boolean isPrime(int a) {
    if (primes.contains(a))
      return true;
    return false;
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
    new Problem27();
  }

}
