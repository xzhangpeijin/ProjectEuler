package Completed;

public class Problem28 {
  public Problem28() {
    int sum = 1;
    for (int x = 1; x <= 500; x++) {
      int num = 2 * x + 1;
      sum += Math.pow(num, 2);
      sum += 3 * Math.pow(num - 1, 2) + 3;
    }
    System.out.println(sum);
  }

  public static void main(String[] args) {
    new Problem28();
  }
}
