package completed;

import java.math.BigInteger;

public class Problem65 
{
  public Problem65() throws Exception
  {
    BigInteger oldnum = BigInteger.valueOf(2);
    BigInteger olddenom = BigInteger.ONE;
    BigInteger num = BigInteger.valueOf(3);
    BigInteger denom = BigInteger.ONE;
    int k = 1;
    for (int i = 2; i < 100; i++) {
      BigInteger val = BigInteger.ONE;
      if (i % 3 == 2) {
        val = BigInteger.valueOf(2 * k);
        k++;
      }
      BigInteger tempnum = oldnum;
      BigInteger tempdenom = olddenom;
      oldnum = num;
      olddenom = denom;
      num = num.multiply(val).add(tempnum);
      denom = denom.multiply(val).add(tempdenom);
    }
    
    String ans = num.toString();
    int sum = 0;
    for (int x = 0; x < ans.length(); x++) 
      sum += ans.charAt(x) - '0';
    System.out.println(sum);
  }
  

  public static void main(String[] args) throws Exception
  {
    new Problem65();
  }

}
