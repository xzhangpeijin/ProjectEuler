package completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem62 
{
  static class Count {
    private int[] counts;
    public Count(long a) {
      this.counts = new int[10];
      while (a > 0) {
        counts[(int)(a % 10)]++;
        a /= 10;
      }
    }
    
    @Override
    public boolean equals(Object o) {
      if (o instanceof Count) {
        Count count = (Count) o;
        for (int x = 0; x < 10; x++) {
          if (counts[x] != count.counts[x]) 
            return false;
        }
        return true;
      }
      return false;
    }
    
    @Override
    public int hashCode() {
      return Arrays.hashCode(counts);
    }
  }
  
  public Problem62() throws Exception
  {
    Map<Count, List<Long>> counts = new HashMap<Count, List<Long>>();
    
    int max = 0;
    int n = 1;
    while (max < 5) {
      long cube = (long) Math.pow(n, 3);
//      System.out.println(n + " " + cube);
      Count count = new Count(cube);
      if (!counts.containsKey(count)) {
        counts.put(count, new ArrayList<Long>());
      }
      counts.get(count).add(cube);
      max = Math.max(max, counts.get(count).size());
      if (max == 5) {
        for (long val : counts.get(count)) 
          System.out.println(val);
      }
      n++;
    }
  }

  public static void main(String[] args) throws Exception
  {
    new Problem62();
  }

}
