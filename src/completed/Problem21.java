package completed;

public class Problem21 {
  public Problem21() {
    int total = 0;
    for (int x = 1; x < 10000; x++) {
      if (sumFactors(sumFactors(x)) == x && sumFactors(x) != x)
        total += x;
    }
    System.out.println(total);
  }

  private int sumFactors(int a) {
    int total = 0;
    for (int x = 1; x <= Math.pow(a, 0.5); x++) {
      if (a % x == 0)
        total += a / x + x;
      if (x == Math.pow(a, 0.5))
        total -= x;
    }
    return total - a;
  }
}
