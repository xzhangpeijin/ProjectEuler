package Completed;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem45 {
  public ArrayList<BigInteger> triangular = genTriangular(999999);
  public ArrayList<BigInteger> pentagonal = genPentagonal(999999);
  public ArrayList<BigInteger> hexagonal = genHexagonal(100000);

  public Problem45() {
    for (int x = 143; x < 99999; x++) {
      BigInteger a = hexagonal.get(x);
      if (triangular.contains(a) && pentagonal.contains(a))
        System.out.println(a);
    }
  }

  public ArrayList<BigInteger> genTriangular(int a) {
    ArrayList<BigInteger> results = new ArrayList<BigInteger>();
    for (int x = 1; x < a; x++) {
      BigInteger m = new BigInteger(String.valueOf(x));
      BigInteger n = new BigInteger(String.valueOf(x + 1));
      results.add(m.multiply(n).divide(new BigInteger("2")));
    }
    return results;
  }

  public ArrayList<BigInteger> genPentagonal(int a) {
    ArrayList<BigInteger> results = new ArrayList<BigInteger>();
    for (int x = 1; x < a; x++) {
      BigInteger m = new BigInteger(String.valueOf(x));
      BigInteger n = new BigInteger(String.valueOf(3 * x - 1));
      results.add(m.multiply(n).divide(new BigInteger("2")));
    }
    return results;
  }

  public ArrayList<BigInteger> genHexagonal(int a) {
    ArrayList<BigInteger> results = new ArrayList<BigInteger>();
    for (int x = 1; x < a; x++) {
      BigInteger m = new BigInteger(String.valueOf(x));
      BigInteger n = new BigInteger(String.valueOf(2 * x - 1));
      results.add(m.multiply(n));
    }
    return results;
  }

  public static void main(String[] args) {
    new Problem45();
  }
}
