package Completed;
import java.math.BigInteger;


public class Problem53 
{
  public Problem53()
  {
    int count = 0;
    for (int n = 1; n <= 100; n++) {
      for (int r = 0; r <= n; r++) {
        if (more1m(n, r)) {
          count++;
        }
      }
    }
    System.out.println(count);
  }
  
  public boolean more1m(int n, int r) {
    BigInteger base = BigInteger.valueOf(1);
    for (int x = 0; x < r; x++) {
      base = base.multiply(BigInteger.valueOf(n - x));
    }
    for (int x = 1; x <= r; x++) {
      base = base.divide(BigInteger.valueOf(x));
    }
    return base.toString().length() >= 7;
  }

  public static void main(String[] args)
  {
    new Problem53();
  }

}
