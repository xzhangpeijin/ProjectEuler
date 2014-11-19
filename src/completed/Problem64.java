package completed;

import java.util.ArrayList;
import java.util.List;

public class Problem64 
{
  public static int gcd(int a, int b) {
    if (b==0) return a;
    return gcd(b,a%b);
 }
  
  static class Remain {
    public int num;
    public int coeff;
    public int delta;
    
    public Remain(int num, int coeff, int delta) {
      int gcd = gcd(gcd(num, coeff), delta);
      this.num = num / gcd;
      this.coeff = coeff / gcd;
      this.delta = delta / gcd;
      if (this.num < 0) {
        this.num *= -1;
        this.coeff *= -1;
        this.delta *= -1;
      }
    }
    
    public boolean equals(Object o) {
      if (o instanceof Remain) {
        Remain r = (Remain) o;
        return r.num == num && r.coeff == coeff && r.delta == delta;
      }
      return false;
    }
    
    public double toVal(double sqrt) {
      return num / (coeff * sqrt + delta);
    }
    
    public String toString() {
      return num + "/(" + coeff + "n + " + delta + ")";
    }
  }
  
  public Problem64() throws Exception
  {
    int count = 0;
    for (int n = 1; n <= 10000; n++) {
      double sqrt = Math.sqrt(n);
      if (sqrt % 1 != 0) {
        List<Remain> remain = new ArrayList<Remain>();
        List<Integer> vals = new ArrayList<Integer>();

        boolean repeat = true;
        int val = (int) Math.floor(sqrt);
        Remain remainder = new Remain(1, 1, -1 * val);
        remain.add(remainder);
        vals.add(val);
        while (repeat) {
          int newval = (int) Math.floor (remainder.toVal(sqrt));
          int newnum = (int) (Math.pow(remainder.coeff, 2) * n - Math.pow(remainder.delta, 2));
          int newdelta = (int) (remainder.num * -1 * remainder.delta - newval * newnum);
          Remain newremain = new Remain(newnum, remainder.num, newdelta);
          if (remain.contains(newremain)) {
            repeat = false;
            int start = remain.indexOf(newremain);
            int period = vals.size() - start;
            if (period % 2 == 1) {
              count++;
            }
          } else {
            val = newval;
            remainder = newremain;
            vals.add(newval);
            remain.add(newremain);
          }
        }
      }
    }
    System.out.println(count);
  }

  public static void main(String[] args) throws Exception
  {
    new Problem64();
  }

}
