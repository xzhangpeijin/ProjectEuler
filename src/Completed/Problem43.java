package Completed;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem43 {
  public Problem43() {
    ArrayList<String> pandig = genPandig();
    BigInteger result = new BigInteger("0");

    for (int x = 0; x < pandig.size(); x++)
      result = result.add(new BigInteger(pandig.get(x)));

    System.out.println(result.toString());
  }

  public ArrayList<String> genPandig() {
    ArrayList<String> result = new ArrayList<String>();
    for (int a = 1; a < 10; a++) {
      for (int b = 0; b < 10; b++) {
        if (a != b) {
          for (int c = 0; c < 10; c++) {
            if (a != c && b != c) {
              for (int x = 0; x < 5; x++) {
                int d = 2 * x;
                if (a != d && b != d && c != d) {
                  for (int e = 0; e < 10; e++) {
                    if (a != e && b != e && c != e && d != e
                        && (c + d + e) % 3 == 0) {
                      for (int y = 0; y < 2; y++) {
                        int f = 5 * y;
                        if (a != f && b != f && c != f && d != f && e != f) {
                          for (int g = 0; g < 10; g++) {
                            if (a != g && b != g && c != g && d != g && e != g
                                && f != g && (100 * e + 10 * f + g) % 7 == 0) {
                              for (int h = 0; h < 10; h++) {
                                if (a != h && b != h && c != h && d != h
                                    && e != h && f != h && g != h
                                    && (100 * f + 10 * g + h) % 11 == 0) {
                                  for (int i = 0; i < 10; i++) {
                                    if (a != i && b != i && c != i && d != i
                                        && e != i && f != i && g != i && h != i
                                        && (100 * g + 10 * h + i) % 13 == 0) {
                                      for (int j = 0; j < 10; j++) {
                                        if (a != j && b != j && c != j
                                            && d != j && e != j && f != j
                                            && g != j && h != j && i != j
                                            && (100 * h + 10 * i + j) % 17 == 0) {
                                          String temp = "";
                                          temp += String.valueOf(a)
                                              + String.valueOf(b)
                                              + String.valueOf(c)
                                              + String.valueOf(d)
                                              + String.valueOf(e)
                                              + String.valueOf(f)
                                              + String.valueOf(g)
                                              + String.valueOf(h)
                                              + String.valueOf(i)
                                              + String.valueOf(j);
                                          System.out.println(temp);
                                          result.add(temp);
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    new Problem43();
  }
}
