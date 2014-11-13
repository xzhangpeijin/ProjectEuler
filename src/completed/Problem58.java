package completed;


public class Problem58 
{
  public Problem58() throws Exception
  {
    double ratio = 1;
    int side = 1;
    int count = 0;
    while (ratio > 0.10) {
      side += 2;
      int square = (int) Math.pow(side, 2);
      if (isPrime(square - (side - 1)))
        count++;
      if (isPrime(square - 2 * (side - 1)))
        count++;
      if (isPrime(square - 3 * (side - 1)))
        count++;
      ratio = (double) count / (2 * side - 1);
      System.out.println(side + " " + ratio + " " + count);
    }
  }
  
  public static boolean isPrime(int a) {
    for (int x = 2; x <= Math.sqrt(a); x++) {
      if (a % x == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception
  {
    new Problem58();
  }

}
