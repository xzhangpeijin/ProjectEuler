package completed;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem63 
{
  public Problem63() throws Exception
  {
    Set<BigInteger> valid = new HashSet<BigInteger>();
    for (int n = 1; n < 100; n++) {
      for (int pow = 1; pow < 100; pow++) {
        BigInteger val = BigInteger.valueOf(n).pow(pow);
        if (val.toString().length() == pow) {
          valid.add(val);
        }
      }
    }
    System.out.println(valid.size());
  }

  public static void main(String[] args) throws Exception
  {
    new Problem63();
  }

}
