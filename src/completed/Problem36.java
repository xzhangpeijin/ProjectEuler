package completed;

public class Problem36 {
  public Problem36() {
    int sum = 0;
    for (int x = 0; x < 500000; x++) {
      int temp = 2 * x + 1;
      if (isPal(String.valueOf(temp)))
        if (isPal(String.valueOf(toBase2(temp))))
          sum += temp;
    }
    System.out.println(sum);
  }

  public boolean isPal(String a) {
    for (int x = 0; x < a.length() / 2 + 1; x++) {
      int temp = a.length() - 1 - x;
      if (a.charAt(temp) != a.charAt(x))
        return false;
    }
    return true;
  }

  public String toBase2(int a) {
    String result = "";
    while (a > 0) {
      result = String.valueOf(a % 2) + result;
      a /= 2;
    }
    return result;
  }

  public static void main(String[] args) {
    new Problem36();
  }
}
