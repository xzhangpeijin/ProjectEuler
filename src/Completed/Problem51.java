package Completed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem51 
{
  public boolean[] match;
  
  public Problem51()
  {
    List<String> primes = genPrimes(10000000);
    List<String> equalsize = new ArrayList<String>();
    System.out.println("Primes generated");
    
    int index = 0;
    int len = 1;
    while (index < primes.size()) {
      equalsize.clear();
      while(String.valueOf(primes.get(index)).length() == len) {
        equalsize.add(primes.get(index));
        index++;
        if (index == primes.size()) break;
      }
      System.out.println(equalsize.size());
      
      match = new boolean[len];

      Map<String, Set<String>> patternmap = new HashMap<String, Set<String>>();

      for (String primeA : equalsize) {
        for (String primeB : equalsize) {
          if (primeA != primeB) {
            String pattern = getPattern(primeA, primeB);
            if (pattern != null) {
              if (!patternmap.containsKey(pattern)) {
                patternmap.put(pattern, new HashSet<String>());
              }
              patternmap.get(pattern).add(primeA);
              patternmap.get(pattern).add(primeB);
            }
          }
        }
      }

      int max = -1;
      for (String pattern : patternmap.keySet()) {
        Set<String> linked = patternmap.get(pattern);
        max = Math.max(max, linked.size());
        if (linked.size() == 8) {
          for (String prime : linked) {
            System.out.println(prime);
          }
          System.out.println();
        }
      }
      System.out.format("Len: %d Max: %d%n%n", len, max);

      len++;
    }
  }

  public String getPattern(String a, String b) {
    char diffa = 'X';
    char diffb = 'X';
    for (int x = 0; x < a.length(); x++) {
      match[x] = (a.charAt(x) == b.charAt(x));
      
      if (!match[x]) {
        if (diffa == 'X' && diffb == 'X') {
          diffa = a.charAt(x);
          diffb = b.charAt(x);
        } else {
          if (a.charAt(x) != diffa || b.charAt(x) != diffb) 
            return null;
        }
      }
    }

    char[] pat = new char[a.length()];

    for (int x = 0; x < a.length(); x++) {
      if (match[x]) {
        pat[x] = a.charAt(x);
      } else {
        pat[x] = '*';
      }
    }

    return new String(pat);
  }

  /**
   * Gens primes using sieve method
   */
  public List<String> genPrimes(int a)
  {
    List<String> result = new ArrayList<String>();
    int[] num = new int[a];
    for(int x = 0; x < a; x++)
      num[x] = x + 1;
    for(int x = 0; x < a; x++)
    {
      if(num[x] != 1)
      {
        result.add(String.valueOf(num[x]));
        int val = num[x];
        int sum = val;
        while(sum <= a)
        {
          num[sum - 1] = 1;
          sum += val;
        }
      }
    }	
    return result;
  }

  public static void main(String[] args)
  {
    new Problem51();
  }

}
