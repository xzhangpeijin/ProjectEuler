package Completed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Problem42 {
  public ArrayList<Integer> triangular = genTriangular(30);

  public Problem42() throws Exception {
    BufferedReader in = new BufferedReader(new FileReader("words.txt"));
    String[] words = in.readLine().split("\",\"");
    words[0] = words[0].substring(1);
    words[words.length - 1] = words[words.length - 1].substring(0,
        words[words.length - 1].length() - 2);

    int total = 0;
    for (int x = 0; x < words.length; x++) {
      int sum = 0;
      for (int y = 0; y < words[x].length(); y++)
        sum += (int) (words[x].charAt(y)) - 64;
      if (triangular.contains(sum)) {
        System.out.println(words[x] + " " + sum);
        total++;
      }
    }
    System.out.println(total);
    in.close();
  }

  public ArrayList<Integer> genTriangular(int a) {
    ArrayList<Integer> results = new ArrayList<Integer>();
    for (int x = 1; x < a; x++)
      results.add(x * (x + 1) / 2);
    return results;
  }

  public static void main(String[] args) throws Exception {
    new Problem42();
  }
}
