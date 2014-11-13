package Completed;
import java.math.BigInteger;


public class Problem56 
{
  public Problem56() throws Exception
  {
    int max = -1;
    for (int a = 1; a < 100; a++) {
      for (int b = 1; b < 100; b++) {
        max = Math.max(max, digitsum(a, b));
      }
    }
    System.out.println(max);
  }
  
  public int digitsum(int a, int b) {
    BigInteger base = BigInteger.valueOf(a);
    String result = base.pow(b).toString();
    int tot = 0;
    for (int x = 0; x < result.length(); x++) {
      tot += result.charAt(x) - '0';
    }
    return tot;
  }

  public static void main(String[] args) throws Exception
  {
    new Problem56();
  }

}
