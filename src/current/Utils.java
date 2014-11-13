package current;
import java.util.ArrayList;
import java.util.List;


/**
 * Stored code for general tasks
 */
public class Utils 
{
  /**
   * Gens primes using sieve method
   */
  public static List<Integer> genPrimes(int a)
  {
    List<Integer> result = new ArrayList<Integer>();
    int[] num = new int[a];
    for(int x = 0; x < a; x++)
      num[x] = x + 1;
    for(int x = 0; x < a; x++)
    {
      if(num[x] != 1)
      {
        result.add(num[x]);
        int val = num[x];
        int sum = val;
        while(sum <= a)
        {
          num[sum - 1] = 1;
          sum += val;
        }
      }
    } 
    return result;
  }
  
  /**
   * Check primality
   */
  public static boolean isPrime(int a) {
    for (int x = 2; x <= Math.sqrt(a); x++) {
      if (a % x == 0) {
        return false;
      }
    }
    return true;
  }
}
