package completed;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import current.Utils;

public class Problem60 
{
  public Problem60() throws Exception
  {
    List<Integer> primes = Utils.genPrimes(10000);

    Set<Set<Integer>> primegroups = new HashSet<Set<Integer>>();

    for (int prime1 : primes) {
      for (int prime2 : primes) {
        if (prime1 != prime2) {
          int newprime1 = Integer.parseInt(String.valueOf(prime1) + String.valueOf(prime2));
          int newprime2 = Integer.parseInt(String.valueOf(prime2) + String.valueOf(prime1));
          if (Utils.isPrime(newprime1) && Utils.isPrime(newprime2)) {
            Set<Integer> group = new HashSet<Integer>();
            group.add(prime1);
            group.add(prime2);
            primegroups.add(group);
          }
        }
      }
    }

    for (int size = 2; size < 5; size++) {
      System.out.println(size + " " + primegroups.size());
      Set<Set<Integer>> newgroups = new HashSet<Set<Integer>>();
      for (Set<Integer> set : primegroups) {
        for (int prime : primes) {
          boolean works = true;
          for (int inset : set) {
            int newprime1 = Integer.parseInt(String.valueOf(prime) + String.valueOf(inset));
            int newprime2 = Integer.parseInt(String.valueOf(inset) + String.valueOf(prime));
            if (!Utils.isPrime(newprime1) || !Utils.isPrime(newprime2)) {
              works = false;
              break;
            }
          }
          if (works) {
            set.add(prime);
            newgroups.add(set);
            break;
          }
        }
      }
      primegroups = newgroups;
    }
    System.out.println(primegroups.size());

    for (Set<Integer> set : primegroups) {
      int total = 0;
      for (int prime : set) {
        total += prime;
        System.out.println(prime);
      }
      System.out.println(total + "\n");
    }
  }

  public static void main(String[] args) throws Exception
  {
    new Problem60();
  }

}
