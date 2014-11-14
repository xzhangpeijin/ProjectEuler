package current;

import java.util.ArrayList;
import java.util.List;

public class Problem64 
{
  public Problem64() throws Exception
  {
    for (int n = 1; n <= 100000; n++) {
      List<Integer> vals = new ArrayList<Integer>();
      double sqrt = Math.sqrt(n);
      if (sqrt % 1 != 0) {
        boolean repeat = false;
        double val = sqrt;
        while (repeat) {
        }
      }
    }
  }

  public static void main(String[] args) throws Exception
  {
    new Problem64();
  }

}
