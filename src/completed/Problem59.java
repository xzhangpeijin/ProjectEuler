package completed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class Problem59 
{
  public URL input = Problem59.class.getResource("/cipher.txt");
  public URL wordref = Problem59.class.getResource("/common-words.txt");
  
  public Problem59() throws Exception
  {
    Set<String> common = new HashSet<String>();
    BufferedReader wr = new BufferedReader(new InputStreamReader(wordref.openStream()));
    String[] words = wr.readLine().split(",");
    for (String word : words) {
      common.add(word);
    }
    wr.close();
    
    List<Byte> data = new ArrayList<Byte>();
    BufferedReader dr = new BufferedReader(new InputStreamReader(input.openStream()));
    String[] dat = dr.readLine().split(",");
    for (String val : dat) {
      data.add(new Byte(val));
    }
    dr.close();
    
    String trueval = null;
    int maxcommon = -1;
    for (char a = 'a'; a <= 'z'; a++) {
      for (char b = 'a'; b <= 'z'; b++) {
        for (char c = 'a'; c <= 'z'; c++) {
          String password = new String(new char[]{a, b, c});
          String decoded = decode(password, data);
          
          int commoncount = 0;
          for (String word : common) {
            commoncount += StringUtils.countMatches(decoded, word);
          }
          
          if (commoncount > maxcommon) {
            trueval = decoded;
            maxcommon = commoncount;
          }
        }
      }
    }
    
    int sum = 0;
    for (int x = 0; x < trueval.length(); x++) {
      sum += trueval.charAt(x);
    }
    System.out.println(sum);
    
  }
  
  public String decode(String password, List<Byte> data) {
    StringBuffer result = new StringBuffer();
    int index = 0;
    for (Byte dat : data) {
      result.append((char)(dat ^ password.charAt(index)));
      index++;
      if (index == password.length()) {
        index = 0;
      }
    }
    return result.toString();
  }

  public static void main(String[] args) throws Exception
  {
    new Problem59();
  }

}
