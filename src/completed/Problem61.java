package completed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Brute force is too slow, need to create a prefix/suffix map to trim the search space
 */
public class Problem61 
{
  static enum Type {
    TRIANGLE, SQUARE, PENTAGONAL, HEXAGONAL, HEPTAGONAL, OCTAGONAL;
  }

  static class Suffix {
    public Type type;
    public int val;

    public Suffix(Type type, int val) {
      this.type = type;
      this.val = val;
    }
  }

  static class State {
    public List<Integer> vals;
    public Set<Type> used;
    public int suffix;

    public State(int starting) {
      this.vals = new ArrayList<Integer>();
      this.used = new HashSet<Type>();
      this.suffix = starting % 100;
      this.vals.add(starting);
      this.used.add(Type.OCTAGONAL);
    }

    public State(State state, Suffix newval) {
      this.vals = new ArrayList<Integer>(state.vals);
      this.used = new HashSet<Type>(state.used);
      this.used.add(newval.type);
      this.vals.add(state.suffix * 100 + newval.val);
      this.suffix = newval.val;
    }
  }

  public Map<Integer, Set<Suffix>> prefixmap = new HashMap<Integer, Set<Suffix>>();

  public Problem61() throws Exception
  {
    Queue<State> search = new LinkedList<State>();

    int n = 1;
    boolean bounds = true;
    while (bounds) {
      int tri = n * (n + 1) / 2;
      int sq = n * n;
      int pent = n * (3 * n - 1) / 2;
      int hex = n * (2 * n - 1);
      int hept = n * (5 * n - 3) / 2;
      int oct = n * (3 * n - 2);

      if (tri < 10000 && tri >= 1000)
        addPrefix(tri / 100, new Suffix(Type.TRIANGLE, tri % 100));
      if (sq < 10000 && sq >= 1000)
        addPrefix(sq / 100, new Suffix(Type.SQUARE, sq % 100));
      if (pent < 10000 && pent >= 1000)
        addPrefix(pent / 100, new Suffix(Type.PENTAGONAL, pent % 100));
      if (hex < 10000 && hex >= 1000)
        addPrefix(hex / 100, new Suffix(Type.HEXAGONAL, hex % 100));
      if (hept < 10000 && hept >= 1000)
        addPrefix(hept / 100, new Suffix(Type.HEPTAGONAL, hept % 100));
      if (oct < 10000 && oct >= 1000)
        search.add(new State(oct));

      bounds &= (tri < 10000);
      n++;
    }

    while (search.size() > 0) {
      State cur = search.poll();

      if (cur.vals.size() == 6 && cur.used.size() == 6 && 
          (cur.vals.get(0) / 100 == cur.vals.get(5) % 100)) {
        int sum = 0;
        for (int val : cur.vals) {
          System.out.println(val);
          sum += val;
        }
        System.out.println();
        System.out.println(sum);
      } else {
        Set<Suffix> candidates = prefixmap.get(cur.suffix);
        if (candidates != null) {
          for (Suffix suff : candidates) {
            if (!cur.used.contains(suff.type)) {
              State newstate = new State(cur, suff);
              search.add(newstate);
            }
          }
        }
      }
    }
  }

  public void addPrefix(int prefix, Suffix value) {
    if (!prefixmap.containsKey(prefix)) {
      prefixmap.put(prefix, new HashSet<Suffix>());
    }
    prefixmap.get(prefix).add(value);
  }


  public static void main(String[] args) throws Exception
  {
    new Problem61();
  }

}
