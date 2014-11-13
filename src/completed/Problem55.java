package completed;
import java.math.BigInteger;


public class Problem55 
{
  public Problem55() throws Exception
  {
    int count = 0;
    for (int x = 1; x < 10000; x++) {
      String val = String.valueOf(x);
      boolean lychrel = true;
      for (int i = 0; i < 50; i++) {
        val = iterate(val);
        if (isPalindrome(val)) {
          lychrel = false;
          break;
        }
      }
      if (lychrel) {
        count++;
      }
    }
    System.out.println(count);
  }
  
  public String iterate(String val) {
    BigInteger norm = new BigInteger(val);
    BigInteger reverse = new BigInteger(new StringBuffer(val).reverse().toString());
    return norm.add(reverse).toString();
  }
  
  public boolean isPalindrome(String val) {
    for (int x = 0; x < val.length() / 2; x++) {
      if (val.charAt(x) != val.charAt(val.length() - 1 - x)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception
  {
    new Problem55();
  }

}
