package completed;

public class Problem39 {
  public Problem39() {
    int maxsols = 0;
    for (int x = 12; x < 1000; x++) {
      int a = x / 3 + 1;
      int b = x / 2;
      int numsol = 0;
      for (int y = a; y < b; y++)
        if (posSol(x, y))
          numsol++;
      if (numsol > maxsols) {
        System.out.println(x);
        maxsols = numsol;
      }
    }
  }

  public boolean posSol(int total, int hypo) {
    int a = total - hypo;
    for (int x = 3; x < (a / 2) + 1; x++)
      if (Math.pow(x, 2) + Math.pow(a - x, 2) == Math.pow(hypo, 2))
        return true;
    return false;
  }

  public static void main(String[] args) {
    new Problem39();
  }
}
