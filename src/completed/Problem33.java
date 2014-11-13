package completed;

public class Problem33 {
  public Problem33() {
    for (int x = 1; x < 10; x++) {
      for (int y = x; y < 10; y++) {
        for (int z = 1; z < 10; z++) {
          int a = 10 * x + y;
          int b = 10 * y + z;
          double temp = (double) a / b;
          double next = (double) x / z;
          if (temp == next && temp != 1.0 && next != 0.0)
            System.out.println(a + " " + b + " " + temp + " " + next);
        }
      }
    }
  }

  public static void main(String[] args) {
    new Problem33();
  }
}
