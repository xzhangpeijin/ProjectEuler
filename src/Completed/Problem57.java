package Completed;
import java.math.BigInteger;


public class Problem57 
{
  public Problem57() throws Exception
  {
    BigInteger num = BigInteger.valueOf(1);
    BigInteger denom = BigInteger.valueOf(1);
    int count = 0;
    for (int i = 0; i < 1000; i++) {
      BigInteger newdenom = denom.add(num);
      BigInteger newnum = newdenom.add(denom);
      
      denom = newdenom;
      num = newnum;
      
      if (num.toString().length() > denom.toString().length()) {
        count++;
      }
    }
    System.out.println(count);
  }

  public static void main(String[] args) throws Exception
  {
    new Problem57();
  }

}
